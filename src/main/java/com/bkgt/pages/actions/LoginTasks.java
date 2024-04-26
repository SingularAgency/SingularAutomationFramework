package com.bkgt.pages.actions;

import com.bkgt.pages.Login;
import com.bkgt.utils.Click;
import com.bkgt.utils.Type;
import com.bkgt.utils.WaitUI;

import io.appium.java_client.AppiumDriver;

public class LoginTasks extends Login{

	public LoginTasks(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void fillForm() {
		WaitUI.elementVisible(wait, txtEmail);
		Type.On(txtEmail, "alara7@yopmail.com");
		Click.At(driver, 100, 100);
		WaitUI.elementVisible(wait, txtPassword);
		Type.On(txtPassword, "Test123");
		Click.At(driver, 100, 100);
		WaitUI.elementEnabled(wait, btnLogin);
		Click.On(btnLogin);
		
	}
	

}
