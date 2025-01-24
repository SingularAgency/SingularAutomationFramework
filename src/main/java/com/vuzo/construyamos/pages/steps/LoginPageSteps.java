package com.vuzo.construyamos.pages.steps;

import com.vuzo.construyamos.pages.LoginPage;
import com.vuzo.construyamos.pages.SharedPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPageSteps extends LoginPage {

    SharedPage sharedPage;
    public LoginPageSteps(AppiumDriver driver) {
        super(driver);
        sharedPage= new SharedPage(driver);
    }

    public void performLoginConstruyamos(String email, String password){
        wait.until(ExpectedConditions.visibilityOf(getTxtEmail()));
        getTxtEmail().click();
        getTxtEmail().sendKeys(email);
        getTxtPassword().click();
        getTxtPassword().sendKeys(password);
        getBtnLogin().click();
    }

    public void perforLoginVuzoAdmin(String email, String password){
       WebElement txtEmail =  sharedPage.getTxtGenericBox();
       txtEmail.click();
       txtEmail.sendKeys(email);
       getBtnIngresar().click();
       WebElement txtPassword = sharedPage.getTxtGenericBox();
       txtPassword.click();
       txtPassword.sendKeys(password);
       getBtnIngresar().click();
       wait.until(ExpectedConditions.visibilityOf(sharedPage.getBtnProyectos()));
    }


}
