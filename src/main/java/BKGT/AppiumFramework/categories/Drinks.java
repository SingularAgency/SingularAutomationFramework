package BKGT.AppiumFramework.categories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Drinks {
	
	AndroidDriver driver;


 	@AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'130')]")
    private WebElement imgTeFrioDurazno;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'117')]")
    private WebElement imgTeFrioLimón;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'114')]")
    private WebElement img7Up;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'113')]")
    private WebElement imgPepsi;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'243')]")
    private WebElement imgCafe12OnzConLeche;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'242')]")
    private WebElement imgCafe12Onz;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'230')]")
    private WebElement imgPepsiBlack;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'58')]")
    private WebElement imgAguaPurificada;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'244')]")
    private WebElement imgChocolateCaliente8Onz;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'60')]")
    private WebElement imgJugoDeNaranja;
    
    public Drinks(AndroidDriver driver) {
    	this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);		// TODO Auto-generated constructor stub

    }
    
    
    public void clickImgTeFrioDurazno() {
        imgTeFrioDurazno.click();
    }

    public void clickImgTeFrioLimón() {
        imgTeFrioLimón.click();
    }

    public void clickImg7Up() {
        img7Up.click();
    }

    public void clickImgPepsi() {
        imgPepsi.click();
    }

    public void clickImgCafe12OnzConLeche() {
        imgCafe12OnzConLeche.click();
    }

    public void clickImgCafe12Onz() {
        imgCafe12Onz.click();
    }

    public void clickImgPepsiBlack() {
        imgPepsiBlack.click();
    }

    public void clickImgAguaPurificada() {
        imgAguaPurificada.click();
    }

    public void clickImgChocolateCaliente8Onz() {
        imgChocolateCaliente8Onz.click();
    }

    public void clickImgJugoDeNaranja() {
        imgJugoDeNaranja.click();
    }
	
}
