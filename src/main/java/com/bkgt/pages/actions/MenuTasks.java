package com.bkgt.pages.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.bkgt.pages.Menu;
import com.bkgt.utils.Click;
import com.bkgt.utils.WaitUI;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class MenuTasks extends Menu{

	private String category;
	public MenuTasks(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public void clickCategory(AndroidDriver driver) {
		String xpath = "//*[contains(text(),'" + this.getCategory() + "')]";
		WebElement element =driver.findElement(By.xpath(xpath));
		WaitUI.elementVisible(wait, element);
		element.click();		
	}
	
	public void clickCategory(IOSDriver driver) {
		String xpath = "//XCUIElementTypeStaticText[contains(@name,'"+this.getCategory()+"')]";
		WebElement element =driver.findElement(By.xpath(xpath));
		System.out.println("Entra");
		WaitUI.elementVisible(wait, element);
		System.out.println("Entra");

		element.click();		
	}
	
	public void showCart() {
		WaitUI.elementVisible(wait, btnCart);
		Click.On(btnCart);
	}
	
	public void waitCart() {
		WaitUI.elementVisible(wait, btnCart);

	}

}
