package com.bkgt.pages.actions;

import com.bkgt.pages.Account;
import com.bkgt.utils.Click;
import com.bkgt.utils.WaitUI;

import io.appium.java_client.AppiumDriver;

public class AccountTasks extends Account{

	public AccountTasks(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void clickLogin() {
		WaitUI.elementVisible(wait, btnGoLogin);
		Click.On(btnGoLogin);
	}

}
