package com.bkgt.screenplay.ui;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.bkgt.screenplay.utils.ScreenInitialize;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ProductAcomp extends ScreenInitialize{
	public ProductAcomp(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Elige tu acompañamiento']/following-sibling::XCUIElementTypeStaticText)[1]")
	@AndroidFindBy(xpath = "(//android.view.View[@resource-id='Elige tu acompañamiento']//android.widget.TextView)[2]")
	public WebElement acompContainer;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Papas Fritas Medianas']/following-sibling::XCUIElementTypeRadioButton")
	@AndroidFindBy(xpath = "//*[@resource-id='radio-PAPAS FRITAS MEDIANAS']")
	protected WebElement rbtPapasMed;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Papas Medianas']/following-sibling::XCUIElementTypeOther)[1]")
	@AndroidFindBy(xpath = "//*[@resource-id='radio-PAPAS MEDIANAS']")
	protected WebElement rbtPapas;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Papas Fritas Grandes']/following-sibling::XCUIElementTypeRadioButton")
	@AndroidFindBy(xpath = "//*[@resource-id='radio-PAPAS FRITAS GRANDES']")
	protected WebElement rbtPapasG;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Aros Medianos']/following-sibling::XCUIElementTypeOther)[1]")
	@AndroidFindBy(xpath = "//*[@resource-id='radio-AROS MEDIANOS']")
	protected WebElement rbtAros;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Aros de Cebolla Medianos']/following-sibling::XCUIElementTypeRadioButton")
	@AndroidFindBy(xpath = "//*[@resource-id='radio-AROS DE CEBOLLA MEDIANOS']")
	protected WebElement rbtArosMed;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Aros de Cebolla Grandes']/following-sibling::XCUIElementTypeRadioButton")
	@AndroidFindBy(xpath = "//*[@resource-id='radio-AROS DE CEBOLLA GRANDE']")
	protected WebElement rbtArosG;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Papas Fritas Medianas']/following-sibling::XCUIElementTypeImage)[2]")
	@AndroidFindBy(xpath = "//*[@resource-id='AddPAPAS FRITAS MEDIANAS']")
	public WebElement addMedDries;
	

	public Map<String, WebElement> singleAcomp = new HashMap<>();
	public Map<String, WebElement> acomp = new HashMap<>();
	
}
