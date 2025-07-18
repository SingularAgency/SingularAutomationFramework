package com.lifescore.pages;

import com.appium.setup.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

@Getter
public class CommonPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc,'Today')]")
    private WebElement btnToday;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc,'My Data')]")
    private WebElement btnMyData;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc,'Me')]")
    private WebElement btnMe;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc,'Hub')]")
    private WebElement btnHub;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc,'Lifeline')]")
    private WebElement btnLifeLine;


    public CommonPage(AppiumDriver driver) {
        super(driver);
    }
}
