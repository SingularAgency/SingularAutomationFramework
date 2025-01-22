package com.gb.pages;

import com.bkgt.pages.BasePage;
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

    @AndroidFindBy(xpath="//*[contains(@content-desc,'Carousel')]")
    private WebElement btnCarousel;

}
