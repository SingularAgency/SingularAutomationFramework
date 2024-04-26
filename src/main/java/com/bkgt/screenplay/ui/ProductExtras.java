package com.bkgt.screenplay.ui;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.bkgt.screenplay.utils.ScreenInitialize;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ProductExtras extends ScreenInitialize{
	public ProductExtras(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Dip Agridulce']/following-sibling::XCUIElementTypeImage)[2]")
	@AndroidFindBy(xpath = "//*[@resource-id='AddDIP AGRIDULCE']")
	protected WebElement dipAgridulce;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Drip Bbw']/following-sibling::XCUIElementTypeImage)[2]")
	@AndroidFindBy(xpath = "//*[@resource-id='AddDRIP BBW']")
	protected WebElement dipBBQ;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Dip Ranch']/following-sibling::XCUIElementTypeImage)[2]")
	@AndroidFindBy(xpath = "//*[@resource-id='AddDIP RANCH']")
	protected WebElement dipRanch;

	@iOSXCUITFindBy(xpath="(//XCUIElementTypeStaticText[@name=\"Mas Mozzarella\"]/following-sibling::XCUIElementTypeImage)[2]")
	@AndroidFindBy(xpath = "//*[@resource-id='AddMAS MOZZARELLA']")
	protected WebElement masMozarella;

	@iOSXCUITFindBy(xpath="(//XCUIElementTypeStaticText[@name=\"Extra Jamón\"]/following-sibling::XCUIElementTypeImage)[2]")
	@AndroidFindBy(xpath = "//*[@resource-id='AddEXTRA JAMON']")
	protected WebElement extraJamon;

	@iOSXCUITFindBy(xpath="(//XCUIElementTypeStaticText[@name=\"Extra Barbacoa\"]/following-sibling::XCUIElementTypeImage)[2]")
	@AndroidFindBy(xpath = "//*[@resource-id='AddEXTRA BARBACOA']")
	protected WebElement extraBBQ;

	@iOSXCUITFindBy(xpath="(//XCUIElementTypeStaticText[@name=\"Mas Tocino\"]/following-sibling::XCUIElementTypeImage)[2]")
	@AndroidFindBy(xpath = "//*[@resource-id='AddMAS TOCINO']")
	protected WebElement masTocino;

	@iOSXCUITFindBy(xpath="(//XCUIElementTypeStaticText[@name=\"Extra Tocino\"]/following-sibling::XCUIElementTypeImage)[2]")
	@AndroidFindBy(xpath = "//*[@resource-id='AddEXTRA TOCINO']")
	protected WebElement extraTocino;

	@iOSXCUITFindBy(xpath="(//XCUIElementTypeStaticText[@name=\"Extra Queso Suizo\"]/following-sibling::XCUIElementTypeImage)[2]")
	@AndroidFindBy(xpath = "//*[@resource-id='AddEXTRA QUESO SUIZO']")
	protected WebElement extraSuizo;

	@iOSXCUITFindBy(xpath="(//XCUIElementTypeStaticText[@name=\"Mas Queso\"]/following-sibling::XCUIElementTypeImage)[2]")
	@AndroidFindBy(xpath = "//*[@resource-id='AddMAS QUESO']")
	protected WebElement masQueso;

	@iOSXCUITFindBy(xpath="(//XCUIElementTypeStaticText[@name=\"Extra Carne W\"]/following-sibling::XCUIElementTypeImage)[2]")
	@AndroidFindBy(xpath = "//*[@resource-id='AddEXTRA CARNE W']")
	protected WebElement extraCarneW;

	@iOSXCUITFindBy(xpath="(//XCUIElementTypeStaticText[@name=\"Mas Pepinillos\"]/following-sibling::XCUIElementTypeImage)[2]")
	@AndroidFindBy(xpath = "//*[@resource-id='AddMAS PEPINILLOS']")
	protected WebElement masPepinillos;

	@iOSXCUITFindBy(xpath="(//XCUIElementTypeStaticText[@name=\"Mas Jamón\"]/following-sibling::XCUIElementTypeImage)[2]")
	@AndroidFindBy(xpath = "//*[@resource-id='AddMAS JAMÓN']")
	protected WebElement masJamon;

	@iOSXCUITFindBy(accessibility = "AddEXTRA TOMATE")
	@AndroidFindBy(xpath = "//*[@resource-id='AddEXTRA TOMATE']")
	protected WebElement extraTomate;
	
	public Map<String, WebElement> extras = new HashMap<>();

}
