package com.playground;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class RunAppium {
	public static IOSDriver driver;
	
	public static AppiumDriverLocalService service;

	public static void setServer() {
		
		Map<String , String> env = new HashMap<String , String>(System.getenv());
		env.put("ANDROID_HOME", "/Users/cruyfj/Library/Android/sdk");
		env.put("JAVA_HOME", "/Applications/Android Studio.app/Contents/jbr/Contents/Home");
		env.put("PATH", "/usr/local/bin");
		env.put("SDKROOT", "/Applications/Xcode.app/Contents/Developer/Platforms/iPhoneOS.platform/Developer/SDKs/iPhoneOS.sdk");
		env.put("PATH", "/Applications/Xcode.app");
		env.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));
		service = new AppiumServiceBuilder().withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).withEnvironment(env).withTimeout(Duration.ofSeconds(300)).build();
		service.start();
		
	}
	
	public static void setDevice() throws MalformedURLException, URISyntaxException {
			DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("platformName", "iOS");
	        capabilities.setCapability("deviceName", "iPhone");
	        capabilities.setCapability("platformVersion", "17.0");
	        capabilities.setCapability("app", "./src/test/java/resources/App.app");
	        capabilities.setCapability("automationName", "XCUITest");
	        capabilities.setCapability(XCUITestOptions.SIMPLE_IS_VISIBLE_CHECK_OPTION, true);
	        capabilities.setCapability("autoAcceptAlerts", true); // Automatically accept system alerts
		

		driver = new IOSDriver((Capabilities) new IOSDriver(new URI("http://0.0.0.0:4723").toURL(),capabilities));

	}
	
	public static void end() {
		driver.quit();
		service.stop();
	}
	
	public static void main(String[] args) throws MalformedURLException, URISyntaxException {
		setServer();
		setDevice();
		end();
	}
	

}
