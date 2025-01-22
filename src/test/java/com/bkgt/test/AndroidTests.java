package com.bkgt.test;

import com.github.javafaker.Faker;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.vuzo.construyamos.pages.SharedPage;
import com.vuzo.construyamos.pages.steps.ClientesPageSteps;
import com.vuzo.construyamos.pages.steps.LoginPageSteps;
import com.vuzo.construyamos.services.CustomerAPI;
import com.vuzo.construyamos.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.appium.setup.AppTestCase;
import io.appium.java_client.android.AndroidDriver;
import java.io.IOException;
import java.util.Map;

public class AndroidTests extends AppTestCase {
	private final String className = this.getClass().getSimpleName();
    Faker faker = new Faker();
	String email,password;
	String 	DPI="6666666666666";
	String name = faker.funnyName().name();;
	String phone ="878785080";
	String 	address = faker.address().streetAddress();
	String 	emailClient = faker.pokemon().name() + "@mail.com";
	LoginPageSteps loginPageSteps;
	SharedPage sharedPage;
	ClientesPageSteps clientesPageSteps;



	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		initializeAppTest(className, "Android");
		String filePath = "src/test/java/com/data/construyamos/users.json";
		String targetTag = "Admin";
		Map<String, String> credentials = JsonReader.getCredentials(filePath, targetTag);

		email = credentials.get("email");
		password = credentials.get("password");
		String appPackage = "com.constr.client";
		String mainActivity = "com.constr.client.MainActivity";
		Runtime.getRuntime().exec("/Users/cruyfj/Library/Android/sdk/platform-tools/adb shell pm clear " + appPackage).waitFor();
		Runtime.getRuntime().exec("/Users/cruyfj/Library/Android/sdk/platform-tools/adb shell am start -n " + appPackage + "/" + mainActivity).waitFor();
	}

	@BeforeMethod
	public void setUpDriver() throws IOException, InterruptedException {
        AndroidDriver driver = (AndroidDriver) AppTestCase.getActionDriver().getAppiumDriver();
		loginPageSteps = new LoginPageSteps(driver);
		sharedPage = new SharedPage(driver);
		clientesPageSteps = new ClientesPageSteps(driver);

	}

	@Test
	public void VCTC001_PerformLogin() throws InterruptedException {
		common.logScreen("Accediendo al Login");
		loginPageSteps.performLoginConstruyamos(email,password);
		Assert.assertTrue(sharedPage.getBtnDashboard().isDisplayed());
		common.log("Inicio de sesion ejecutado con exito");

	}

	@Test
	public void VCTC002_CreateClient() throws UnirestException {

			// Perform test steps
			clientesPageSteps.createCliente(DPI, name, phone, emailClient, address);
			common.logScreen("Cliente Creado con exito");
			Assert.assertTrue(clientesPageSteps.wasClientCreated());
			CustomerAPI customerAPI = new CustomerAPI();
			int customerId= customerAPI.getLastCustomerID();
			common.log(customerAPI.getCustomerName());
			customerAPI.deleteCustomer(customerId);
			Assert.assertEquals(customerAPI.getLastResponse(),200);
			common.log(customerAPI.getLastResponse());
	}

	@Test
	public void VCTC003_FilterClient() throws UnirestException {
		CustomerAPI customerAPI = new CustomerAPI();
		customerAPI.createCustomer(name,emailClient,phone,address,DPI,"11");
		Assert.assertEquals(customerAPI.getLastResponse(),200);
		common.log(customerAPI.getCustomerName());
		common.log(customerAPI.getCustomerID());

		clientesPageSteps.filterClient(DPI, name, phone);
		Assert.assertTrue(clientesPageSteps.isClientFiltered(DPI, name, phone));
		int customerId= customerAPI.getLastCustomerID();
		common.log(customerAPI.getCustomerName());
		customerAPI.deleteCustomer(customerId);
		Assert.assertEquals(customerAPI.getLastResponse(),200);


		//sharedPage.getBtnLogout().click();
		//Assert.assertTrue(loginPageSteps.getBtnLogin().isDisplayed());

	}

	@Test(enabled=false)
	public void VATC001_PerformLogin(){
		common.logScreen("Accediendo al Login");
		loginPageSteps.perforLoginVuzoAdmin(email,password);
		Assert.assertTrue(sharedPage.getBtnDashboard().isDisplayed());
		common.logScreen("Inicio de sesion ejecutado con exito");
	}


	@Override
	protected void cleanPageObjects() {
		// TODO Auto-generated method stub

	}
}
