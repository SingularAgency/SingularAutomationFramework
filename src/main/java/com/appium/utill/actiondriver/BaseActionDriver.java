package com.appium.utill.actiondriver;







import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public abstract class BaseActionDriver {
	
	protected AppiumDriver appiumDriver;
	protected IOSDriver iosDriver;
	private String testCaseName;
	private String deviceName;
	public String getTestCaseName() {
		return testCaseName;
	}
	
	public void setTestCaseName(String testCaseName) {
		this.testCaseName= testCaseName;
	}
	
	public AppiumDriver getAppiumDriver() {
		return appiumDriver;
	}
	
	public IOSDriver getIOSDriver() {
		return iosDriver;
	}
	public void setIOSDriver(IOSDriver appiumDriver) {
		this.iosDriver = appiumDriver;
	}

	public void setAppiumDriver(AndroidDriver appiumDriver) {
		this.appiumDriver = appiumDriver;
	}
	public void setAppiumDriver(IOSDriver appiumDriver) {
		this.appiumDriver = appiumDriver;
	}


	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public abstract void initializeLogging();

	public abstract void quit();

	public abstract void takeScreenShot(String string);
}
