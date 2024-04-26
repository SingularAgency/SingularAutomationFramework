package com.bkgt.pages.details;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.bkgt.pages.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ProductDrinks extends BasePage{
	

	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Pepsi']/following-sibling::XCUIElementTypeRadioButton")
	@AndroidFindBy(xpath = "//*[@resource-id='radio-PEPSI']")
	protected WebElement rbtPepsi;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Mirinda']/following-sibling::XCUIElementTypeRadioButton")
	@AndroidFindBy(xpath = "//*[@resource-id='radio-MIRINDA']")
	protected WebElement rbtMirinda;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='7 Up']/following-sibling::XCUIElementTypeRadioButton")
	@AndroidFindBy(xpath = "//*[@resource-id='radio-7 UP']")
	protected WebElement rbt7Up;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Té Frío Limón']/following-sibling::XCUIElementTypeRadioButton")
	@AndroidFindBy(xpath = "//*[@resource-id='radio-TÉ FRÍO LIMÓN']")
	protected WebElement rbtTeLimon;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Té Frío Durazno']/following-sibling::XCUIElementTypeRadioButton")
	@AndroidFindBy(xpath = "//*[@resource-id='radio-TÉ FRÍO DURAZNO']")
	protected WebElement rbtTeDurazno;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Pepsi Black']/following-sibling::XCUIElementTypeRadioButton")
	@AndroidFindBy(xpath = "//*[@resource-id='radio-PEPSI BLACK']")
	protected WebElement rbtPepsiBlack;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Grapette']/following-sibling::XCUIElementTypeRadioButton")
	@AndroidFindBy(xpath = "//*[@resource-id='radio-GRAPETTE']")
	protected WebElement rbtGrapette;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Pepsi 1.5l']/following-sibling::XCUIElementTypeOther)[1]")
	@AndroidFindBy(xpath = "//*[@resource-id='radio-PEPSI 1.5L']")
	protected WebElement rbtPepsi1L;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Agua Pura']/following-sibling::XCUIElementTypeRadioButton")
	@AndroidFindBy(xpath = "//*[@resource-id='radio-AGUA PURA']")
	protected WebElement rbtAgua;
	

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Pepsi']/following-sibling::XCUIElementTypeImage)[2]")
	@AndroidFindBy(xpath = "//*[@resource-id='AddPEPSI']")
	protected WebElement pepsiElement;

	@iOSXCUITFindBy(xpath ="(//XCUIElementTypeStaticText[@name='7 Up']/following-sibling::XCUIElementTypeImage)[2]")
	@AndroidFindBy(xpath = "//*[@resource-id='Add7 UP']")
	protected WebElement sevenUpElement;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Mirinda']/following-sibling::XCUIElementTypeImage)[2]")
	@AndroidFindBy(xpath = "//*[@resource-id='AddMIRINDA']")
	protected WebElement mirindaElement;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Grapette']/following-sibling::XCUIElementTypeImage)[2]")
	@AndroidFindBy(xpath = "//*[@resource-id='AddGRAPETTE']")
	protected WebElement grapetteElement;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Cafe 16 Onz']/following-sibling::XCUIElementTypeImage)[2]")
	@AndroidFindBy(xpath = "//*[@resource-id='AddCAFE 16 ONZ']")
	protected WebElement cafe16Element;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Cafe 16 Onz con Leche']/following-sibling::XCUIElementTypeImage)[2]")
	@AndroidFindBy(xpath = "//*[@resource-id='AddCAFE 16 ONZ CON LECHE']")
	protected WebElement cafe16ConLecheElement;
	
	public Map<String, WebElement> drinks = new HashMap<>();
	public Map<String, WebElement> singleDrinks = new HashMap<>();
	public ProductDrinks(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
