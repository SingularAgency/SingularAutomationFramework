package com.bkgt.screenplay.ui;

import org.openqa.selenium.WebElement;

import com.bkgt.screenplay.utils.ScreenInitialize;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Menu extends ScreenInitialize{

	public Menu(AppiumDriver driver) {
		super(driver);
		
		// TODO Auto-generated constructor stub
	}

	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"banner\"]/XCUIElementTypeImage")
	@AndroidFindBy(xpath = "//*[contains(@text,'arrow-square-left')]")
	protected WebElement btnBack;

	
	@iOSXCUITFindBy(xpath = "//*[@name='Ver Carrito']")
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Ver Carrito\"]")
	protected WebElement btnCart;

	

	
	
}
