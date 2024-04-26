package BKGT.AppiumFramework;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import BKGT.AppiumFramework.pages.AccountPage;
import BKGT.AppiumFramework.pages.AddressPage;
import BKGT.AppiumFramework.pages.Homepage;
import BKGT.AppiumFramework.pages.Loginpage;
import BKGT.AppiumFramework.pages.MenuPage;

public class Example extends BaseTest {

	public Homepage homepage;
	public AddressPage addressPage;
	public MenuPage menu;
	public AccountPage accountPage;
	public Loginpage loginPage;
	String address = "El Picoteo Antojitos";
	String editedAddress = "Avenida 20 Proyectos 4-10";


	@BeforeMethod
	public void setUp() throws MalformedURLException {
		driver=initializeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	
	@Test
	public void TC001_GuestUser_SaveAddresFromWelcomeModal() throws InterruptedException {
		test = ExtentManager.createTest("Test 1");

		try {
			String searchAddress = "Calle Mar";
			test.log(Status.INFO, "Abriendo App");

			homepage = new Homepage(driver);
			addressPage = new AddressPage(driver);
			// System.out.println(homepage.getWelcomeMessage());
			homepage.goToDirections();
			assertEquals(true, addressPage.isPageLoaded());
			addressPage.searchAddres(searchAddress);
			addressPage.fillAddress(address);
			addressPage.saveAddress();
			Assert.assertEquals(homepage.validateSavedAddress(address), true);
			test.log(Status.INFO, "Direccion Guardada",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshot()).build());
			test.pass("Finalizando prueba");


		}catch (AssertionError e) {
            // Catch assertion failures
            test.fail("Assertion failed: " + e.getMessage());
        } catch (Exception e) {
            // Catch other exceptions
            test.fail("Test failed: " + e.getMessage());
        }
	
	}


	@Test
	public void TC002_Playground() throws InterruptedException, IOException {
		test = ExtentManager.createTest("Test 2");

		try {
			String searchAddress = "Calle Mar";
			//String searchAddress2 ="proyec";
			test.log(Status.INFO, "Abriendo App");

			homepage = new Homepage(driver);
			test.log(Status.INFO, "Texto del pop-up por la tarde:" + homepage.getWelcomeMessageMorning(),
					MediaEntityBuilder.createScreenCaptureFromPath(screenshot()).build());
			homepage.closeModal();
			// Your test logic here

			homepage.clickAccount();
			accountPage = new AccountPage(driver);

			Assert.assertEquals(accountPage.isGuestViewDisplayed(), true);
			test.log(Status.INFO, "Pantalla Cuenta de Guest user",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshot()).build());
			accountPage.clickGoLoginButton();
			loginPage = new Loginpage(driver);
			Assert.assertEquals(loginPage.isLoginPageLoaded(), true);

			test.log(Status.INFO, "Pantalla Login",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshot()).build());
			loginPage.enterEmail("alara6@yopmail.com");
			loginPage.enterPassword("Test123");
			loginPage.clickLoginButton();
			homepage.clickAccount();
			Assert.assertEquals(accountPage.isAccountViewDisplayed(), true);

			test.log(Status.INFO, "Pantalla Cuenta de Usuario Registrado",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshot()).build());

			Thread.sleep(3000);
			homepage.clickHome();
			Thread.sleep(1000);
			homepage.clickAddress();
			Thread.sleep(500);
			test.log(Status.INFO, "Permisos de Ubicacion solicitados",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshot()).build());

			homepage.allowLocation();
			addressPage = new AddressPage(driver);
			addressPage.searchAddres(searchAddress);
			addressPage.fillAddress(address);
			test.log(Status.INFO, "Llenando campos de direccion",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshot()).build());
			
			addressPage.saveAddress();
			Assert.assertEquals(homepage.validateSavedAddress(address), true);
			test.log(Status.INFO, "Direccion Guardada",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshot()).build());
			
			

			homepage.scrollRight();
			test.log(Status.INFO, "Finalizando prueba");
			test.pass("Test passed: ", MediaEntityBuilder.createScreenCaptureFromPath(screenshot()).build());
		} catch (AssertionError e) {
            // Catch assertion failures
            test.fail("Assertion failed: " + e.getMessage());
        } catch (Exception e) {
            // Catch other exceptions
            test.fail("Test failed: " + e.getMessage());
        }

	}

	@AfterMethod
	public void tearDown() {
 		driver.quit();
	}


}
