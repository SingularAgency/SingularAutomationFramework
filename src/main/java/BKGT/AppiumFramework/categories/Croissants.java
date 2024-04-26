package BKGT.AppiumFramework.categories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Croissants {

	AndroidDriver driver;
    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'26')]")
    private WebElement imgCroissantWichConHuevoYQueso;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'27')]")
    private WebElement imgCroissantWichConHuevoQuesoYJamon;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'28')]")
    private WebElement imgCroissantWichConHuevoQuesoYSalchicha;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'29')]")
    private WebElement imgCroissantWichConHuevoQuesoYTocino;
    
    public Croissants(AndroidDriver driver) {
	
    	this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);		// TODO Auto-generated constructor stub

    }
    
    public void clickImgCroissantWichConHuevoYQueso() {
        imgCroissantWichConHuevoYQueso.click();
    }

    public void clickImgCroissantWichConHuevoQuesoYJamon() {
        imgCroissantWichConHuevoQuesoYJamon.click();
    }

    public void clickImgCroissantWichConHuevoQuesoYSalchicha() {
        imgCroissantWichConHuevoQuesoYSalchicha.click();
    }

    public void clickImgCroissantWichConHuevoQuesoYTocino() {
        imgCroissantWichConHuevoQuesoYTocino.click();
    }
	
}
