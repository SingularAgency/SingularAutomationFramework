package BKGT.AppiumFramework.categories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Others {
	AndroidDriver driver;

	
    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'181')]")
    private WebElement imgKingDePescado;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'214')]")
    private WebElement imgAvenaConAgua;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'220')]")
    private WebElement imgAvenaConLeche;
    
    public Others(AndroidDriver driver) {
        this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    
    public void clickImgKingDePescado() {
        imgKingDePescado.click();
    }

    public void clickImgAvenaConAgua() {
        imgAvenaConAgua.click();
    }

    public void clickImgAvenaConLeche() {
        imgAvenaConLeche.click();
    }



}
