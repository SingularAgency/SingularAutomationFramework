package com.lifescore.pages.steps;

import com.appium.setup.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class NutritionQuestions extends BasePage {
    public NutritionQuestions(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "Nutrition")
    public WebElement nutritionLabel;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Do you take any prescription drugs?')]")
    public WebElement questionText;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'None')]")
    public WebElement noneOption;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Less than 5')]")
    public WebElement lessThan5Option;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, '5 to 6')]")
    public WebElement fiveToSixOption;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, '7 to 8')]")
    public WebElement sevenToEightOption;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, '9 or more')]")
    public WebElement nineOrMoreOption;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'How often do you smoke, vape and/or use smokeless tobacco?')]")
    public WebElement questionText2;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Never')]")
    public WebElement neverOption;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Almost Never')]")
    public WebElement almostNeverOption;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Sometimes')]")
    public WebElement sometimesOption;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Fairly Often')]")
    public WebElement fairlyOftenOption;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Very Often')]")
    public WebElement veryOftenOption;


}
