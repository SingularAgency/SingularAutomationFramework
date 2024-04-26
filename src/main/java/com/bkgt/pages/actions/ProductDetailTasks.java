package com.bkgt.pages.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.bkgt.pages.details.ProductDetail;
import com.bkgt.utils.Click;
import com.bkgt.utils.WaitUI;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class ProductDetailTasks extends ProductDetail{
	private String product;
	

	
	public ProductDetailTasks(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void addExtras(String[]array,int max) throws InterruptedException {
		extrasModule.createExtras();

		extrasModule.addCounters(array,extrasModule.extras,max);
	}
	
	public void addDrinks(String[]array, int max) throws InterruptedException {
		drinksModule.createDrinks();
		addCounters(array, drinksModule.drinks,max);
	}
	
	public void addSinglesDrinks(String[]array) {
		drinksModule.createSingleDrinks();
		addSingles(array, drinksModule.singleDrinks);

	}

	public void addSinglesAcomp(String[]array) {
		acompModule.createSingleAcomp();
		addSingles(array,acompModule.singleAcomp);

	}
	
	public void addAcomp(String[]array,int max) throws InterruptedException {
		acompModule.createAccomp();
		addCounters(array, acompModule.acomp, max);
	}
	
	public void addToCart() {
		WaitUI.elementEnabled(wait, btnAddCart);
		Click.On(btnAddCart);
	}
	
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}

	public void clickProduct(IOSDriver driver) {
		//XCUIElementTypeOther[@name='main']//XCUIElementTypeOther[@name='main']//XCUIElementTypeStaticText[@name='Panqueques']
		String xpath = "//XCUIElementTypeOther[@name='main']//XCUIElementTypeOther[@name='main']//XCUIElementTypeStaticText[@name='"+this.getProduct()+"']";
		WebElement element =driver.findElement(By.xpath(xpath));
		WaitUI.elementVisible(wait, element);
		element.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickProduct(AndroidDriver driver) {
		String xpath = "//*[contains(text(),'" + this.getProduct() + "')]";
		WebElement element =driver.findElement(By.xpath(xpath));
		WaitUI.elementVisible(wait, element);
		element.click();

	}
	
	public void addDesserts() {
		dessertsModule.addDesserts();
	}

	
}
