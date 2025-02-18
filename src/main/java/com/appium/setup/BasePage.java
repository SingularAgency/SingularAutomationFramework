package com.appium.setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    public WebDriverWait wait;
    public AppiumDriver driver;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Today\n" +
            "Tab 1 of 4\"]")
    private WebElement btnToday;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"My Data\n" +
            "Tab 2 of 4\"]")
    private WebElement btnMyData;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Me\n" +
            "Tab 3 of 4\"]")
    private WebElement btnMe;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Hub\n" +
            "Tab 4 of 4\"]")
    private WebElement btnHub;

    public BasePage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.driver= driver;

    }

    public void waitForVisibilityOfElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForVisibilityOfAllElements(List<WebElement> elements)
    {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }



}
