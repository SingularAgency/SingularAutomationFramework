package com.gb.pages.steps;

import com.gb.pages.HomePage;
import com.gb.pages.LoginPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPageSteps extends LoginPage {
    public LoginPageSteps(AppiumDriver driver) {
        super(driver);
    }


    public void loginWithPhone(String phoneNumber, String otp){
        wait.until(ExpectedConditions.visibilityOf(getBtnLoginWithPhone()));
        getBtnLoginWithPhone().click();
        wait.until(ExpectedConditions.visibilityOf(getTxtEditBox()));
        getTxtEditBox().sendKeys(phoneNumber);
        getBtnContinue().click();
        wait.until(ExpectedConditions.visibilityOf(getLblVerifyIdentity()));
        getTxtEditBox().sendKeys(otp);
        getBtnContinue().click();

    }
}
