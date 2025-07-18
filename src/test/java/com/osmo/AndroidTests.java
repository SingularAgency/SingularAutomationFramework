package com.osmo;

import com.appium.setup.AppTestCase;
import com.osmo.pages.steps.InviertePageSteps;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AndroidTests extends AppTestCase {
    private String className = this.getClass().getSimpleName();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        initializeAppTest(className, "Android");
    }

    @Test
    public void VCTC001_CheckBitcoinPrice() throws InterruptedException {
        AndroidDriver driver = (AndroidDriver) AppTestCase.getActionDriver().getAppiumDriver();
        InviertePageSteps inviertePageSteps = new InviertePageSteps(driver);
        common.log("Precio actual del Bitcoin:" + inviertePageSteps.getBictoinPrice());
    }

    @Test
    public void VCTC002_AttemptBuyWithoutKYC() throws InterruptedException {

        AndroidDriver driver = (AndroidDriver) AppTestCase.getActionDriver().getAppiumDriver();
        InviertePageSteps inviertePageSteps = new InviertePageSteps(driver);
        Assert.assertTrue(inviertePageSteps.attemptToBuyWithoutKYC());
        common.log(inviertePageSteps.getModalVerificacion().getAttribute("content-desc"));
    }

    @Test
    public void VCTC003_AttemptBuyWithKYC() throws InterruptedException {
        AndroidDriver driver = (AndroidDriver) AppTestCase.getActionDriver().getAppiumDriver();
        InviertePageSteps inviertePageSteps = new InviertePageSteps(driver);
        Assert.assertFalse(inviertePageSteps.attemptToBuyWithoutKYC());
        common.log(inviertePageSteps.getModalVerificacion().getAttribute("content-desc"));

    }

    @Override
    protected void cleanPageObjects() {
        // TODO Auto-generated method stub

    }
}