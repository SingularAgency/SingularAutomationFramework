package com.bkgt.pages.actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bkgt.utils.Click;
import com.bkgt.utils.WaitUI;

import io.appium.java_client.AppiumDriver;

public class CloseModal {

	public static void close(WebDriverWait wait,AppiumDriver driver, WebElement element) {
		WaitUI.elementVisible(wait, element);
		Click.At(driver, 100, 100);
		
	}
}
