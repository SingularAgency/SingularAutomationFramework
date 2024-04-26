package com.bkgt.screenplay.tasks;

import com.bkgt.screenplay.actions.Click;
import com.bkgt.screenplay.actions.WaitUI;
import com.bkgt.screenplay.ui.ProductDesserts;

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
