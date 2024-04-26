package com.bkgt.pages.actions;

import org.openqa.selenium.By;

import com.bkgt.pages.Checkout;
import com.bkgt.utils.Actions;
import com.bkgt.utils.Click;
import com.bkgt.utils.Type;
import com.bkgt.utils.WaitUI;

import io.appium.java_client.AppiumDriver;

public class CheckoutTasks extends Checkout{

	public CheckoutTasks(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isHeaderDisplayed() {
		WaitUI.elementVisible(wait, lblHeader);
		return lblHeader.isDisplayed();
	}
	
	public String getProduct(String name) {
		
		return driver.findElement(By.xpath(String.format("//XCUIElementTypeStaticText[contains(@name,'%s')]",name))).getText();
		
		
	}
	
	public String getDetail(String name) {
		return driver.findElement(By.xpath("//XCUIElementTypeStaticText[contains(@name,'"+name+"')]/following-sibling::XCUIElementTypeOther[1]")).getText();
	}
	
	public double getProductPrice(String name) {
		String text = driver.findElement(By.xpath("//XCUIElementTypeStaticText[contains(@name,'"+name+"')]/following-sibling::XCUIElementTypeOther[2]")).getText();
		double price = Double.parseDouble(text.replaceAll("Q", ""));
		return price;

	}
	
	public void payWithCash() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Actions.scrollDown2Times(driver);

		WaitUI.elementVisible(wait, btnCash);
		Click.On(btnCash);

		WaitUI.elementVisible(wait, txtAmmount);
		Click.On(txtAmmount);
		Click.At(driver, 150, 50);
		WaitUI.elementEnabled(wait, btnOrder);
		Click.On(btnOrder);
		WaitUI.elementVisible(wait, lblOrderConfirm);	
	}
	
	public void payWithSavedCard() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Actions.scrollDown2Times(driver);

		WaitUI.elementVisible(wait, btnSavedCard);
		Click.On(btnSavedCard);

	
	}
	
	public void order() {
		WaitUI.elementEnabled(wait, btnOrder);
		Click.On(btnOrder);
		WaitUI.elementVisible(wait, lblOrderConfirm);	
	}
	
	public double getTotal() {
		return Double.parseDouble(lblTotal.getText().replaceAll("Q", ""));
	}

	public void useNIT() {
		WaitUI.elementVisible(wait, btnType);
		Click.On(btnType);
		WaitUI.elementVisible(wait, btnNIT);
		Click.On(btnNIT);
		WaitUI.elementVisible(wait, txtNIT);
		Type.On(txtNIT, "103204938");
		
		Click.On(lblMetodo);
	}
}
