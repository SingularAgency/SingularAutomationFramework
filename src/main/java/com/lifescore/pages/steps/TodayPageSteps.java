package com.lifescore.pages.steps;

import com.lifescore.pages.TodayPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.appium.java_client.AppiumBy;


public class TodayPageSteps extends TodayPage {
    public TodayPageSteps(AppiumDriver driver) {
        super(driver);
    }

    public void checkCheckinBtn(){
        WebElement btnCheckin = getElemenByContent(getBtnCheckInLocator());
        waitForVisibilityOfElement(btnCheckin);
        Assert.assertTrue(btnCheckin.isDisplayed());
    }

    public void scrollToTasks(){
        for(int i= 1; i<=4;i++){
            WebElement element =   driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().descriptionContains(\"Hi!\")" +
                            ".childSelector(new UiSelector().className(\"android.view.View\").index("+i+")))"
            ));
            Assert.assertTrue(element.isDisplayed());
        }

    }

    public void checkMyTasks(){
        WebElement btnSetup = getElemenByContent(getBtnSetupLocator());
        waitForVisibilityOfElement(btnSetup);
        Assert.assertTrue(btnSetup.isDisplayed());
        WebElement btnQuiz = getElemenByContent(getBtnQuizLocator());
        waitForVisibilityOfElement(btnQuiz);
        Assert.assertTrue(btnQuiz.isDisplayed());

    }
}
