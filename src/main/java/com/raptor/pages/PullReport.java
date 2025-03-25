package com.raptor.pages;

import com.appium.setup.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class PullReport extends BasePage {

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"General Details\")]")
    private WebElement btnGeneralDetails;

    public PullReport(AppiumDriver driver) {
        super(driver);
    }
}
