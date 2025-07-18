package com.lifescore.pages;

import com.appium.setup.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TodayPage extends BasePage {

    @AndroidFindBy(xpath ="//*[@content-desc='Start daily Check In']" )
    private WebElement btnCheckin;

    @AndroidFindBy(accessibility = "Complete My Account Setup")
    private WebElement btnSetup;

    @AndroidFindBy(accessibility = "Start Quiz")
    private WebElement btnQuiz;

    @AndroidFindBy(accessibility = "Learn more")
    private WebElement btnLearnMore;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Your handy guide to portion sizes')]")
    private WebElement resourceCard;

    @AndroidFindBy(xpath = "(//android.view.View[contains(@content-desc,'Hi!')]//android.view.View)[position() <= 4]\n")
    private List<WebElement> tasksLists;

    public TodayPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getBtnCheckin() {
        return btnCheckin;
    }

    public WebElement getBtnLearnMore() {
        return btnLearnMore;
    }

    public WebElement getBtnQuiz() {
        return btnQuiz;
    }

    public WebElement getBtnSetup() {
        return btnSetup;
    }

    public WebElement getResourceCard() {
        return resourceCard;
    }

    public List<WebElement> getTasksLists() {
        return tasksLists;
    }
}
