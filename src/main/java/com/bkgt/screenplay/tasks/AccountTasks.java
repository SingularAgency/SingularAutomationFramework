package com.bkgt.screenplay.tasks;

import com.bkgt.screenplay.actions.Click;
import com.bkgt.screenplay.actions.WaitUI;
import com.bkgt.screenplay.ui.Account;

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
