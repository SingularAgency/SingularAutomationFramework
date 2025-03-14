package com.osmo;

import com.appium.setup.AppTestCase;
import com.appium.util.ConfigKey;
import com.google.common.collect.ImmutableMap;
import com.osmo.pages.HomePage;
import com.osmo.pages.steps.SWAPSteps;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class SWAPTests extends AppTestCase {
    private String className = this.getClass().getSimpleName();
    HomePage homePage;
    SWAPSteps swapSteps;
    AndroidDriver driver;
    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        initializeAppTest(className, "Android");
    }
    @BeforeMethod
    public void initializePageObjects() throws IOException {
        driver = (AndroidDriver) AppTestCase.getActionDriver().getAppiumDriver();
        homePage= new HomePage(driver);
        swapSteps = new SWAPSteps(driver);
        homePage.fluentWait.until(ExpectedConditions.visibilityOf(homePage.getBtn2()));
        homePage.getBtn2().click();
        homePage.getBtn0().click();
        homePage.getBtn2().click();
        homePage.getBtn0().click();
        homePage.getBtn2().click();
        homePage.getBtn0().click();
        //Runtime.getRuntime().exec("/Users/cruyfj/Library/Android/sdk/platform-tools/adb pm clear "+ ConfigKey.MAIN_ACTIVITY);
        //Runtime.getRuntime().exec("/Users/cruyfj/Library/Android/sdk/platform-tools/adb shell am start -n "+ ConfigKey.MAIN_ACTIVITY);

    }

    @Test
    public void performBTCtoQTZ(){
        homePage.wait.until(ExpectedConditions.visibilityOf(homePage.getBtnSWAP()));
        homePage.getBtnSWAP().click();
        swapSteps.performSWAP("Bitcoin","Quetzales");

    }

    @AfterMethod
    public void tearDown() throws IOException {
        Runtime.getRuntime().exec("/Users/cruyfj/Library/Android/sdk/platform-tools/adb am force-stop " + ConfigKey.MAIN_ACTIVITY);
    }

    @Override
    protected void cleanPageObjects() {

    }
}
