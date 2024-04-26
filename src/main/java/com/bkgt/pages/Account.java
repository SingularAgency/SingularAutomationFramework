package com.bkgt.pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Account extends BasePage{
	public Account(AppiumDriver driver) {
		super(driver);
		
	}


	@iOSXCUITFindBy(accessibility = "Regístrate ahora")
	@AndroidFindBy(xpath="//android.view.View[@content-desc='Regístrate ahora']")
	protected WebElement btnRegister;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'¿Ya registrado?')]")
	@AndroidFindBy(xpath="//android.view.View[@content-desc='¿Ya registrado? ¡Entre aquí!']/android.widget.TextView")
	protected WebElement btnGoLogin;
	
	@AndroidFindBy(xpath="//android.widget.Button[contains(@text,'Cerrar Sesión')]")
	protected WebElement btnLogout;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'¡Hola')]")
	protected WebElement lblAccountMessage;
	
	@AndroidFindBy(xpath="//android.widget.Button[contains(@text,'Eliminar mi cuenta')]")
	protected WebElement btnDeleteAccount;
	
	@AndroidFindBy(xpath="//android.view.View[contains(@text,'Mis datos')]")
	protected WebElement btnMyInfo;
	
	@AndroidFindBy(xpath="//android.view.View[contains(@text,'Mis direcciones')]")
	protected WebElement btnMyAddress;
	
	@AndroidFindBy(xpath="//android.view.View[contains(@text,'Mis tarjetas')]")
	protected WebElement btnMyCards;
	
	@AndroidFindBy(xpath="//android.view.View[contains(@text,'Mis órdenes Mira el historial de tus pedidos')]")
	protected WebElement btnMyOrders;
	
	
	@AndroidFindBy(xpath="//android.view.View[contains(@text,'Términos y Condiciones Revisa nuestros términos y condiciones')]")
	protected WebElement btnTerms;
}
