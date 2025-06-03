package com.osmo;

import com.appium.setup.AppTestCase;
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
        driver.activateApp(appBundleId);
        homePage.fluentWait.until(ExpectedConditions.visibilityOf(homePage.getBtn2()));
        homePage.getBtn2().click();
        homePage.getBtn0().click();
        homePage.getBtn2().click();
        homePage.getBtn0().click();
        homePage.getBtn2().click();
        homePage.getBtn0().click();

    }

    @Test
    public void performBTCtoQTZ(){
        homePage.wait.until(ExpectedConditions.visibilityOf(homePage.getBtnSWAP()));
        homePage.getBtnSWAP().click();
        swapSteps.performSWAP("Bitcoin","Quetzales");
    }

    @Test
    public void performBTCtoCRC(){
        homePage.wait.until(ExpectedConditions.visibilityOf(homePage.getBtnSWAP()));
        homePage.getBtnSWAP().click();
        swapSteps.performSWAP("Bitcoin","Colones");
    }

    @Test
    public void performBTCtoDollars(){
        homePage.wait.until(ExpectedConditions.visibilityOf(homePage.getBtnSWAP()));
        homePage.getBtnSWAP().click();
        swapSteps.performSWAP("Bitcoin","Dólares");
    }


    @AfterMethod
    public void closeApp()  {
        driver.terminateApp(appBundleId);
    }


    @Override
    protected void cleanPageObjects() {

    }
}
