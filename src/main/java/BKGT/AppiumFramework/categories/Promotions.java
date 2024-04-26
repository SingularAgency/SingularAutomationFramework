package BKGT.AppiumFramework.categories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import BKGT.AppiumFramework.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Promotions extends BasePage{
	public AppiumDriver driver;
	
    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'2245')]")
    private WebElement imgTodoXQ45KingDePollo;
    
    @iOSXCUITFindBy(accessibility = "Combo Reconciliación")
    @AndroidFindBy(xpath = "//*[contains(@text,'Combo Reconciliación')]")
    private WebElement imgReconciliacion;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'250')]")
    private WebElement imgTodoXQ60KingDePollo;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'2544')]")
    private WebElement imgComboThanksgiving;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'1912')]")
    private WebElement imgFiestaWhopper;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'2230')]")
    private WebElement imgTodoXQ45WhopperJrConPapasYSodaMediana;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'119')]")
    private WebElement imgDosQuesoburguesaYDosWhopper;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'120')]")
    private WebElement imgDosWhopperYDosWhopperJr;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'121')]")
    private WebElement imgCuatroQuesoburguesas;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'118')]")
    private WebElement imgTresWhopper;
    
    
    public Promotions(AppiumDriver driver) {
    	super(driver);
        this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    
    public void clickImgTodoXQ45KingDePollo() {
        imgTodoXQ45KingDePollo.click();
    }

    public void clickImgTodoXQ60KingDePollo() {
        imgTodoXQ60KingDePollo.click();
    }

    public void clickImgComboThanksgiving() {
        imgComboThanksgiving.click();
    }

    public void clickImgFiestaWhopper() {
        imgFiestaWhopper.click();
    }

    public void clickImgTodoXQ45WhopperJrConPapasYSodaMediana() {
        imgTodoXQ45WhopperJrConPapasYSodaMediana.click();
    }

    public void clickImgDosQuesoburguesaYDosWhopper() {
        imgDosQuesoburguesaYDosWhopper.click();
    }

    public void clickImgDosWhopperYDosWhopperJr() {
        imgDosWhopperYDosWhopperJr.click();
    }

    public void clickImgCuatroQuesoburguesas() {
        imgCuatroQuesoburguesas.click();
    }

    public void clickImgTresWhopper() {
        imgTresWhopper.click();
    }
    
    public void clickComboReconciliacion() {
    	waitForElementVisible(imgReconciliacion);
        imgReconciliacion.click();
    }
}
