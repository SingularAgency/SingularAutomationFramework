package com.appium.setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public WebDriverWait wait;
    public AppiumDriver driver;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc,\"Reports\")]")
    private WebElement btnReports;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc,\"Hub\")]")
    private WebElement btnHub;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc,\"Calendar\")]")
    private WebElement btnCalendar;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc,\"Requests\")]")
    private WebElement btnRequests;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc,\"Home\")]")
    private WebElement btnHome;

    public BasePage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.driver= driver;
    }

    public void waitForElementToBePresent(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
