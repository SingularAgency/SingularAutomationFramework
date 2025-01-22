package com.gb.pages.steps;

import com.gb.pages.CarouselPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CarouselSteps extends CarouselPage {
    public CarouselSteps(AppiumDriver driver) {
        super(driver);
    }

    public void getFirstResult() {
        wait.until(ExpectedConditions.visibilityOf(getBtnSearch()));
        getBtnSearch().click();
        wait.until(ExpectedConditions.visibilityOf(getTxtSearchBox()));
        wait.until(ExpectedConditions.visibilityOfAllElements(getImageResults()));
        getImageResults().get(1).click();


    }


}
