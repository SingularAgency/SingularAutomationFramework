package com.osmo.pages.steps;

import com.osmo.pages.InviertePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InviertePageSteps extends InviertePage {

    public InviertePageSteps(AppiumDriver driver) {
        super(driver);
    }

    public String getBictoinPrice(){
        getBtnInvierte().click();
        wait.until(ExpectedConditions.visibilityOf(getBtnExpandir()));
        getBtnExpandir().click();
        return getLblPrecioBitcoin().getAttribute("content-desc");
    }

    public boolean attemptToBuyWithoutKYC(){
        getBtnVender().click();
        wait.until(ExpectedConditions.visibilityOf(getModalVerificacion()));
        return getModalVerificacion().isDisplayed();
    }
}