package BKGT.AppiumFramework.categories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Chicken{
	AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'17')]")
    private WebElement imgKingDePolloFrances;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'16')]")
    private WebElement imgKingDePolloAmericano;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'145')]")
    private WebElement imgBkNuggets4Piezas;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'187')]")
    private WebElement imgTenderGrill;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'14')]")
    private WebElement imgKingDePollo;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'146')]")
    private WebElement imgBkNuggets10Piezas;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'186')]")
    private WebElement imgCrispyChicken;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'18')]")
    private WebElement imgKingDePolloItaliano;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'147')]")
    private WebElement imgBkNuggets35Piezas;


    public Chicken(AndroidDriver driver) {
        this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    
    public void añadirKingPolloFrances() {
    	imgKingDePolloFrances.click();
    	
    }
	
}
