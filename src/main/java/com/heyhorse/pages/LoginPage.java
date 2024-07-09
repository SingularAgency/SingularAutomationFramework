package com.heyhorse.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    protected WebDriverWait wait;

    public LoginPage(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @AndroidFindBy(accessibility="Sign in")
    protected WebElement btnSignIn;

    @AndroidFindBy(xpath="//android.view.View[@content-desc=\"Your equestrian life \n" +
            "made easy.\"]")
    protected WebElement body;

    @AndroidFindBy(xpath="(//android.widget.EditText)[1]")
    protected WebElement txtEmail;

    @AndroidFindBy(xpath="(//android.widget.EditText)[2]")
    protected WebElement txtPassword;

    @AndroidFindBy(accessibility="Login")
    protected WebElement btnLogin;

    public void signIn(){
        wait.until(ExpectedConditions.elementToBeClickable(btnSignIn));
        btnSignIn.click();
    }

    public boolean isPageLoaded(){
        return wait.until(ExpectedConditions.visibilityOf(body)).isDisplayed();

    }

    public void clickSignIn(){
        wait.until(ExpectedConditions.elementToBeClickable(btnSignIn));
        btnSignIn.click();

    }

    public void enterCredentials(String email, String password){
                wait.until(ExpectedConditions.elementToBeClickable(txtEmail));
                txtEmail.click();
                txtEmail.sendKeys(email);
                txtPassword.click();
                txtPassword.sendKeys(password);
    }

    public void attemptToLogin(){
                wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
                btnLogin.click();
    }



}
