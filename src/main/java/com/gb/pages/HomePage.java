package com.gb.pages;

import com.appium.setup.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class HomePage extends BasePage {
    public HomePage(AppiumDriver driver){
        super(driver);
    }

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'Home')]")
    private WebElement btnHome;

    @AndroidFindBy(accessibility = "Home")
    private WebElement lblHome;

    @AndroidFindBy(accessibility="Reader\n" +
            "Carousel\n" +
            "Tab 1 of 4")
    private WebElement btnCarousel;

}
