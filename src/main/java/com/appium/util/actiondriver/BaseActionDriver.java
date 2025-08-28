package com.appium.util.actiondriver;

import io.appium.java_client.AppiumDriver;



public abstract class BaseActionDriver {

    private String testCaseName;
    private String deviceName;

	protected AppiumDriver driver;

	// ✅ Store driver consistently
	public void setAppiumDriver(AppiumDriver driver) {
		this.driver = driver;
	}

	public AppiumDriver getAppiumDriver() {
		return driver;
	}

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }


    public String getTestCaseName() {
        return testCaseName;
    }

    public void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }



    public abstract void initializeLogging();

    public abstract void quit();

    public abstract void takeScreenShot(String string);
}