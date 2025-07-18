
package com.appium.util.actiondriver;


import java.io.File;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.Augmenter;

import com.appium.setup.AppTestCase;
import com.appium.util.CommonUtil;



public class MobileActionDriver extends BaseActionDriver {
	// private RemoteWebDriver appiumDriver;

	CommonUtil common;

	public void initializeLogging() {
		common = AppTestCase.getCommon();
	}

	public Set<String> getWindowHandles() {
		return appiumDriver.getWindowHandles();
	}



	public void quit() {
		if (appiumDriver != null) {
			appiumDriver.quit(); // Ensures app closes after each test
		}
	}

	public void takeScreenShot(String filePath) {
		try {
			File scrFile = getAppiumDriver().getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (Throwable e) {
			common.log("Screen shot failure " + e.getMessage());
		}
	}

}
