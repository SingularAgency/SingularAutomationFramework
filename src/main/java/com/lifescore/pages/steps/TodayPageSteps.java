package com.lifescore.pages.steps;

import com.lifescore.pages.TodayPage;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;

public class TodayPageSteps extends TodayPage {
    public TodayPageSteps(AppiumDriver driver) {
        super(driver);
    }

    public void checkCheckinBtn(){
        waitForVisibilityOfElement(getBtnCheckIn());
        Assert.assertTrue(getBtnCheckIn().isDisplayed());
    }

    public void checkMyTasks(){
        waitForVisibilityOfElement(getBtnSetup());
        Assert.assertTrue(getBtnSetup().isDisplayed());
        waitForVisibilityOfElement(getBtnSetup());
        Assert.assertTrue(getBtnQuiz().isDisplayed());

    }
}
