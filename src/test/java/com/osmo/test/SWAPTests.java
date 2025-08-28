package com.osmo.test;

import api.steps.OsmoAPISteps;
import com.appium.setup.AppTestCase;
import com.appium.util.Constants;
import com.appium.util.LogcatHelper;
import com.osmo.pages.HomePage;
import com.osmo.pages.steps.LoginSteps;
import com.osmo.pages.steps.SWAPSteps;
import com.osmo.pages.steps.TransferirPageSteps;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.GeneralSecurityException;

public class SWAPTests extends AppTestCase {
    HomePage homePage;
    SWAPSteps swapSteps;
    OsmoAPISteps osmoAPISteps;
    AndroidDriver driver;
    TransferirPageSteps transferirPageSteps;
    BigDecimal initialBalance;
    LogcatHelper logcatHelper = new LogcatHelper();

    public SWAPTests(){
        this.configSuffix = "osmo";  // así configuras el sufijo antes de @BeforeClass
    }

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        initializeAppTest(this.getClass().getSimpleName(), "Android", "osmo");
    }
    @BeforeMethod
    public void initializePageObjects() throws IOException, GeneralSecurityException, InterruptedException {
        driver = (AndroidDriver) AppTestCase.getActionDriver().getAppiumDriver();
        homePage= new HomePage(driver);
        swapSteps = new SWAPSteps(driver);
        transferirPageSteps = new TransferirPageSteps(driver);
        osmoAPISteps = new OsmoAPISteps();
        // 👉 Login solo una vez
        LoginSteps loginPageSteps = new LoginSteps(driver);
        clearCache();
        driver.activateApp(appBundleId);
        loginPageSteps.performLoginWithEmail("alara@singularagency.co");
    }

    @Test
    public void TC001_performBTCtoQTZ() throws GeneralSecurityException, IOException, InterruptedException {
        initialBalance = osmoAPISteps.getWallets().get("Bitcoin");
        common.log("Initial Balance for Bitcoin:" + initialBalance);
        homePage.wait.until(ExpectedConditions.visibilityOf(homePage.getBtnSWAP()));
        homePage.getBtnSWAP().click();
        swapSteps.selectCoinsToSwap("Bitcoin","Quetzales");
        String minimalAmount = swapSteps.getMinimumAmmount();
        swapSteps.performSWAP(minimalAmount);
        BigDecimal actualBalance = osmoAPISteps.getWallets().get("Bitcoin");
        BigDecimal minAmount = new BigDecimal(minimalAmount);
        Assert.assertEquals(actualBalance, initialBalance.subtract(minAmount));
    }

    @Test
    public void TC002_performBTCtoCRC() throws GeneralSecurityException, IOException, InterruptedException {
        initialBalance = osmoAPISteps.getWallets().get("Bitcoin");
        common.log("Initial Balance for Bitcoin:" + initialBalance);
        homePage.wait.until(ExpectedConditions.visibilityOf(homePage.getBtnSWAP()));
        homePage.getBtnSWAP().click();
        swapSteps.selectCoinsToSwap("Bitcoin","Colones");
        String minimalAmount = swapSteps.getMinimumAmmount();
        swapSteps.performSWAP(minimalAmount);
        BigDecimal actualBalance = osmoAPISteps.getWallets().get("Bitcoin");
        BigDecimal minAmount = new BigDecimal(minimalAmount);
        Assert.assertEquals(actualBalance, initialBalance.subtract(minAmount));
    }

    @Test
    public void TC003_performBTCtoDollars() throws GeneralSecurityException, IOException, InterruptedException {
        initialBalance = osmoAPISteps.getWallets().get("Bitcoin");
        common.log("Initial Balance for Bitcoin:" + initialBalance);
        homePage.wait.until(ExpectedConditions.visibilityOf(homePage.getBtnSWAP()));
        homePage.getBtnSWAP().click();
        swapSteps.selectCoinsToSwap("Bitcoin","Dólares");
        String minimalAmount = swapSteps.getMinimumAmmount();
        swapSteps.performSWAP(minimalAmount);
        BigDecimal actualBalance = osmoAPISteps.getWallets().get("Bitcoin");
        BigDecimal minAmount = new BigDecimal(minimalAmount);
        Assert.assertEquals(actualBalance, initialBalance.subtract(minAmount));
    }

    @Test
    public void TC004_performDollarsToBTC() throws GeneralSecurityException, IOException, InterruptedException {
        initialBalance = osmoAPISteps.getWallets().get("Dólares");
        common.log("Initial Balance for Dólares:" + initialBalance);
        homePage.wait.until(ExpectedConditions.visibilityOf(homePage.getBtnSWAP()));
        homePage.getBtnSWAP().click();
        swapSteps.selectCoinsToSwap("Dólares","Bitcoin");
        String minimalAmount = swapSteps.getMinimumAmmount();
        swapSteps.performSWAP(minimalAmount);
        BigDecimal actualBalance = osmoAPISteps.getWallets().get("Dólares");
        BigDecimal minAmount = new BigDecimal(minimalAmount);
        Assert.assertEquals(actualBalance, initialBalance.subtract(minAmount));
    }

    @Test
    public void TC005_performDollarsToQTZ() throws GeneralSecurityException, IOException, InterruptedException {
        initialBalance = osmoAPISteps.getWallets().get("Dólares");
        common.log("Initial Balance for Dólares:" + initialBalance);
        homePage.wait.until(ExpectedConditions.visibilityOf(homePage.getBtnSWAP()));
        homePage.getBtnSWAP().click();
        swapSteps.selectCoinsToSwap("Dólares","Quetzales");
        String minimalAmount = swapSteps.getMinimumAmmount();
        swapSteps.performSWAP(minimalAmount);
        BigDecimal actualBalance = osmoAPISteps.getWallets().get("Dólares");
        BigDecimal minAmount = new BigDecimal(minimalAmount);
        Assert.assertEquals(actualBalance, initialBalance.subtract(minAmount));
    }

    @Test
    public void TC006_performDollarsToCRC() throws GeneralSecurityException, IOException, InterruptedException {
        initialBalance = osmoAPISteps.getWallets().get("Dólares");
        common.log("Initial Balance for Dólares:" + initialBalance);
        homePage.wait.until(ExpectedConditions.visibilityOf(homePage.getBtnSWAP()));
        homePage.getBtnSWAP().click();
        swapSteps.selectCoinsToSwap("Dólares","Colones");
        String minimalAmount = swapSteps.getMinimumAmmount();
        swapSteps.performSWAP(minimalAmount);
        BigDecimal actualBalance = osmoAPISteps.getWallets().get("Dólares");
        BigDecimal minAmount = new BigDecimal(minimalAmount);
        Assert.assertEquals(actualBalance, initialBalance.subtract(minAmount));
    }

    @Test
    public void TC007_performCRCtoBTC() throws GeneralSecurityException, IOException, InterruptedException {
        initialBalance = osmoAPISteps.getWallets().get("Colones");
        common.log("Initial Balance for Colones:" + initialBalance);
        homePage.wait.until(ExpectedConditions.visibilityOf(homePage.getBtnSWAP()));
        homePage.getBtnSWAP().click();
        swapSteps.selectCoinsToSwap("Colones","Bitcoin");
        String minimalAmount = swapSteps.getMinimumAmmount();
        swapSteps.performSWAP(minimalAmount);
        BigDecimal actualBalance = osmoAPISteps.getWallets().get("Colones");
        BigDecimal minAmount = new BigDecimal(minimalAmount);
        Assert.assertEquals(actualBalance, initialBalance.subtract(minAmount));
    }

    @Test
    public void TC008_performCRCtoDollars() throws GeneralSecurityException, IOException, InterruptedException {
        initialBalance = osmoAPISteps.getWallets().get("Colones");
        common.log("Initial Balance for Colones:" + initialBalance);
        homePage.wait.until(ExpectedConditions.visibilityOf(homePage.getBtnSWAP()));
        homePage.getBtnSWAP().click();
        swapSteps.selectCoinsToSwap("Colones","Dólares");
        String minimalAmount = swapSteps.getMinimumAmmount();
        swapSteps.performSWAP(minimalAmount);
        BigDecimal actualBalance = osmoAPISteps.getWallets().get("Colones");
        BigDecimal minAmount = new BigDecimal(minimalAmount);
        Assert.assertEquals(actualBalance, initialBalance.subtract(minAmount));
    }

    @Test
    public void TC009_performCRCtoQTZ() throws GeneralSecurityException, IOException, InterruptedException {
        initialBalance = osmoAPISteps.getWallets().get("Colones");
        common.log("Initial Balance for Colones:" + initialBalance);
        homePage.wait.until(ExpectedConditions.visibilityOf(homePage.getBtnSWAP()));
        homePage.getBtnSWAP().click();
        swapSteps.selectCoinsToSwap("Colones", "Quetzales");
        String minimalAmount = swapSteps.getMinimumAmmount();
        swapSteps.performSWAP(minimalAmount);
        BigDecimal actualBalance = osmoAPISteps.getWallets().get("Colones");
        BigDecimal minAmount = new BigDecimal(minimalAmount);
        Assert.assertEquals(actualBalance, initialBalance.subtract(minAmount));
    }

    @Test
    public void TC010_SendLightning(){
        homePage.getBtnTransfer().click();
        transferirPageSteps.sentBTCToLightning(Constants.OWN_LIGHTNING, "1000","BTC");
    }

    @AfterMethod
    public void closeApp()  {
        driver.terminateApp(appBundleId);
    }


    @Override
    protected void cleanPageObjects() {

    }
}