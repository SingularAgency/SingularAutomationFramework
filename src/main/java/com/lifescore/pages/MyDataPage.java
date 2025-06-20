package com.lifescore.pages;

import com.appium.setup.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class MyDataPage extends BasePage {

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Your LifeScore\"]/following-sibling::android.view.View[1]")
    private List<WebElement> lifeScores;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Your LifeScore\"][2]/following-sibling::android.view.View)[position() >= 8 and position() <= 13]")
    private List<WebElement> scores;

    public MyDataPage(AppiumDriver driver) {
        super(driver);
    }

    public List<String> getVisibleScores() {
        return getLifeScores().stream()
                .filter(WebElement::isDisplayed)
                .map(el -> el.getAttribute("content-desc"))
                .collect(Collectors.toList());
    }

    public List<String> getScoresPerCategory() {
        return getScores().stream()
                .filter(WebElement::isDisplayed)
                .map(el -> el.getAttribute("content-desc"))
                .collect(Collectors.toList());
    }

}
