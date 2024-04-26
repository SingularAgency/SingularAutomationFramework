package BKGT.AppiumFramework.categories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Extras {
	
	AndroidDriver driver;
	@AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'222')]")
    private WebElement imgCubetazoPapas;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'223')]")
    private WebElement imgCubetazoAros;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'224')]")
    private WebElement imgCubetazoPapasYAros;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'54')]")
    private WebElement imgArosDeCebollaMedianos;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'53')]")
    private WebElement imgPapasFritasGrandes;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'56')]")
    private WebElement imgCroissantwich;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'51')]")
    private WebElement imgPapasFritasMedianas;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'55')]")
    private WebElement imgArosDeCebollaGrande;
    
    Extras(AndroidDriver driver){
    	this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);		
    }
    
    public void clickImgCubetazoPapas() {
        imgCubetazoPapas.click();
    }

    public void clickImgCubetazoAros() {
        imgCubetazoAros.click();
    }

    public void clickImgCubetazoPapasYAros() {
        imgCubetazoPapasYAros.click();
    }

    public void clickImgArosDeCebollaMedianos() {
        imgArosDeCebollaMedianos.click();
    }

    public void clickImgPapasFritasGrandes() {
        imgPapasFritasGrandes.click();
    }

    public void clickImgCroissantwich() {
        imgCroissantwich.click();
    }

    public void clickImgPapasFritasMedianas() {
        imgPapasFritasMedianas.click();
    }

    public void clickImgArosDeCebollaGrande() {
        imgArosDeCebollaGrande.click();
    }

}
