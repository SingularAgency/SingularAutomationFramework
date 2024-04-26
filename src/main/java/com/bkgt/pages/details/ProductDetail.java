package com.bkgt.pages.details;

import org.openqa.selenium.WebElement;

import com.bkgt.pages.BasePage;
import com.bkgt.pages.actions.ProductAcompTasks;
import com.bkgt.pages.actions.ProductDessertTasks;
import com.bkgt.pages.actions.ProductDrinksTasks;
import com.bkgt.pages.actions.ProductExtrasTasks;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ProductDetail extends BasePage{

	public ProductAcompTasks acompModule;
	public ProductDrinksTasks drinksModule;
	public ProductExtrasTasks extrasModule;
	public ProductDessertTasks dessertsModule;

	//@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Sin Queso']/following-sibling::XCUIElementTypeSwitch")
	
	//@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='¿Deseas eliminar algún ingrediente?']")


	@iOSXCUITFindBy(accessibility = "Guardar")
	@AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'Guardar')]")
	protected WebElement btnSave;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[contains(@name,'Agregar')]")
	@AndroidFindBy(xpath="//*[@resource-id='addCartActive']")
	protected WebElement btnAddCart;

	@iOSXCUITFindBy(accessibility = "+")
	protected WebElement btnAdd;
	
	@iOSXCUITFindBy(accessibility = "-")
	protected WebElement btnLess;
	


	public ProductDetail(AppiumDriver driver) {
		super(driver);
		this.acompModule = new ProductAcompTasks(driver);
		this.drinksModule = new ProductDrinksTasks(driver);
		this.extrasModule = new ProductExtrasTasks(driver);
		this.dessertsModule = new ProductDessertTasks(driver);
	}
	


	
}
