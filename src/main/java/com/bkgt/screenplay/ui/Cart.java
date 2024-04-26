package com.bkgt.screenplay.ui;

import org.openqa.selenium.WebElement;

import com.bkgt.screenplay.utils.ScreenInitialize;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Cart extends ScreenInitialize{
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[contains(@name,'Ir a pagar')]")
	@AndroidFindBy(xpath="//android.widget.Button[contains(@text,'Ir a pagar')]")
	protected WebElement btnPay;
	
	public Cart(AppiumDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}

}
