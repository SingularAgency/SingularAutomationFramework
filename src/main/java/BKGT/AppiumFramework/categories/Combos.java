package BKGT.AppiumFramework.categories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Combos {
	AndroidDriver driver;

	
	
    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'2537')]")
    private WebElement imgCafePie;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'216')]")
    private WebElement imgMegaBkStackerRodeoTriple;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'197')]")
    private WebElement imgComboMegaBkStackerRodeo;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'78')]")
    private WebElement imgComboWhopperJr;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'25')]")
    private WebElement imgComboBigKing;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'165')]")
    private WebElement imgComboMegaBkStacker;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'160')]")
    private WebElement imgComboMegaDobleQuesoYTocino;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'141')]")
    private WebElement imgComboWhopperTejano;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'266')]")
    private WebElement imgComboWhopperDobleConQueso;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'246')]")
    private WebElement imgComboCaliforniaWhopper;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'182')]")
    private WebElement imgComboKingDePescado;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'202')]")
    private WebElement imgComboMegaBkStackerAtomica2;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'209')]")
    private WebElement imgComboBaconKing;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'75')]")
    private WebElement imgComboWhopper;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'137')]")
    private WebElement imgComboWhopperDoble;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'77')]")
    private WebElement imgComboKingDePollo;
	
    public Combos(AndroidDriver driver) {
    	this.driver = driver;
   		PageFactory.initElements(new AppiumFieldDecorator(driver), this);	
    }
    
    
    public void clickImgCafePie() {
        imgCafePie.click();
    }

    public void clickImgMegaBkStackerRodeoTriple() {
        imgMegaBkStackerRodeoTriple.click();
    }

    public void clickImgComboMegaBkStackerRodeo() {
        imgComboMegaBkStackerRodeo.click();
    }

    public void clickImgComboWhopperJr() {
        imgComboWhopperJr.click();
    }

    public void clickImgComboBigKing() {
        imgComboBigKing.click();
    }

    public void clickImgComboMegaBkStacker() {
        imgComboMegaBkStacker.click();
    }

    public void clickImgComboMegaDobleQuesoYTocino() {
        imgComboMegaDobleQuesoYTocino.click();
    }

    public void clickImgComboWhopperTejano() {
        imgComboWhopperTejano.click();
    }

    public void clickImgComboWhopperDobleConQueso() {
        imgComboWhopperDobleConQueso.click();
    }

    public void clickImgComboCaliforniaWhopper() {
        imgComboCaliforniaWhopper.click();
    }

    public void clickImgComboKingDePescado() {
        imgComboKingDePescado.click();
    }

    public void clickImgComboMegaBkStackerAtomica2() {
        imgComboMegaBkStackerAtomica2.click();
    }

    public void clickImgComboBaconKing() {
        imgComboBaconKing.click();
    }

    public void clickImgComboWhopper() {
        imgComboWhopper.click();
    }

    public void clickImgComboWhopperDoble() {
        imgComboWhopperDoble.click();
    }

    public void clickImgComboKingDePollo() {
        imgComboKingDePollo.click();
    }
    
	
	
	

}
