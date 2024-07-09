package com.heyhorse.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    protected WebDriverWait wait;

    public HomePage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @AndroidFindBy(accessibility = "Logout")
    protected WebElement btnLogout;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Notifications')]")
    protected WebElement btnNotifications;

    @AndroidFindBy(xpath = "(//android.view.View[contains(@content-desc,'Messages')])[2]")
    protected WebElement btnMessages;

    @AndroidFindBy(accessibility = "Home")
    protected WebElement btnHome;

    @AndroidFindBy(accessibility = "Calendar")
    protected WebElement btnCalendar;

    @AndroidFindBy(accessibility = "Menu")
    protected WebElement btnMenu;

    @AndroidFindBy(accessibility = "Horses")
    protected WebElement btnHorses;

    @AndroidFindBy(accessibility = "Profile")
    protected WebElement btnProfile;

    @AndroidFindBy(accessibility = "Barn")
    protected WebElement btnBarn;

    @AndroidFindBy(accessibility = "Trainers")
    protected WebElement btnTrainers;

    @AndroidFindBy(accessibility = "Settings")
    protected WebElement btnSettings;

    public void clickHorses() {
        wait.until(ExpectedConditions.elementToBeClickable(btnHorses));
        btnHorses.click();

    }

    public void clickMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(btnMenu));
        btnMenu.click();
    }

    public void clickSettings() {
        wait.until(ExpectedConditions.elementToBeClickable(btnSettings));
        btnSettings.click();

    }

    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(btnLogout));
        btnLogout.click();
    }

}
