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

    @AndroidFindBy(accessibility = "CONVERSIÓN ÚNICA")
    private WebElement lblHeader;
    @AndroidFindBy(xpath = "//android.widget.ImageView")
    private WebElement btnReference;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Convertir\"]")
    private WebElement btnConvert;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Conversión mínima\")]")
    private WebElement lblMinimumAmmount;
    @AndroidFindBy(xpath = "//android.widget.EditText")
    private List<WebElement> textFields;
    @AndroidFindBy(xpath = "//android.widget.ImageView")
    private List<WebElement> swapButtons;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"CONFIRMAR CONVERSIÓN\"]")
    private WebElement lblConfirmSwap;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Comisión\"]/following-sibling::android.view.View)[1]")
    private WebElement lblComision;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"RECIBIRÁS\"]/following-sibling::android.view.View)[1]")
    private WebElement lblTotalARecibir;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"CONVERSIÓN REALIZADA EXITOSAMENTE\"]")
    private  WebElement modalConfirmation;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Ver comprobante\"]")
    private WebElement btnComprobante;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"TOTAL\"]/following-sibling::android.view.View)[1]")
    private WebElement lblTotal;
    @AndroidFindBy(xpath = "//android.widget.ImageView")
    private List<WebElement> currencyLists;

    public SwapPage(AppiumDriver driver) {
        super(driver);
    }

    public String getButtonByCurrency(String currency){
        return "//android.widget.ImageView[contains(@content-desc,'"+currency+"')]";
    }

    public String getMinimumAmmount(){
        String minimum= lblMinimumAmmount.getDomAttribute("content-desc");
        return minimum.chars()
                .filter(Character::isDigit)  // Keep only digits
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

    }

}
