package com.lifescore.test;

import com.appium.setup.AppTestCase;
import com.appium.util.ConfigKey;
import com.lifescore.pages.steps.LoginPageSteps;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;


public class CreateAccountScenariosTests extends AppTestCase {

    private LoginPageSteps loginPageSteps;

    public CreateAccountScenariosTests() {
        this.configSuffix = "lifescore";  // así configuras el sufijo antes de @BeforeClass
    }

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        initializeAppTest(this.getClass().getSimpleName(), "Android", "lifescore");
    }

    @BeforeMethod
    public void initializePageObjects() throws IOException {
        AndroidDriver driver = (AndroidDriver) AppTestCase.getActionDriver().getAppiumDriver();
        loginPageSteps = new LoginPageSteps(driver);
        Runtime.getRuntime().exec("/Users/cruyfj/Library/Android/sdk/platform-tools/adb pm clear "+ ConfigKey.MAIN_ACTIVITY);
        Runtime.getRuntime().exec("/Users/cruyfj/Library/Android/sdk/platform-tools/adb shell am start -n "+ ConfigKey.MAIN_ACTIVITY);

    }

    @Test
    public void LS_TC01_LoginWithoutEmailAndPassword(){
        loginPageSteps.attemptToLoginWithoutEmailAndPassword();
    }


    @Override
    protected void cleanPageObjects() {

    }
}
