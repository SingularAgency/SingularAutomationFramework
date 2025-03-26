package com.raptor.pages;

import com.appium.setup.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

import java.util.List;
@Getter
public class Reports extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Create\"]")
    private WebElement btnCreate;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Pull Report\")]")
    private List<WebElement> reportsList;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Pull Report\")]//android.widget.Button")
    private List<WebElement> deleteReportButtonList;

    public Reports(AppiumDriver driver) {
        super(driver);
    }



}
