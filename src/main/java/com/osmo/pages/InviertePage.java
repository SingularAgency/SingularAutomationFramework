package com.osmo.pages;

import com.appium.setup.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

@Getter
public class InviertePage extends BasePage {
    public InviertePage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'Invierte')]")
    public WebElement btnInvierte;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Precio')]//android.widget.ImageView[2]")
    public WebElement btnExpandir;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Q ')][1]")
    public WebElement lblPrecioBitcoin;

    @AndroidFindBy(accessibility = "Vender")
    public WebElement btnVender;

    @AndroidFindBy(accessibility = "Para poder Vender, primero debes verificar tu usuario")
    public WebElement modalVerificacion;


}
