package com.bkgt.screenplay.actions;

import org.openqa.selenium.WebElement;

public class Type {

	public static void On(WebElement element, String text) {
		element.sendKeys(text);
	}
}
