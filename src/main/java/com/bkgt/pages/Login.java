package com.bkgt.pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Login extends BasePage{
	public Login(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[1]")
	@AndroidFindBy(xpath="//*[@resource-id=\" email\"]//android.widget.EditText")
	protected WebElement txtEmail;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
	@AndroidFindBy(xpath="//*[@resource-id=\"password\"]//android.widget.EditText")
	protected WebElement txtPassword;
	
	@iOSXCUITFindBy(accessibility = "Iniciar sesión")
	@AndroidFindBy(xpath="//*[@resource-id=\"loginBtn\"]//android.widget.Button")
	protected WebElement btnLogin;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Regístrate ahora')]")
	protected WebElement btnSignin;
	
	@AndroidFindBy(id="mail E-mail")
	protected WebElement btnEmail;
	
	@AndroidFindBy(xpath="//android.widget.Button[contains(@text,'Avanzar sin registro')]")
	protected WebElement btnGuest;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc='¿Olvidaste tu contraseña?']/android.widget.TextView")
	protected WebElement btnForgotPassword;
}
