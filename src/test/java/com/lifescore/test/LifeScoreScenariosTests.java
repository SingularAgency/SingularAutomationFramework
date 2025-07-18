package com.lifescore.test;

import com.appium.setup.AppTestCase;

import com.lifescore.pages.CommonPage;
import com.lifescore.pages.steps.LoginPageSteps;
import com.lifescore.pages.steps.MyDataPageSteps;
import com.lifescore.pages.steps.TodayPageSteps;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LifeScoreScenariosTests extends AppTestCase {
    private LoginPageSteps loginPageSteps;
    private TodayPageSteps todayPageSteps;
    private CommonPage commonPage;
    private MyDataPageSteps myDataPageSteps;
    AndroidDriver driver;

    public LifeScoreScenariosTests() {
        this.configSuffix = "lifescore";  // así configuras el sufijo antes de @BeforeClass
    }


    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        initializeAppTest(this.getClass().getSimpleName(), "Android", "lifescore");
    }

    @BeforeMethod
    public void initializePageObjects() throws IOException {
        driver = (AndroidDriver) AppTestCase.getActionDriver().getAppiumDriver();
        loginPageSteps = new LoginPageSteps(driver);
        todayPageSteps = new TodayPageSteps(driver);
        commonPage = new CommonPage(driver);
        myDataPageSteps = new MyDataPageSteps(driver);
        clearCache();
        driver.activateApp(appBundleId);
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
    }

    @Test
    public void LS_TC06_LoginSuccessfully(){
        loginPageSteps.attemptToLogin("caserez199828@gmail.com","Test123!");

    }

    @Test()
    public void LS_TC07_CheckTodayPage() throws InterruptedException {
        LS_TC06_LoginSuccessfully();
        Thread.sleep(1000);
        todayPageSteps.checkCheckinBtn();
        todayPageSteps.checkMyTasks();
        todayPageSteps.scrollToTasks();
        todayPageSteps.checkResourses();
    }

    @Test()
    public void LS_TC08_CheckFooterOnTodayPage() throws InterruptedException {
        LS_TC06_LoginSuccessfully();
        Thread.sleep(1000);
        Assert.assertTrue(commonPage.getBtnHub().isDisplayed());
        Assert.assertTrue(commonPage.getBtnToday().isDisplayed());
        Assert.assertTrue(commonPage.getBtnLifeLine().isDisplayed());
        Assert.assertTrue(commonPage.getBtnMe().isDisplayed());
        Assert.assertTrue(commonPage.getBtnMyData().isDisplayed());
    }

    @Test()
    public void LS_TC09_ValidateIfLifeScoresMatch() throws InterruptedException {
        LS_TC06_LoginSuccessfully();
        Thread.sleep(1000);
        Assert.assertTrue(commonPage.getBtnMyData().isDisplayed());
        commonPage.getBtnMyData().click();
        Thread.sleep(500);
        myDataPageSteps.checkIfScoresMatch();
        myDataPageSteps.checkIfScoreSummatoryMatches();
    }

    @AfterMethod
    public void closeApp() throws IOException {
        driver.terminateApp(appBundleId);
    }

    @Override
    protected void cleanPageObjects() {

    }

}