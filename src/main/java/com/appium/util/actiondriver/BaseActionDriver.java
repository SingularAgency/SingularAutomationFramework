package com.appium.util.actiondriver;







import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseActionDriver {
	
    protected AppiumDriver appiumDriver;
	protected IOSDriver iosDriver;
	private String testCaseName;
	private String deviceName;


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


	public abstract void initializeLogging();

	public abstract void quit();

	public abstract void takeScreenShot(String string);
}
