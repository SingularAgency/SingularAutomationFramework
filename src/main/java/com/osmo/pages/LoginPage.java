package com.osmo.pages;

import com.appium.setup.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Ingresar\"]")
    private WebElement btnLogin;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Crear cuenta\"]")
    private WebElement btnCreateAccount;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,\"correo electrónico\")]")
    private WebElement btnAccessWithEmail;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"correo electrónico\")]/following-sibling::android.widget.EditText")
    private WebElement txtEmail;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Continuar\"]")
    private WebElement btnContinue;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"código\")]//android.widget.EditText")
    private WebElement txtOTPCode;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Dismiss\"]/following-sibling::android.widget.Button")
    private WebElement btnCloseGoogleWindow;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Pegar\"]")
    private WebElement btnPaste;

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getBtnAccessWithEmail() {
        return btnAccessWithEmail;
    }

    public WebElement getBtnContinue() {
        return btnContinue;
    }

    public WebElement getBtnCreateAccount() {
        return btnCreateAccount;
    }

    public WebElement getBtnCloseGoogleWindow() {
        return btnCloseGoogleWindow;
    }

    public WebElement getTxtEmail() {
        return txtEmail;
    }

    public WebElement getBtnLogin() {
        return btnLogin;
    }

    public WebElement getTxtOTPCode() {
        return txtOTPCode;
    }

    public WebElement getBtnPaste() {
        return btnPaste;
    }

}
