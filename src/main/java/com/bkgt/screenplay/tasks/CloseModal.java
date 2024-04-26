package com.bkgt.screenplay.tasks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bkgt.screenplay.actions.Click;
import com.bkgt.screenplay.actions.WaitUI;

import io.appium.java_client.AppiumDriver;

public class CloseModal {

	public static void close(WebDriverWait wait,AppiumDriver driver, WebElement element) {
		WaitUI.elementVisible(wait, element);
		Click.At(driver, 100, 100);
		
	}
}
