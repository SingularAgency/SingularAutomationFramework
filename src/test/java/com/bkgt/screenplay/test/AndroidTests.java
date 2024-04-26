package com.bkgt.screenplay.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.appium.setup.AppTestCase;
import com.bkgt.screenplay.actions.Actions;
import com.bkgt.screenplay.tasks.AddressTasks;
import com.bkgt.screenplay.tasks.HomeTasks;

import io.appium.java_client.android.AndroidDriver;

public class AndroidTests extends AppTestCase {
	private String className = this.getClass().getSimpleName();
	Actions actions;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		initializeAppTest(className, "Android");
	}

	@Test
	public void BKTC_001_SaveAddressFromModal() throws InterruptedException {
		String newAddress = "Calle Mar";
		String addressDetails = "El Picoteo Antojitos";
		String additionalDetails = "Desde Appium";

		AndroidDriver driver = (AndroidDriver) AppTestCase.getActionDriver().getAppiumDriver();
		HomeTasks home = new HomeTasks(driver);
		home.clickAddressBtnModal();
		AddressTasks address = new AddressTasks(driver);
		address.allowLocation();
		address.searchAddress(newAddress);
		address.goToResult();
		//address.fillAddress(addressDetails, additionalDetails);
		address.saveAddress();
		home.isAddressDisplaed();
		common.log("Direccion Guardada");
	}


	@Override
	protected void cleanPageObjects() {
		// TODO Auto-generated method stub

	}
}
