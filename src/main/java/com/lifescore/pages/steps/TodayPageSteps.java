package com.lifescore.pages.steps;

import com.lifescore.pages.TodayPage;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;

public class TodayPageSteps extends TodayPage {
    public TodayPageSteps(AppiumDriver driver) {
        super(driver);
    }

    public void checkCheckinBtn(){
        Assert.assertTrue(getBtnCheckin().isDisplayed());
    }

    public void scrollToTasks() {
    }

    public void checkResourses(){
        scrollUntilVisible(this::getBtnLearnMore, 5);
        waitForVisibilityOfElement(getBtnLearnMore());
        Assert.assertTrue(getResourceCard().isDisplayed());
    }

    public void checkMyTasks(){
        waitForVisibilityOfElement(getBtnSetup());
        Assert.assertTrue(getBtnSetup().isDisplayed());
        scrollUntilVisible(this::getBtnQuiz, 2);
        waitForVisibilityOfElement(getBtnQuiz());
        Assert.assertTrue(getBtnQuiz().isDisplayed());
    }
}
