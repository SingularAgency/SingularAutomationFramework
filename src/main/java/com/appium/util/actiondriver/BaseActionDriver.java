package com.appium.util.actiondriver;







import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;


public abstract class BaseActionDriver {
	
    protected AppiumDriver appiumDriver;
	protected IOSDriver iosDriver;
	private String testCaseName;
	private String deviceName;


    public IOSDriver getIOSDriver() {
		return iosDriver;
	}

	public AppiumDriver getAppiumDriver() {
		return appiumDriver;
	}

	public void setAppiumDriver(AppiumDriver appiumDriver) {
		this.appiumDriver = appiumDriver;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public IOSDriver getIosDriver() {
		return iosDriver;
	}

	public void setIosDriver(IOSDriver iosDriver) {
		this.iosDriver = iosDriver;
	}

	public String getTestCaseName() {
		return testCaseName;
	}

	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
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


	public abstract void initializeLogging();

	public abstract void quit();

	public abstract void takeScreenShot(String string);
}
