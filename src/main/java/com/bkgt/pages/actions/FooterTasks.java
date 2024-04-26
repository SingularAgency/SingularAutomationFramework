package com.bkgt.pages.actions;

import org.openqa.selenium.StaleElementReferenceException;

import com.bkgt.pages.Footer;
import com.bkgt.utils.Click;
import com.bkgt.utils.WaitUI;

import io.appium.java_client.AppiumDriver;

public class FooterTasks extends Footer{

	public FooterTasks(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void clickHome() {
		WaitUI.elementVisible(wait, btnHome);
		Click.On(btnHome);
	}
	
	public void clickOrders() {
		WaitUI.elementVisible(wait, btnOrders);
		Click.On(btnOrders);
	}

	public void clickRestaurants() {
		WaitUI.elementVisible(wait, btnRestaurants);
		
		Click.On(btnRestaurants);
	}
	
	public void clickCoupons() {
		WaitUI.elementVisible(wait, btnCoupons);
		Click.On(btnCoupons);
	}
	
	public void clickAccount() {
		WaitUI.elementVisible(wait, btnAccount);
		Click.On(btnAccount);
	}
	
	public void waitHome() {
		try {
			WaitUI.elementVisible(wait, btnHome);

		}catch(StaleElementReferenceException e) {
            // If StaleElementReferenceException is caught, re-locate the element and perform the action again
			WaitUI.elementVisible(wait, btnHome);

        }
	}
	
}
