package com.bkgt.screenplay.ui;

import org.openqa.selenium.WebElement;

import com.bkgt.screenplay.tasks.ProductAcompTasks;
import com.bkgt.screenplay.tasks.ProductDessertTasks;
import com.bkgt.screenplay.tasks.ProductDrinksTasks;
import com.bkgt.screenplay.tasks.ProductExtrasTasks;
import com.bkgt.screenplay.utils.ScreenInitialize;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ProductDetail extends ScreenInitialize{

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
