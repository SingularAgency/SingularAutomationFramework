package com.lifescore.pages;

import com.appium.setup.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

import java.util.List;

@Getter
public class TodayPage extends BasePage {

    private String btnCheckInLocator = "Start daily Check In";

    private String btnSetupLocator="Complete My Account Setup";

    private String btnQuizLocator="Start Quiz";

    private String btnLearMoreLocator ="Learn more";

    @AndroidFindBy(accessibility = "Your handy guide to portion sizes\\nYour handy guide to portion sizes")
    @AndroidFindBy(accessibility = "Mental fitness affects injury recovery\\nMental fitness affects injury recovery")
    @AndroidFindBy(accessibility = "Plan your workouts with block periodization\\nPlan your workouts with block periodization")
    private WebElement resourceCard;

    @AndroidFindBy(xpath = "(//android.view.View[contains(@content-desc,'Hi!')]//android.view.View)[position() <= 4]\n")
    private List<WebElement> tasksLists;

    public TodayPage(AppiumDriver driver) {
        super(driver);
    }
}
