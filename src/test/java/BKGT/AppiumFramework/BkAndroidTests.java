package BKGT.AppiumFramework;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.appium.setup.AppTestCase;

import BKGT.AppiumFramework.pages.AccountPage;
import BKGT.AppiumFramework.pages.AddressPage;
import BKGT.AppiumFramework.pages.Cart;
import BKGT.AppiumFramework.pages.Homepage;
import BKGT.AppiumFramework.pages.Loginpage;
import BKGT.AppiumFramework.pages.MenuPage;
import BKGT.AppiumFramework.products.ComboReconciliacion;
import io.appium.java_client.android.AndroidDriver;

public class BkAndroidTests extends AppTestCase {
	private String className = this.getClass().getSimpleName();

	String address = "El Picoteo Antojitos";
	String editedAddress = "Avenida 20 Proyectos 4-10";

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		initializeAppTest(className,"Android");
	}

	@Test
	public void BKTC_001_GuestUserSaveAddress() throws InterruptedException {
		AndroidDriver driver = (AndroidDriver) AppTestCase.getActionDriver().getAppiumDriver();
		String searchAddress = "Calle Mar";
		Homepage homepage = new Homepage(driver);
		AddressPage addressPage = new AddressPage(driver);
		System.out.println(homepage.getWelcomeMessage());
		common.logScreen("Mensaje de Bienvenida");
		homepage.goToDirections();
		assertEquals(true, addressPage.isPageLoaded());
		addressPage.searchAddres(searchAddress);
		addressPage.fillAddress(address);
		common.logScreen("Campos llenados");
		addressPage.saveAddress();
		Thread.sleep(1000);
		Assert.assertEquals(homepage.validateSavedAddress(address), true);
		common.log("Direccion Guardada");
	}
	



	@Test
	public void BKTC_002_Login_Logout() throws InterruptedException {
		AndroidDriver driver = (AndroidDriver) AppTestCase.getActionDriver().getAppiumDriver();
		Homepage homepage = new Homepage(driver);
		Assert.assertEquals(homepage.isBannerLoaded(), true);
		common.logScreen("Homepage y mensaje de Bienvenida mostrado");
		homepage.closeModal();
		homepage.clickAccount();

		AccountPage accountPage = new AccountPage(driver);
		common.log("Click en Mi Cuenta");
		Assert.assertEquals(accountPage.isGuestViewDisplayed(), true);
		common.logScreen("Vista de la pantalla Mi Cuenta como Usuario Invitado");
		accountPage.clickGoLoginButton();
		Loginpage loginPage = new Loginpage(driver);
		Assert.assertEquals(loginPage.isLoginPageLoaded(), true);
		common.logScreen("Formuario para Iniciar Sesion");
		loginPage.enterEmail("alara6@yopmail.com");
		loginPage.enterPassword("Test123");
		loginPage.clickLoginButton();
		Assert.assertEquals(homepage.isPageLoaded(), true);
		common.logScreen("Pantalla de Home de Usuario Registrado");
		homepage.clickAccount();
		Assert.assertEquals(accountPage.isAccountViewDisplayed(), true);
		common.logScreen("Vista de la pantalla Mi Cuenta como Usuario Registrado");
		common.log("Mensaje para el usuario:" + accountPage.getAccountMessage());
		accountPage.clickLogoutButton();
		Assert.assertEquals(loginPage.isLoginPageLoaded(), true);
		common.log("Click en Cerrar Sesion");
	}

	@Test

	public void BKTC_003_CreateOrder() throws InterruptedException {

		AndroidDriver driver = (AndroidDriver) AppTestCase.getActionDriver().getAppiumDriver();
		Homepage homepage = new Homepage(driver);
		Assert.assertEquals(homepage.isBannerLoaded(), true);
		homepage.closeModal();
		homepage.clickAccount();

		AccountPage accountPage = new AccountPage(driver);
		Assert.assertEquals(accountPage.isGuestViewDisplayed(), true);
		accountPage.clickGoLoginButton();
		Loginpage loginPage = new Loginpage(driver);
		Assert.assertEquals(loginPage.isLoginPageLoaded(), true);
		loginPage.enterEmail("alara6@yopmail.com");
		loginPage.enterPassword("Test123");
		loginPage.clickLoginButton();
		Assert.assertEquals(homepage.isPageLoaded(), true);
		common.logScreen("Pantalla de Home de Usuario Registrado");
		loginPage.btnCombos.click();
		MenuPage menu = new MenuPage(driver);
		common.logScreen("Producto Agregado al Carrito:  " + menu.agregarComboWhoperTejano());
		menu.clickCart();
		Cart cart = new Cart(driver);
		Assert.assertEquals(cart.isDisplayed(), true);
		common.logScreen("Vista del Carrito");
		cart.goPay();
		cart.order();
		Thread.sleep(4000);
		common.logScreen("Orden Confirmada");
		homepage.isPageLoaded();
		common.log("Orden creada");

	}

	@Test
	public void BKTC_004_CreateOrderComboReconciliacion() throws InterruptedException {

		AndroidDriver driver = (AndroidDriver) AppTestCase.getActionDriver().getAppiumDriver();
		Homepage homepage = new Homepage(driver);
		Assert.assertEquals(homepage.isBannerLoaded(), true);
		homepage.closeModal();
		//homepage.clickAccount();

		/*
		 * AccountPage accountPage = new AccountPage(driver);
		 * Assert.assertEquals(accountPage.isGuestViewDisplayed(), true);
		 * accountPage.clickGoLoginButton();
		 */
		Loginpage loginPage = new Loginpage(driver);
		/*
		 * Assert.assertEquals(loginPage.isLoginPageLoaded(), true);
		 * loginPage.enterEmail("alara6@yopmail.com");
		 * loginPage.enterPassword("Test123"); loginPage.clickLoginButton();
		 * Assert.assertEquals(homepage.isPageLoaded(), true);
		 * common.logScreen("Pantalla de Home de Usuario Registrado");
		 */
		loginPage.btnPromo.click();
		MenuPage menu = new MenuPage(driver);
		menu.promotions.clickComboReconciliacion();
		Thread.sleep(2000);

		ComboReconciliacion comboReconciliacion = new ComboReconciliacion(driver);
		comboReconciliacion.setMods();

		Assert.assertEquals(comboReconciliacion.isProductVisible(), true);
		common.logScreen("Detalle de Combo Reconciliacion");
		/*
		 * comboReconciliacion.addDrinks(); common.log("Se agregaron bebidas");
		 * comboReconciliacion.scrollDown(); comboReconciliacion.addExtras();
		 * common.log("Dips agregados"); comboReconciliacion.addDesserts();
		 * common.log("Postres agregados"); comboReconciliacion.addFries();
		 * common.log("Papas Fritas agregadas"); comboReconciliacion.addToCart();
		 * common.logScreen("Agregado al Carrito"); menu.clickCart();
		 * 
		 * Cart cart = new Cart(driver); Assert.assertEquals(cart.isDisplayed(), true);
		 * common.logScreen("Vista del Carrito"); cart.goPay(); cart.order();
		 * Thread.sleep(4000); common.logScreen("Orden Confirmada");
		 * homepage.isPageLoaded(); common.log("Orden creada");
		 */

	}
	
	@Test

	public void BKTC_003_Scroll() throws InterruptedException {

		AndroidDriver driver = (AndroidDriver) AppTestCase.getActionDriver().getAppiumDriver();
		Homepage homepage = new Homepage(driver);
		Assert.assertEquals(homepage.isBannerLoaded(), true);
		homepage.closeModal();
		homepage.btnCombos.click();
		MenuPage menu = new MenuPage(driver);
		common.logScreen("Producto Agregado al Carrito:  " + menu.agregarComboWhoperTejano());
		menu.clickCart();
		Cart cart = new Cart(driver);
		Assert.assertEquals(cart.isDisplayed(), true);
		common.logScreen("Vista del Carrito");
	

	}


	@Override
	protected void cleanPageObjects() {
		// TODO Auto-generated method stub

	}

}