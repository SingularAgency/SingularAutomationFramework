package com.bkgt.screenplay.ui;

import org.openqa.selenium.WebElement;

import com.bkgt.screenplay.utils.ScreenInitialize;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Checkout extends ScreenInitialize{

	public Checkout(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@iOSXCUITFindBy(accessibility = "Tu orden")
	protected WebElement lblHeader;

	@iOSXCUITFindBy(accessibility = "Ordenar")
	@AndroidFindBy(xpath="//android.widget.Button[contains(@text,'Ordenar')]")
	protected WebElement btnOrder;

	@iOSXCUITFindBy(accessibility = "1 / 3")
	protected WebElement btnSavedCard;
	
	@iOSXCUITFindBy(xpath="(//XCUIElementTypeOther[@name=\"main\"]//XCUIElementTypeStaticText)[1]/following-sibling::XCUIElementTypeOther[1]")
	protected WebElement lblDetails;
	
	
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Total']/following-sibling::XCUIElementTypeStaticText")
	protected WebElement lblTotal;
	
	@iOSXCUITFindBy(accessibility = "Efectivo")
	@AndroidFindBy(xpath="//android.view.View[@resource-id=\"cash\"]//android.view.View")
	protected WebElement btnCash;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Pagaré con:\"]/following-sibling::XCUIElementTypeTextField")
	@AndroidFindBy(xpath="//android.view.View[@resource-id=\"CashField\"]")
	protected WebElement txtAmmount;
	
	@iOSXCUITFindBy(xpath="//*[contains(@name,'Orden confirmada con')]")
	@AndroidFindBy(xpath="//android.widget.TextView[@contains(@text,'Orden confirmada con')]")
	protected WebElement lblOrderConfirm;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[XCUIElementTypeStaticText[@name=\"CUI / NIT\"]]/following-sibling::XCUIElementTypeTextField")
	protected WebElement txtNIT;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"Consumidor final\"]")
	protected WebElement btnType;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Método de pago\"]")
	protected WebElement lblMetodo;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"NIT\"]")
	protected WebElement btnNIT;
	

	
}
