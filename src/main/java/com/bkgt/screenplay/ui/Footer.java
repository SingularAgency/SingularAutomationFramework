package com.bkgt.screenplay.ui;

import org.openqa.selenium.WebElement;

import com.bkgt.screenplay.utils.ScreenInitialize;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Footer extends ScreenInitialize {
	public Footer(AppiumDriver driver) {
		super(driver);
	}

	@iOSXCUITFindBy(accessibility = "Home")
	@AndroidFindBy(xpath = "//*[contains(@text,'Home')]")
	protected WebElement btnHome;

	@iOSXCUITFindBy(accessibility = "Órdenes")
	@AndroidFindBy(xpath = "//*[contains(@text,'Órdenes')]")
	protected WebElement btnOrders;

	
	@iOSXCUITFindBy(accessibility = "Restaurantes")
	@AndroidFindBy(xpath = "//*[contains(@text,'Restaurantes')]")
	protected WebElement btnRestaurants;

	@iOSXCUITFindBy(accessibility = "Cupones")
	@AndroidFindBy(xpath = "//*[contains(@text,'Cupones')]")
	protected WebElement btnCoupons;

	@iOSXCUITFindBy(accessibility = "Mi cuenta")
	@AndroidFindBy(xpath = "//*[contains(@text,'Mi cuenta')]")
	protected WebElement btnAccount;
}
