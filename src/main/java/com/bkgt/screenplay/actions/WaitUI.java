package com.bkgt.screenplay.actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUI {
	
	
	
	public static void elementVisible(WebDriverWait wait, WebElement element){
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void elementEnabled(WebDriverWait wait, WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
