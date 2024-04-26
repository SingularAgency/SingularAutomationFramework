package com.bkgt.pages.actions;

import com.bkgt.pages.details.ProductDesserts;
import com.bkgt.utils.Click;
import com.bkgt.utils.WaitUI;

import io.appium.java_client.AppiumDriver;

public class ProductDessertTasks extends ProductDesserts{

	public ProductDessertTasks(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void addDesserts() {
		WaitUI.elementVisible(wait, chkManzanaPay);
		Click.On(chkManzanaPay);
		WaitUI.elementVisible(wait, chkQuesoPay);
		Click.On(chkQuesoPay);
		
	}

}
