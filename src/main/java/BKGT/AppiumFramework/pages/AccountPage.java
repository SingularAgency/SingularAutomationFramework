package BKGT.AppiumFramework.pages;

import org.openqa.selenium.WebElement;

import BKGT.AppiumFramework.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AccountPage extends BasePage{
	
	AndroidDriver driver;

	@AndroidFindBy(xpath="//android.view.View[@content-desc='Regístrate ahora']")
	private WebElement btnRegister;
	@AndroidFindBy(xpath="//android.view.View[@content-desc='¿Ya registrado? ¡Entre aquí!']/android.widget.TextView")
	private WebElement btnGoLogin;
	
	@AndroidFindBy(xpath="//android.widget.Button[contains(@text,'Cerrar Sesión')]")
	private WebElement btnLogout;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'¡Hola')]")
	private WebElement lblAccountMessage;
	
	@AndroidFindBy(xpath="//android.widget.Button[contains(@text,'Eliminar mi cuenta')]")
	private WebElement btnDeleteAccount;
	
	@AndroidFindBy(xpath="//android.view.View[contains(@text,'Mis datos')]")
	private WebElement btnMyInfo;
	
	@AndroidFindBy(xpath="//android.view.View[contains(@text,'Mis direcciones')]")
	private WebElement btnMyAddress;
	
	@AndroidFindBy(xpath="//android.view.View[contains(@text,'Mis tarjetas')]")
	private WebElement btnMyCards;
	
	@AndroidFindBy(xpath="//android.view.View[contains(@text,'Mis órdenes Mira el historial de tus pedidos')]")
	private WebElement btnMyOrders;
	
	
	@AndroidFindBy(xpath="//android.view.View[contains(@text,'Términos y Condiciones Revisa nuestros términos y condiciones')]")
	private WebElement btnTerms;
	

	
	public AccountPage(AndroidDriver driver) {
		super(driver);


	}
	
	public boolean isGuestViewDisplayed() {
		
		return waitForElementVisible(btnRegister).isDisplayed();
	}
	
	
	public boolean isAccountViewDisplayed() {
		return waitForElementVisible(btnMyInfo).isDisplayed();

	}
	
	
    public void clickRegisterButton() {
        btnRegister.click();
    }

    public void clickGoLoginButton() {
        btnGoLogin.click();
    }

    public void clickLogoutButton() {
        btnLogout.click();
    }
    
    public String getAccountMessage() {
    	return lblAccountMessage.getText();
    }

    public void clickDeleteAccountButton() {
        btnDeleteAccount.click();
    }

    public void clickMyInfoButton() {
        btnMyInfo.click();
    }

    public void clickMyAddressButton() {
        btnMyAddress.click();
    }

    public void clickMyCardsButton() {
        btnMyCards.click();
    }

    public void clickMyOrdersButton() {
        btnMyOrders.click();
    }

    public void clickTermsButton() {
        btnTerms.click();
    }

}
