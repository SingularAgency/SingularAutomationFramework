package BKGT.AppiumFramework.categories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Salads {
	
	AndroidDriver driver;

 	@AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'50')]")
    private WebElement imgBkShakerDeJamon;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'122')]")
    private WebElement imgEnsaladaPolloALaParrilla;
    
    public Salads(AndroidDriver driver) {
        this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    
    public void clickImgBkShakerDeJamon() {
        imgBkShakerDeJamon.click();
    }

    public void clickImgEnsaladaPolloALaParrilla() {
        imgEnsaladaPolloALaParrilla.click();
    }
}
