package com.osmo.pages.steps;

import com.appium.setup.BasePage;
import com.osmo.pages.SwapPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class SWAPSteps extends SwapPage {
    public SWAPSteps(AppiumDriver driver) {
        super(driver);
    }

    public void performSWAP(String firstOption, String secondOption){
        fluentWait.until(ExpectedConditions.visibilityOf(getLblHeader()));
        getLblHeader().click();
        Assert.assertFalse(getSwapButtons().isEmpty());
        clickOnBounds(getSwapButtons().get(0));
        WebElement firstElement = driver.findElement(By.xpath(getButtonByCurrency(firstOption)));
        fluentWait.until(ExpectedConditions.elementToBeClickable(firstElement));
        firstElement.click();
        clickOnBounds(getSwapButtons().get(1));
        WebElement secondElement = driver.findElement(By.xpath(getButtonByCurrency(secondOption)));
        fluentWait.until(ExpectedConditions.elementToBeClickable(secondElement));
        secondElement.click();
        String minimumAmmount = getMinimumAmmount();
        clickOnBounds(getTextFields().get(0));
        getTextFields().get(0).sendKeys(minimumAmmount);
        fluentWait.until(ExpectedConditions.elementToBeClickable(getBtnConvert()));
        getBtnConvert().click();
        fluentWait.until(ExpectedConditions.elementToBeClickable(getBtnConvert()));
        getBtnConvert().click();
    }

}
