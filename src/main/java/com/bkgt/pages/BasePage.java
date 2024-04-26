package com.bkgt.pages;

import java.time.Duration;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasePage {
	
	
	
	public WebDriverWait wait;
	protected AppiumDriver driver;
	public BasePage(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.driver= driver;

	}
	
	public void addCounters(String []array, Map<String, WebElement> hashMap, int count) throws InterruptedException {
		
		for(int i=0;i<count;i++) {
			hashMap.get(getRandomElement(array)).click();;
		}
		
	}
	
	public String getRandomElement(String [] locators) {
	    Random random = new Random();
        int randomIndex = random.nextInt(locators.length);

        // Choose the string at the random index
        String randomString = locators[randomIndex];
        return randomString;
	}
	
	public void addSingles(String []array, Map<String, WebElement> hashMap) {
		hashMap.get(getRandomElement(array)).click();;

	}
}
