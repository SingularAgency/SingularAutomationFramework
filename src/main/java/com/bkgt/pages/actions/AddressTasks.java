package com.bkgt.pages.actions;

import com.bkgt.pages.Address;
import com.bkgt.utils.Click;
import com.bkgt.utils.Type;
import com.bkgt.utils.WaitUI;

import io.appium.java_client.AppiumDriver;

public class AddressTasks extends Address{
	
	public AddressTasks(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void newDirection() {
		WaitUI.elementVisible(wait, btnNewDirection);
		btnNewDirection.click();
	}

	public void allowLocation() {
		WaitUI.elementVisible(wait, mobileDialog);
		Click.On(btnAllowLocation);
		
	}
	
	public void searchAddress(String address) {
		WaitUI.elementVisible(wait, txtSearch);
		Type.On(txtSearch,address);
	}
	
	public void goToResult() {
		WaitUI.elementVisible(wait, lvResult);
		Click.On(lvResult);
		Click.On(btnSave);
		WaitUI.elementVisible(wait, btnContinue);
		Click.On(btnContinue);
	}
	
	public void fillAddress(String department,String municipio, String zone, String address, String additionalDetails, String name) {
		WaitUI.elementVisible(wait, formModal);
		WaitUI.elementVisible(wait, txtDepartment);
		
		Type.On(txtDepartment, department);
		Type.On(txtMunicipio, municipio);
		Type.On(txtZone,zone);
		Type.On(txtExactAddress, address);
		Type.On(txtAdditionalDetails, additionalDetails);
		Type.On(txtAddressName, name);
		Click.At(driver, 300, 800);
		
	}
	
	
	public void saveAddress()
	{

		WaitUI.elementEnabled(wait, btnSaveAddress);
		
		btnSaveAddress.click();
	}
	
}
