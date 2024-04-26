package com.bkgt.screenplay.ui;

import org.openqa.selenium.WebElement;

import com.bkgt.screenplay.utils.ScreenInitialize;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ProductDesserts extends ScreenInitialize{
	public ProductDesserts(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Elige tu postre']/following-sibling::XCUIElementTypeStaticText)[1]")
	@AndroidFindBy(xpath = "(//android.view.View[@resource-id='Elige tu postre']//android.widget.TextView)[2]")
	protected WebElement dessertContainer;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Pie De Manzana']/following-sibling::XCUIElementTypeSwitch")
	@AndroidFindBy(xpath = "//*[@resource-id='checkbox-M408']")
	public WebElement chkManzanaPay;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Pie De Queso']/following-sibling::XCUIElementTypeSwitch")
	@AndroidFindBy(xpath = "//*[@resource-id='checkbox-M411']")
	public WebElement chkQuesoPay;
	
	
}
