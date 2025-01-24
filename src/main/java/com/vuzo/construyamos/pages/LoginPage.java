package com.vuzo.construyamos.pages;

import com.appium.setup.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

@Getter
public class LoginPage extends BasePage {
    public LoginPage(AppiumDriver driver) {
        super(driver);
    }
    @AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
    public WebElement txtEmail;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
    public WebElement txtPassword;

    @AndroidFindBy(accessibility = "Entrar")
    public WebElement btnLogin;

    @AndroidFindBy(accessibility = "Ingresar")
    public WebElement btnIngresar;






}
