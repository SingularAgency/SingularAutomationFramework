package com.gb.test;

import com.appium.setup.AppTestCase;
import com.gb.pages.HomePage;
import com.gb.pages.steps.CarouselSteps;

import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AndroidTests extends AppTestCase {
    private HomePage homePage;
    private CarouselSteps carouselSteps;
    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        initializeAppTest(this.getClass().getSimpleName(), "Android");
    }
    @BeforeMethod
    public void initializePageObjects() {
        AndroidDriver driver = (AndroidDriver) AppTestCase.getActionDriver().getAppiumDriver();
        homePage = new HomePage(driver);
        carouselSteps = new CarouselSteps(driver);
    }


    @Test
    public void VCTC001_ClickAnImage() throws InterruptedException {
        common.logScreen("HomePage is displayed");
        Assert.assertTrue(homePage.getBtnHome().isDisplayed(), "Home button not displayed.");
        homePage.getBtnHome().click();
        Assert.assertTrue(homePage.getLblHome().isDisplayed(), "Home Label is not displayed");
        homePage.getBtnCarousel().click();
        carouselSteps.getFirstResult();
    }


    @Override
    protected void cleanPageObjects() {
        // Clean up logic for page objects if necessary
    }
}
