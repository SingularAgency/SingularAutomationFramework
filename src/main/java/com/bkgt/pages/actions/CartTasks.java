package com.bkgt.pages.actions;

import com.bkgt.pages.Cart;
import com.bkgt.utils.Click;
import com.bkgt.utils.WaitUI;

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
