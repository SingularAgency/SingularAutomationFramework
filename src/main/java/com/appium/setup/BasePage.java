package com.appium.setup;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

public class BasePage {

    public WebDriverWait wait;
    public AppiumDriver driver;
    public FluentWait<WebDriver> fluentWait;
    public BasePage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.driver= driver;
        this.fluentWait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofMillis(300)).ignoring(StaleElementReferenceException.class);
    }

    public void tapElement(WebElement element) {
        // Get element coordinates
        int centerX = element.getLocation().getX() + (element.getSize().getWidth() / 2);
        int centerY = element.getLocation().getY() + (element.getSize().getHeight() / 2);

        // Create PointerInput for touch actions
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tapSequence = new Sequence(finger, 1);

        // Move to the element and tap
        tapSequence.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), centerX, centerY));
        tapSequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tapSequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Perform the action
        driver.perform(Collections.singletonList(tapSequence));
    }

    public void clickOnBounds(WebElement element){
        String bounds = element.getAttribute("bounds"); // Example: "[100,200][300,400]"

        // Extract coordinates
        int x1 = Integer.parseInt(bounds.split("[\\[\\],]")[1]); // Left X
        int y1 = Integer.parseInt(bounds.split("[\\[\\],]")[2]); // Top Y
        int y2 = Integer.parseInt(bounds.split("[\\[\\],]")[5]); // Bottom Y

        // Click 10% inside from the left edge (to avoid touching the exact border)
        int clickX = x1 + 10; // Adjust this value as needed
        int clickY = (y1 + y2) / 2; // Keep Y at the center

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tapSequence = new Sequence(finger, 1);

        // Move to the element and tap
        tapSequence.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), clickX, clickY));
        tapSequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tapSequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Perform the action
        driver.perform(Collections.singletonList(tapSequence));
    }




}
