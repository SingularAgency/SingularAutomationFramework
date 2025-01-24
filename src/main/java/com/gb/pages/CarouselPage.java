package com.gb.pages;

import com.appium.setup.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

import java.util.List;
@Getter
public class CarouselPage extends BasePage {
    public CarouselPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]")
    private WebElement btnSearch;

    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement txtSearchBox;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,':')]")
    private List<WebElement> imageResults;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,':')]")
    private WebElement textResult;
}
