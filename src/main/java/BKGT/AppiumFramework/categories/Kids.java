package BKGT.AppiumFramework.categories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Kids {
	
	AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'127')]")
    private WebElement imgDerretidoNinos;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'134')]")
    private WebElement imgWichConHashbrownNinos;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'135')]")
    private WebElement imgPanquequesNinos;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'148')]")
    private WebElement imgBkNuggetsNinos;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'152')]")
    private WebElement imgKingDeJamonYQueso;
    
    public Kids(AndroidDriver driver) {
        this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    
    public void clickImgDerretidoNinos() {
        imgDerretidoNinos.click();
    }

    public void clickImgWichConHashbrownNinos() {
        imgWichConHashbrownNinos.click();
    }

    public void clickImgPanquequesNinos() {
        imgPanquequesNinos.click();
    }

    public void clickImgBkNuggetsNinos() {
        imgBkNuggetsNinos.click();
    }

    public void clickImgKingDeJamonYQueso() {
        imgKingDeJamonYQueso.click();
    }

}
