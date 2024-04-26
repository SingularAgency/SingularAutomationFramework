package com.bkgt.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.appium.setup.AppTestCase;
import com.appium.util.RetryAnalyzer;
import com.bkgt.pages.actions.AccountTasks;
import com.bkgt.pages.actions.AddressTasks;
import com.bkgt.pages.actions.CartTasks;
import com.bkgt.pages.actions.CheckoutTasks;
import com.bkgt.pages.actions.FooterTasks;
import com.bkgt.pages.actions.HomeTasks;
import com.bkgt.pages.actions.LoginTasks;
import com.bkgt.pages.actions.MenuTasks;
import com.bkgt.pages.actions.ProductDetailTasks;
import com.bkgt.services.Services;
import com.bkgt.utils.Actions;
import com.mashape.unirest.http.exceptions.UnirestException;

import io.appium.java_client.ios.IOSDriver;

public class iOSTests extends AppTestCase {
	private String className = this.getClass().getSimpleName();
	Actions actions;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		initializeAppTest(className, "iOS");
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void BKTC_001_SaveAddressFromModal() throws InterruptedException {
		
		String newAddress = "Calle Mar";
		String exactAddress = "Salida a Avenida 14 5A Calle 5-17";
		String additionalDetails = "Desde Appium";
		String name ="Automation";
		String zone = "Zona 6";
		String dept ="Ciudad de Guatemala";
		String mun = "Ciudad de Guatemala";

		IOSDriver driver = (IOSDriver) AppTestCase.getActionDriver().getAppiumDriver();
		HomeTasks home = new HomeTasks(driver);
		home.clickAddressBtnModal();
		AddressTasks address = new AddressTasks(driver);
		address.allowLocation();
		address.newDirection();
		
		address.searchAddress(newAddress);
		common.logScreen("Mapa mostrado");
		address.goToResult();
		address.fillAddress(dept,mun,zone,exactAddress,additionalDetails,name);
		common.logScreen("Nuevos Campos llenados");
		address.saveAddress();
		home.isAddressDisplaed();
		common.log("Direccion Guardada desde Banner de Bienvenida: " + home.getAddress());
	}
	
	
	

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void BKTC_002_SaveAddressFromHome() throws InterruptedException {
		String newAddress = "Proyecto";
		String addressDetails = "Av 20 Proyectos 4-10";

		IOSDriver driver = (IOSDriver) AppTestCase.getActionDriver().getAppiumDriver();
		HomeTasks home = new HomeTasks(driver);
		home.closeModal();
		home.clickAddress();
		AddressTasks address = new AddressTasks(driver);
		address.allowLocation();
		address.searchAddress(newAddress);
		address.goToResult();
		//address.fillAddress(addressDetails, additionalDetails);
		address.saveAddress();
		home.isAddressDisplaed();
		common.log("Direccion Guardada desde Home: " + addressDetails);
	}
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void BKTC_00b_SaveAddressFromHome() throws InterruptedException, IOException, UnirestException {

		String newAddress = "Calle Mar";
		String exactAddress = "Salida a Avenida 14 5A Calle 5-17";
		String additionalDetails = "Desde Appium";
		String name ="Automation";
		String zone = "Zona 6";
		String dept ="Ciudad de Guatemala";
		String mun = "Ciudad de Guatemala";


		IOSDriver driver = (IOSDriver) AppTestCase.getActionDriver().getAppiumDriver();
		HomeTasks home = new HomeTasks(driver);
		home.closeModal();
		FooterTasks footer = new FooterTasks(driver);
		footer.clickAccount();
		AccountTasks account = new AccountTasks(driver);
		account.clickLogin();
		LoginTasks login = new LoginTasks(driver);
		login.fillForm();
		footer.waitHome();

		
		home.clickAddress();
		
		AddressTasks address = new AddressTasks(driver);
		address.allowLocation();
		address.newDirection();
		
		address.searchAddress(newAddress);
		common.logScreen("Mapa mostrado");
		address.goToResult();
		address.fillAddress(dept,mun,zone,exactAddress,additionalDetails,name);
		common.logScreen("Nuevos Campos llenados");
		address.saveAddress();
		home.isAddressDisplaed();
		Services services = new Services("alara7@yopmail.com","Test123");

		common.log("Direccion Guardada desde Banner de Bienvenida: " + home.getAddress());
		common.log("Respuesta de la API "+services.printApiAddress());
		services.deleteAddress();

	}


	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void BKTC_003_SaveAddressFromRestaurants() {
		String newAddress = "Calle Mar";
		String addressDetails = "El Picoteo Antojitos";

		IOSDriver driver = (IOSDriver) AppTestCase.getActionDriver().getAppiumDriver();
		HomeTasks home = new HomeTasks(driver);
		home.closeModal();
		FooterTasks footer = new FooterTasks(driver);
		footer.clickRestaurants();
		AddressTasks address = new AddressTasks(driver);
		address.allowLocation();
		address.searchAddress(newAddress);
		address.goToResult();
		//address.fillAddress(addressDetails, additionalDetails);
		address.saveAddress();
		home.isAddressDisplaed();
		common.log("Direccion Guardada desde Restaurantes: " + addressDetails);
	}

	/*
	 * @Test(retryAnalyzer = RetryAnalyzer.class) public void
	 * BKTC_004_CreateOrderNitAndCash() throws InterruptedException {
	 * 
	 * IOSDriver driver = (IOSDriver)
	 * AppTestCase.getActionDriver().getAppiumDriver(); HomeTasks home = new
	 * HomeTasks(driver); home.closeModal(); MenuTasks promos = new
	 * MenuTasks(driver); promos.setCategory("Promoción"); FooterTasks footer = new
	 * FooterTasks(driver); footer.clickAccount(); AccountTasks account = new
	 * AccountTasks(driver); account.clickLogin(); LoginTasks login = new
	 * LoginTasks(driver); login.fillForm(); footer.waitHome();
	 * promos.clickCategory(driver); ProductDetailTasks comboReconciliacion = new
	 * ProductDetailTasks(driver);
	 * comboReconciliacion.setProduct("Combo Reconciliación");
	 * comboReconciliacion.clickProduct(driver); String[] drinks = { "Pepsi", "7 UP"
	 * }; String[] extras = { "Dip Agridulce", "Dip Ranch", "Dip Bbw" }; String[]
	 * acomp = { "Papas Medianas" }; comboReconciliacion.addDrinks(drinks, 2);
	 * Actions.scrollDown(driver); comboReconciliacion.addExtras(extras, 4);
	 * Actions.scrollDown(driver);
	 * 
	 * comboReconciliacion.addDesserts(); Actions.scrollDown(driver);
	 * 
	 * comboReconciliacion.addAcomp(acomp, 2); comboReconciliacion.addToCart();
	 * promos.showCart(); CartTasks cart = new CartTasks(driver);
	 * cart.gotoCheckout(); CheckoutTasks checkout = new CheckoutTasks(driver);
	 * checkout.useNIT();
	 * 
	 * checkout.payWithCash();
	 * common.log("Orden Creada pagando en Efectivo y usando NIT, producto:" +
	 * comboReconciliacion.getProduct()); }
	 */
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void BKTC_005_CreateOrderCash() throws InterruptedException, UnirestException, IOException {
		String productString = "Fiesta Whopper";
		Services services = new Services("alara7@yopmail.com","Test123");
		services.addNewAddress();
		IOSDriver driver = (IOSDriver) AppTestCase.getActionDriver().getAppiumDriver();
		HomeTasks home = new HomeTasks(driver);
		home.closeModal();

		FooterTasks footer = new FooterTasks(driver);
		footer.clickAccount();
		AccountTasks account = new AccountTasks(driver);
		account.clickLogin();
		LoginTasks login = new LoginTasks(driver);
		login.fillForm();
		footer.waitHome();
		MenuTasks promos = new MenuTasks(driver);
		promos.setCategory("Promoción");
		promos.clickCategory(driver);
		ProductDetailTasks fiestaWhopper = new ProductDetailTasks(driver);
		fiestaWhopper.setProduct(productString);
		fiestaWhopper.clickProduct(driver);

		String[] drinks = { "Pepsi 1.5L" };
		String[] acomp = { "Papas", "Aros" };
		fiestaWhopper.addSinglesAcomp(acomp);
		Actions.scrollDown(driver);
		fiestaWhopper.addSinglesDrinks(drinks);
		fiestaWhopper.addToCart();
		promos.showCart();
		CartTasks cart = new CartTasks(driver);
		cart.gotoCheckout();
		CheckoutTasks checkout = new CheckoutTasks(driver);
		checkout.payWithCash();
		common.log("Orden Creada pagando en efectivo, producto:" + fiestaWhopper.getProduct());

	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void BKTC_007_CreateOrderCash() throws InterruptedException {

		IOSDriver driver = (IOSDriver) AppTestCase.getActionDriver().getAppiumDriver();
		HomeTasks home = new HomeTasks(driver);
		home.closeModal();
		MenuTasks promos = new MenuTasks(driver);
		promos.setCategory("Promoción");
		FooterTasks footer = new FooterTasks(driver);
		footer.clickAccount();
		AccountTasks account = new AccountTasks(driver);
		account.clickLogin();
		LoginTasks login = new LoginTasks(driver);
		login.fillForm();
		footer.waitHome();
		promos.clickCategory(driver);
		ProductDetailTasks comboReconciliacion = new ProductDetailTasks(driver);
		comboReconciliacion.setProduct("Combo Reconciliación");
		comboReconciliacion.clickProduct(driver);
		String[] drinks = { "Pepsi", "7 UP" };
		String[] extras = { "Dip Agridulce", "Dip Ranch", "Dip Bbw" };
		String[] acomp = { "Papas Medianas" };
		comboReconciliacion.addDrinks(drinks, 2);
		Actions.scrollDown(driver);
		comboReconciliacion.addExtras(extras, 4);
		Actions.scrollDown(driver);

		comboReconciliacion.addDesserts();
		Actions.scrollDown(driver);

		comboReconciliacion.addAcomp(acomp, 2);
		comboReconciliacion.addToCart();
		promos.showCart();
		CartTasks cart = new CartTasks(driver);
		cart.gotoCheckout();
		CheckoutTasks checkout = new CheckoutTasks(driver);

		checkout.payWithCash();
		common.log("Orden Creada pagando en Efectivo, producto:" + comboReconciliacion.getProduct());
	}
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void BKTC_008_CreateOrderSavedCard() throws InterruptedException, UnirestException, IOException {
		String productString = "Combo Reconciliación";
		Services services = new Services("alara7@yopmail.com","Test123");
		services.addNewAddress();
		IOSDriver driver = (IOSDriver) AppTestCase.getActionDriver().getAppiumDriver();
		HomeTasks home = new HomeTasks(driver);
		home.closeModal();
		MenuTasks promos = new MenuTasks(driver);
		promos.setCategory("Promoción");
		FooterTasks footer = new FooterTasks(driver);
		footer.clickAccount();
		AccountTasks account = new AccountTasks(driver);
		account.clickLogin();
		LoginTasks login = new LoginTasks(driver);
		login.fillForm();
		footer.waitHome();
		promos.clickCategory(driver);
		ProductDetailTasks comboReconciliacion = new ProductDetailTasks(driver);
		comboReconciliacion.setProduct(productString);
		comboReconciliacion.clickProduct(driver);
		String[] drinks = { "Pepsi", "7 UP" };
		String[] extras = { "Dip Agridulce", "Dip Ranch", "Dip Bbw" };
		String[] acomp = { "Papas Medianas" };
		common.logScreen("Detalle del producto");
		comboReconciliacion.addDrinks(drinks, 2);
		Actions.scrollDown(driver);
		comboReconciliacion.addExtras(extras, 4);
		Actions.scrollDown(driver);

		comboReconciliacion.addDesserts();
		Actions.scrollDown(driver);

		comboReconciliacion.addAcomp(acomp, 2);
		comboReconciliacion.addToCart();
		promos.showCart();
		common.logScreen("Pantalla de Carrito");
		CartTasks cart = new CartTasks(driver);
		cart.gotoCheckout();
		CheckoutTasks checkout = new CheckoutTasks(driver);
		checkout.isHeaderDisplayed();
		common.log("Checkout del producto:" +checkout.getProduct(productString));
		String frontendDetails = checkout.getDetail(productString);
		//double frontendPrice = checkout.getProductPrice(productString);
		common.log(frontendDetails);
		checkout.payWithSavedCard();
		double price = checkout.getTotal();
		checkout.order();
		
		common.log("Orden Creada pagando con Tarjeta, producto:" + comboReconciliacion.getProduct());
		services.deleteAddress();
		common.log(services.getOrderDescription());

		services.setResponseMap();
		services.getAmountValues();
		Assert.assertEquals(price, services.getTotalCoreAmount());
		common.log("Integracion correcta");
		common.log("Total en el frontend:" +price);
		common.log("Total en el Backend:"+services.getTotalCoreAmount());
		
		
		
		
		
	}


	/*
	 * @Test public void BKTC_006_CreateOrderBreakfast() throws InterruptedException
	 * {
	 * 
	 * IOSDriver driver = (IOSDriver)
	 * AppTestCase.getActionDriver().getAppiumDriver();
	 * 
	 * HomeTasks home = new HomeTasks(driver); home.closeModal(); FooterTasks footer
	 * = new FooterTasks(driver); footer.clickAccount(); AccountTasks account = new
	 * AccountTasks(driver); account.clickLogin(); LoginTasks login = new
	 * LoginTasks(driver); login.fillForm(); Thread.sleep(1000);
	 * Actions.scrollRightiOS(driver); Actions.scrollRightiOS(driver);
	 * 
	 * MenuTasks hotcakes = new MenuTasks(driver);
	 * hotcakes.setCategory("Panqueques"); hotcakes.clickCategory(driver);
	 * 
	 * ProductDetailTasks panqueques = new ProductDetailTasks(driver);
	 * panqueques.setProduct("Panqueques"); panqueques.clickProduct(driver);
	 * 
	 * panqueques.addToCart(); hotcakes.waitCart();
	 * 
	 * ProductDetailTasks panquequeHuevoyJamon = new ProductDetailTasks(driver);
	 * panquequeHuevoyJamon.setProduct("Panqueques Con Huevo Y Jamón");
	 * panquequeHuevoyJamon.clickProduct(driver); panquequeHuevoyJamon.addToCart();
	 * hotcakes.waitCart();
	 * 
	 * ProductDetailTasks panquequeHuevoySalchicha = new ProductDetailTasks(driver);
	 * panquequeHuevoySalchicha.setProduct("Panqueques Con Huevo Y Salchicha");
	 * panquequeHuevoySalchicha.clickProduct(driver);
	 * panquequeHuevoySalchicha.addToCart(); hotcakes.waitCart();
	 * hotcakes.showCart();
	 * 
	 * CartTasks cart = new CartTasks(driver);
	 * common.logScreen("Vista del carrito con Productos de Desayuno");
	 * 
	 * cart.gotoCheckout();
	 * 
	 * CheckoutTasks checkout = new CheckoutTasks(driver);
	 * 
	 * checkout.payWithCash();
	 * 
	 * 
	 * }
	 */

	@Override
	protected void cleanPageObjects() {
		// TODO Auto-generated method stub

	}

}
