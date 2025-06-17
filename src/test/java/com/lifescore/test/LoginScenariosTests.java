package com.lifescore.test;

import com.appium.setup.AppTestCase;

import com.appium.util.ConfigKey;
import com.lifescore.pages.steps.LoginPageSteps;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginScenariosTests extends AppTestCase {
    private LoginPageSteps loginPageSteps;
    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        initializeAppTest(this.getClass().getSimpleName(), "Android");
    }

    @BeforeMethod
    public void initializePageObjects() throws IOException {
        AndroidDriver driver = (AndroidDriver) AppTestCase.getActionDriver().getAppiumDriver();
        loginPageSteps = new LoginPageSteps(driver);
    }


    @Test
    public void LS_TC01_LoginWithoutEmailAndPassword(){
        loginPageSteps.attemptToLoginWithoutEmailAndPassword();
    }

    @Test
    public void LS_TC02_LoginWithoutEmail(){
        loginPageSteps.attemptToLoginWithoutEmail("dummy");
    }

    @Test
    public void LS_TC03_LoginWithInvalidEmail(){
        loginPageSteps.failWithoutPasswordAndEmailIssue("asfasf");
    }

    @Test
    public void LS_TC04_LoginWithUnregisteredEmail(){
        loginPageSteps.failLoginDueUnregisteredEmail("mail@mail.com","dummy");
    }

    @Test
    public void LS_TC05_LoginWithWrongPassword(){
        loginPageSteps.failLoginDueWrongPassword("caserez199828@gmail.com","1235");
    }

    @Test
    public void LS_TC05_LoginWithoutPassword(){
        loginPageSteps.attemptToLoginWithoutPassword("caserez199828@gmail.com");
        Assert.fail("Server is broken");
    }




    @Override
    protected void cleanPageObjects() {

    }
}
