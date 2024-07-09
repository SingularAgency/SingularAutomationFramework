package com.heyhorse.test;

import com.appium.setup.AppTestCase;
import com.github.javafaker.Faker;
import com.heyhorse.pages.AddHorsesPage;
import com.heyhorse.pages.HomePage;
import com.heyhorse.pages.HorsesPage;
import com.heyhorse.pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HeyHorseTests extends AppTestCase {
    private final String className = this.getClass().getSimpleName();
    Faker faker = new Faker();
    String horseName = faker.name().firstName();
    String horseLocation = faker.country().capital();
    String horseBarn = "Fake Barn";

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        initializeAppTest(className, "Android");
    }

    @Test
    public void TC01_Login(){
        AndroidDriver driver = (AndroidDriver) AppTestCase.getActionDriver().getAppiumDriver();
        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(loginPage.isPageLoaded());
        loginPage.clickSignIn();
        common.logScreen("Login form displayed");
        loginPage.enterCredentials("reese@yopmail.com","abcd1234");
        loginPage.attemptToLogin();
        common.log("Login was successfully");
    }

    @Test
    public void TC02_AddNewHorse(){
        AndroidDriver driver = (AndroidDriver) AppTestCase.getActionDriver().getAppiumDriver();
        HomePage homePage = new HomePage(driver);
        homePage.clickHorses();

        HorsesPage horsesPage = new HorsesPage(driver);
        horsesPage.addNewHorse();

        AddHorsesPage addHorsesPage = new AddHorsesPage(driver);
        addHorsesPage.enterName(horseName);
        addHorsesPage.enterBarn(horseBarn);
        addHorsesPage.enterLocation(horseLocation);
        addHorsesPage.setBirthdate();
        addHorsesPage.scrollDown();
        addHorsesPage.scrollDown();
        addHorsesPage.selectBreed();
        addHorsesPage.selectGender();
        addHorsesPage.clickAddHorse();
        addHorsesPage.clickHorseProfile();
        common.log("Horse was created successfully");
    }

    @Test
    public void TC03_Logout(){
        AndroidDriver driver = (AndroidDriver) AppTestCase.getActionDriver().getAppiumDriver();
        HomePage homePage = new HomePage(driver);
        homePage.clickMenu();
        homePage.clickSettings();
        common.logScreen("Attempt to click Logout");
        homePage.clickLogout();
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageLoaded());

    }


    @Override
    protected void cleanPageObjects() {

    }
}
