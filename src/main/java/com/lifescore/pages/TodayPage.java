package com.lifescore.pages;

import com.appium.setup.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TodayPage extends BasePage {

    @AndroidFindBy(xpath = "(//android.view.View)")
    private List<WebElement> dailyCheckinList;
    public TodayPage(AppiumDriver driver) {
        super(driver);
    }

    //public void complete
}
