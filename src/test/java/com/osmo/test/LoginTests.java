package com.osmo.test;

import com.appium.setup.AppTestCase;

import com.osmo.pages.steps.LoginSteps;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class LoginTests extends AppTestCase {
    private LoginSteps loginPageSteps;
    AndroidDriver driver;

    public LoginTests() {
        this.configSuffix = "osmo";  // así configuras el sufijo antes de @BeforeClass
    }

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        initializeAppTest(this.getClass().getSimpleName(), "Android", "osmo");
    }

    @BeforeMethod
    public void initializePageObjects() throws IOException {
        driver = (AndroidDriver) AppTestCase.getActionDriver().getAppiumDriver();
        loginPageSteps = new LoginSteps(driver);
        clearCache();
        driver.activateApp(appBundleId);
    }

    @Test
    public void loginWithMXAccount() throws InterruptedException, GeneralSecurityException, IOException {
        loginPageSteps.performLoginWithEmail("alara@singularagency.co");
    }


    @Override
    protected void cleanPageObjects() {

    }
}
