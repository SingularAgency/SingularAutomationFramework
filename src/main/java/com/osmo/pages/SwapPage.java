package com.osmo.pages;

import com.appium.setup.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.regex.Pattern;

@Getter
public class SwapPage extends BasePage {


    @AndroidFindBy(xpath = "//android.widget.ImageView")
    private WebElement btnReference;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Convertir\"]")
    private WebElement btnConvert;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Minimal conversion\")]")
    private WebElement lblMinimumAmmount;
    @AndroidFindBy(className = "android.widget.EditText")
    private List<WebElement> textFields;

    public SwapPage(AppiumDriver driver) {
        super(driver);
    }

    public String getButtonByCurrency(String currency){
        return "//android.widget.ImageView[contains(@content-desc,'"+currency+"')]";
    }

    public String getMinimumAmmount(){
        String minimum= lblMinimumAmmount.getText();
        return minimum.chars()
                .filter(Character::isDigit)  // Keep only digits
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

    }

}
