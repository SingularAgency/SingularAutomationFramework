package com.heyhorse.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HorsesPage {

    public WebDriverWait wait;

     public HorsesPage(AppiumDriver driver){
             PageFactory.initElements(new AppiumFieldDecorator(driver), this);
             this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
     }

    @AndroidFindBy(accessibility="Add a new horse")
    protected WebElement btnAddNewHorse;

    @AndroidFindBy(xpath="//android.widget.EditText")
    protected WebElement txtSearch;

    public void addNewHorse(){
        wait.until(ExpectedConditions.elementToBeClickable(btnAddNewHorse));
        btnAddNewHorse.click();

    }



}
