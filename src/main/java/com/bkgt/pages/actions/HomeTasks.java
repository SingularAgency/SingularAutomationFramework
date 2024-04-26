package com.bkgt.pages.actions;

import com.bkgt.pages.Home;
import com.bkgt.utils.Click;
import com.bkgt.utils.WaitUI;

import io.appium.java_client.AppiumDriver;

public class HomeTasks extends Home{

	public HomeTasks(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void clickAddressBtnModal() {
		WaitUI.elementVisible(wait, btnBannerAddress);
		Click.On(btnBannerAddress);
	}
	
	public void closeModal() {
		WaitUI.elementVisible(wait, btnBannerAddress);
		Click.At(driver, 100, 100);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickAddress() {
		WaitUI.elementVisible(wait, btnAddress);
		Click.On(btnAddress);
	
	}
	
	public boolean isAddressDisplaed() {
		WaitUI.elementVisible(wait, btnAddress);
		return btnAddress.isDisplayed();
		
	}
	
	public String getAddress() {
		return btnAddress.getText();
	}
	
	
}
