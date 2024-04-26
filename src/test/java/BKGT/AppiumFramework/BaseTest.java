package BKGT.AppiumFramework;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	private ExtentReports extent;
	public ExtentTest test;
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void configureAppium() throws IOException {
		
		Map<String , String> env = new HashMap<String , String>(System.getenv());
		env.put("ANDROID_HOME", "/Users/cruyfj/Library/Android/sdk");
		env.put("JAVA_HOME", "/Applications/Android Studio.app/Contents/jbr/Contents/Home");
		env.put("PATH", "/usr/local/bin");
		
		this.service = new AppiumServiceBuilder().withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).withEnvironment(env).withTimeout(Duration.ofSeconds(300)).build();
		service.start();


		


		extent = ExtentManager.getInstance();

	}
	
	public AndroidDriver initializeDriver() throws MalformedURLException {
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("Pixel 4 API 33");
		options.setPlatformName("Android");
		options.setCapability("platformVersion","13.0");
		options.setAutomationName("UiAutomator2");
		options.setCapability("unicodeKeyboard", true);
		options.setCapability("resetKeyboard", true);
		
		
		//options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		options.setApp("./src/test/java/resources/app-debug.apk");
	
		
		//create object for AndroidDriver/ IOSDriver 
		return driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	}
	
	public String screenshot() throws IOException{
	    File srcFile=driver.getScreenshotAs(OutputType.FILE);
	    File targetFile=new File("./test-output/screenshots" + System.currentTimeMillis() +".jpg");
	    String pathImage=targetFile.getAbsolutePath();
	    FileUtils.copyFile(srcFile,targetFile);
	    return pathImage;
	    
	}
	

	
	 @AfterClass(alwaysRun = true)
     public void tearDown() {
    		
 		service.stop();
		extent.flush();

     }

}
