package com.raptor.pages;

import com.appium.setup.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

@Getter
public class PullReport extends BasePage {

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"General Details\")]")
    private WebElement btnGeneralDetails;

    public PullReport(AppiumDriver driver) {
        super(driver);
    }
}
