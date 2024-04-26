package com.bkgt.pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Home extends BasePage{

	@iOSXCUITFindBy(accessibility = "Buscar dirección")
	@AndroidFindBy(xpath="//android.widget.Button[contains(@text,'Buscar dirección')]")
	protected  WebElement btnBannerAddress;
	
	@iOSXCUITFindBy(accessibility = "web dialog")
	protected  WebElement divModal;
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'La hora de la comida ha llegado')]")
	protected  WebElement lblWelcomeMessage;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'¡Buenos')]")
	protected  WebElement lblWelcomeMessageMorning;
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Escoge')]")
	protected  WebElement lblWelcomeMessagePart2;
	
	
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name='banner']//XCUIElementTypeStaticText")
	@AndroidFindBy(xpath="//*[@resource-id=\"address\"]")
	protected  WebElement btnAddress;
	
	public Home(AppiumDriver driver){
		super(driver);
	}
	
	
		
}
