package com.bkgt.screenplay.tasks;

import com.bkgt.screenplay.actions.Click;
import com.bkgt.screenplay.actions.WaitUI;
import com.bkgt.screenplay.ui.Cart;

import io.appium.java_client.AppiumDriver;

public class CartTasks extends Cart{

	public CartTasks(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void gotoCheckout() {
		WaitUI.elementVisible(wait, btnPay);
		Click.On(btnPay);
	}
}
