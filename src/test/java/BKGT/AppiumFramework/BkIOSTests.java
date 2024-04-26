package BKGT.AppiumFramework;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.appium.setup.AppTestCase;

import BKGT.AppiumFramework.pages.Homepage;
import BKGT.AppiumFramework.pages.MenuPage;
import BKGT.AppiumFramework.products.ComboReconciliacion;
import io.appium.java_client.ios.IOSDriver;

public class BkIOSTests extends AppTestCase {
	private String className = this.getClass().getSimpleName();

	String address = "El Picoteo Antojitos";
	String editedAddress = "Avenida 20 Proyectos 4-10";
	

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		initializeAppTest(className,"iOS");
	}
	
	@Test
	public void BKTC_001_GuestUserSaveAddress() throws InterruptedException {
		IOSDriver driver = (IOSDriver) AppTestCase.getActionDriver().getIOSDriver();
		Homepage homepage = new Homepage(driver);
		homepage.isBannerLoaded();
		homepage.closeModal();
		homepage.btnPromo.click();

		MenuPage menu = new MenuPage(driver);
		menu.promotions.clickComboReconciliacion();
		Thread.sleep(2000);
		
		  ComboReconciliacion comboReconciliacion = new ComboReconciliacion(driver);
		  comboReconciliacion.setMods();
		  
		  Assert.assertEquals(comboReconciliacion.isProductVisible(), true);
		  common.logScreen("Detalle de Combo Reconciliacion");
		  comboReconciliacion.addDrinks(); common.log("Se agregaron bebidas");
		  comboReconciliacion.scrollDown(); comboReconciliacion.addExtras();
		  common.log("Dips agregados"); comboReconciliacion.addDesserts();
		  common.log("Postres agregados"); comboReconciliacion.addFries();
		  common.log("Papas Fritas agregadas"); comboReconciliacion.addToCart();
		  common.logScreen("Agregado al Carrito"); menu.clickCart();
	}
	
	
	@Test
	public void BKTC_001_Carrousel() throws InterruptedException {
		IOSDriver driver = (IOSDriver) AppTestCase.getActionDriver().getAppiumDriver();
		Homepage homepage = new Homepage(driver);
		homepage.isBannerLoaded();

		
	
		

	}



	@Override
	protected void cleanPageObjects() {
		// TODO Auto-generated method stub
		
	}
}
