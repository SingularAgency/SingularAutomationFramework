package BKGT.AppiumFramework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import BKGT.AppiumFramework.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Loginpage extends BasePage{

	AndroidDriver driver;

	@AndroidFindBy(xpath="//*[@resource-id=\" email\"]//android.widget.EditText")
	private WebElement txtEmail;
	@AndroidFindBy(xpath="//*[@resource-id=\"password\"]//android.widget.EditText")
	private WebElement txtPassword;
	@AndroidFindBy(xpath="//*[@resource-id=\"loginBtn\"]//android.widget.Button")
	private WebElement btnLogin;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Regístrate ahora')]")
	private WebElement btnSignin;
	
	@AndroidFindBy(id="mail E-mail")
	private WebElement btnEmail;
	
	@AndroidFindBy(xpath="//android.widget.Button[contains(@text,'Avanzar sin registro')]")
	private WebElement btnGuest;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc='¿Olvidaste tu contraseña?']/android.widget.TextView")
	private WebElement btnForgotPassword;
	

	public Loginpage(AndroidDriver driver) {
		super(driver);

	}
	
	
	public boolean isLoginPageLoaded() {
		return waitForElementVisible(txtEmail).isDisplayed();

	}
	
	public void enterEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void enterPassword(String password) throws InterruptedException {
        txtPassword.sendKeys(password);
        Thread.sleep(500);
        txtPassword.click();
    }

    public void clickLoginButton() {
    	wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
        btnLogin.click();
    }

    public void clickSigninButton() {
        btnSignin.click();
    }

    public void clickEmailButton() {
        btnEmail.click();
    }

    public void clickGuestButton() {
        btnGuest.click();
    }

    public void clickForgotPasswordButton() {
        btnForgotPassword.click();
    }
	
}
