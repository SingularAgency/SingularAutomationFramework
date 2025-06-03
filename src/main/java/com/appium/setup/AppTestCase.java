package com.appium.setup;

import java.io.*;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.appium.util.ConfigKey;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.appium.util.CommonUtil;
import com.appium.util.TestNgListeners;
import com.appium.util.actiondriver.BaseActionDriver;
import com.appium.util.actiondriver.MobileActionDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

@Listeners(TestNgListeners.class)
public abstract class AppTestCase {
	protected abstract void cleanPageObjects();
	public AppiumDriverLocalService service;
	public String deviceName;
	public BaseActionDriver actionDriver;
	public CommonUtil common;
	public ExtentTest test;
	public static int WAIT_TIMEOUT;
	public String testCaseName;
	public Throwable Error = null;
	public int counter;
	private String testId;

	public static ExtentReports reports;


	protected static ThreadLocal<BaseActionDriver> actionDriverThread = new ThreadLocal<BaseActionDriver>();
	protected static ThreadLocal<CommonUtil> commonThread = new ThreadLocal<CommonUtil>();
	protected static ThreadLocal<ExtentTest> testThread = new ThreadLocal<ExtentTest>();
	
	public static ExtentTest getTest() {
		return testThread.get();
	}
	public static Properties CONFIG;
	public static FileInputStream fn;
	public static CommonUtil getCommon() {
		return commonThread.get();
	}
	public static String appBundleId;
	private Process emulatorProcess;  // To hold emulator process reference

	public static BaseActionDriver getActionDriver() {
		return actionDriverThread.get();
	}
	
	@BeforeClass
	public void configureAppium() throws Exception {
		CONFIG = new Properties();
		String baseFilePath = System.getProperty("user.dir") + "/src/main/resources/config/";
		String filePath = null;
		filePath = baseFilePath + "config.properties";
		fn = new FileInputStream(filePath);
		CONFIG.load(fn);
		String avdName = CONFIG.getProperty("DEVICE_NAME"); // Add this property to your config.properties
		// Detect if running in GitHub Actions CI environment
		String githubActions = System.getenv("GITHUB_ACTIONS");
		if ((githubActions == null || !githubActions.equalsIgnoreCase("true")) && avdName != null && !avdName.isEmpty()) {
			// Only start emulator manually if NOT running in GitHub Actions
			//startEmulator(avdName);
		} else {
			System.out.println("Skipping emulator start in CI environment.");
		}

		Map<String , String> env = new HashMap<String , String>(System.getenv());
		env.put("ANDROID_HOME", CONFIG.getProperty(ConfigKey.ANDROID_HOME));
		env.put("PATH", CONFIG.getProperty(ConfigKey.PATH));
		env.put("JAVA_HOME", CONFIG.getProperty(ConfigKey.JAVA_HOME));
		env.put("SDKROOT", CONFIG.getProperty(ConfigKey.SDKROOT));
		appBundleId= CONFIG.getProperty(ConfigKey.APP_PACKAGE);
		//env.put("PATH", "/Applications/Xcode.app");
		this.service = new AppiumServiceBuilder().withAppiumJS(new File(CONFIG.getProperty(ConfigKey.APPIUM_FILE_PATH)))
				.withIPAddress("127.0.0.1").usingPort(4723).withEnvironment(env).withTimeout(Duration.ofSeconds(300)).build();
		service.start();
	}
	
	@BeforeMethod(groups = { "smoke", "prod" }, alwaysRun = true)
	@Parameters({ "device" })
	public synchronized void setUp(@Optional String device, Method method) throws Exception {
		try {

			testCaseName = method.getName();
			actionDriver.setDeviceName(deviceName);
			actionDriver.setTestCaseName(testCaseName);
			testThread.set(reports.startTest(actionDriver.getDeviceName() + " " + common.testCaseId + "-" + testCaseName, ""));
			test = testThread.get();
			common.initializeLogs(test);
			counter = counter + 1;
			if(actionDriver.getDeviceName().equalsIgnoreCase("Android")) {
				common.initializeAppiumDriver(deviceName);
			}else if(actionDriver.getDeviceName().equalsIgnoreCase("iOS")) {
				common.initializeAppiumDriver(deviceName);
			}

		} catch (Throwable t) {
			t.printStackTrace();
			if (actionDriver.getAppiumDriver() != null) {
				actionDriver.quit();
			}

			throw new SkipException("Skipping test case due to following error : " + t.getMessage());
		}

	}

	public void initializeAppTest(String testId, String device) throws Exception {
		actionDriverThread.set(new MobileActionDriver());
		commonThread.set(new CommonUtil(getActionDriver()));
		getActionDriver().initializeLogging();
		getCommon().testCaseId = testId;
		this.setTestId(testId);
		CommonUtil.setInitialConfigurations(device);
		deviceName =device;
		this.common = getCommon();
		this.actionDriver = getActionDriver();
	}

	@AfterMethod(alwaysRun = true)
	public synchronized void tearDown() {
		reports.flush();
		closeDriver();

	}

	public void closeDriver() {
		this.actionDriver.getAppiumDriver().quit();

	}

	@AfterClass(alwaysRun=true)
	public synchronized void stopService() {
		if (service != null && service.isRunning()) {
			service.stop();
		}
		stopEmulator();  // Stop emulator after Appium service
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public void startEmulator(String avdName) throws Exception {
		String emulatorPath = CONFIG.getProperty(ConfigKey.ANDROID_HOME) + "/emulator/emulator";
		ProcessBuilder pb = new ProcessBuilder(
				emulatorPath,
				"-avd", avdName,
				"-no-snapshot-load",
				"-no-window" // optional: remove if you want emulator UI
		);

		pb.redirectErrorStream(true);
		emulatorProcess = pb.start();
		// Log emulator output asynchronously (optional)
		BufferedReader reader = new BufferedReader(new InputStreamReader(emulatorProcess.getInputStream()));
		new Thread(() -> reader.lines().forEach(System.out::println)).start();
		System.out.println("Starting emulator: " + avdName);
		waitForEmulatorBoot();
	}

	private void waitForEmulatorBoot() throws Exception {
		String adbPath = CONFIG.getProperty(ConfigKey.PATH) + "/adb";
		// Wait for device to be online
		ProcessBuilder waitForDevice = new ProcessBuilder(adbPath, "wait-for-device");
		Process waitProcess = waitForDevice.start();
		waitProcess.waitFor();
		// Wait until boot completed
		boolean bootCompleted = false;
		while (!bootCompleted) {
			ProcessBuilder checkBoot = new ProcessBuilder(adbPath, "shell", "getprop", "sys.boot_completed");
			Process checkProcess = checkBoot.start();
			BufferedReader br = new BufferedReader(new InputStreamReader(checkProcess.getInputStream()));
			String line = br.readLine();
			if ("1".equals(line)) {
				bootCompleted = true;
			} else {
				Thread.sleep(1000);
			}
		}
		System.out.println("Emulator boot completed.");
	}

	public void stopEmulator() {
		try {
			if (emulatorProcess != null && emulatorProcess.isAlive()) {
				emulatorProcess.destroy();
				System.out.println("Emulator process terminated.");
			} else {
				System.out.println("Emulator process not running.");
			}
		} catch (Exception e) {
			System.err.println("Error stopping emulator: " + e.getMessage());
		}
	}


}
