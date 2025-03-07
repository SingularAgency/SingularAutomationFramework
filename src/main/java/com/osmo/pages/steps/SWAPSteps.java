package com.osmo.pages.steps;

import com.appium.setup.BasePage;
import com.osmo.pages.SwapPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SWAPSteps extends SwapPage {
    public SWAPSteps(AppiumDriver driver) {
        super(driver);
    }

    private void performSWAP(String firstOption, String secondOption){
        WebElement firstElement = driver.findElement(By.xpath(getButtonByCurrency(firstOption)));
        fluentWait.until(ExpectedConditions.elementToBeClickable(firstElement));
        WebElement secondElement = driver.findElement(By.xpath(getButtonByCurrency(secondOption)));
        fluentWait.until(ExpectedConditions.elementToBeClickable(secondElement));
        String minimumAmmount = getMinimumAmmount();
        getTextFields().get(0).sendKeys(minimumAmmount);

    }

}
