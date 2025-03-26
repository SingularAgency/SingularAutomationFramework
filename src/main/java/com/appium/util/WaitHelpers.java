package com.appium.util;

import com.appium.setup.AppTestCase;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.BooleanSupplier;

public class WaitHelpers {

    public static boolean waitForConditionMet(BooleanSupplier supplier){
        try{
            FluentWait<AppiumDriver> fluentWait = new FluentWait<>(AppTestCase.getActionDriver().getAppiumDriver()).withTimeout(Duration.ofSeconds(5))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(TimeoutException.class)
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(InvocationTargetException.class)
                    .ignoring(NoSuchElementException.class);
            fluentWait.until((x)-> supplier.getAsBoolean());
            return true;
        }catch(TimeoutException e){
            return false;
        }
    }

    public static boolean isListEmpty(List<WebElement> elements){
        return waitForConditionMet(()-> elements !=null && !elements.isEmpty());
    }

    public static void waitForElementPresent(WebElement element){
        waitForConditionMet(element::isDisplayed);
    }

}
