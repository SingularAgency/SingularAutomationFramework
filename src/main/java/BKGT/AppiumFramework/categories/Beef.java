package BKGT.AppiumFramework.categories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Beef {
	
		AndroidDriver driver;

	   @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'245')]")
	    private WebElement imgCaliforniaWhopper;

	    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'11')]")
	    private WebElement imgQuesoburguesaDoble;

	    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'7')]")
	    private WebElement imgWhopperJrTejano;

	    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'3')]")
	    private WebElement imgWhopperDoble;

	    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'159')]")
	    private WebElement imgMegaDobleQuesoYTocino;

	    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'208')]")
	    private WebElement imgBaconKing;

	    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'215')]")
	    private WebElement imgMegaBkStackerRodeoTriple;

	    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'164')]")
	    private WebElement imgMegaBkStacker;

	    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'4')]")
	    private WebElement imgWhopperDobleConQueso;

	    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'169')]")
	    private WebElement imgMegaBigKing;

	    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'196')]")
	    private WebElement imgMegaBkStackerRodeo;

	    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'201')]")
	    private WebElement imgMegaBkStackerAtomica2;

	    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'57')]")
	    private WebElement imgBkStackerTriple;

	    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'1')]")
	    private WebElement imgWhopper;

	    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'9')]")
	    private WebElement imgHamburguesa;

	    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'6')]")
	    private WebElement imgWhopperJrConQueso;

	    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'2')]")
	    private WebElement imgWhopperConQueso;

	    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'8')]")
	    private WebElement imgWhopperTejano;

	    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'70')]")
	    private WebElement imgBkStackerCuadruple;

	    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'15')]")
	    private WebElement imgBkTorito;

	    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'12')]")
	    private WebElement imgBigKing;

	    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'5')]")
	    private WebElement imgWhopperJr;

	    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'10')]")
	    private WebElement imgQuesoburguesa;

	    public Beef(AndroidDriver driver) {
	        this.driver = driver;
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
			
	    }

	    
	    public void clickImgCaliforniaWhopper() {
	        imgCaliforniaWhopper.click();
	    }

	    public void clickImgQuesoburguesaDoble() {
	        imgQuesoburguesaDoble.click();
	    }

	    public void clickImgWhopperJrTejano() {
	        imgWhopperJrTejano.click();
	    }

	    public void clickImgWhopperDoble() {
	        imgWhopperDoble.click();
	    }

	    public void clickImgMegaDobleQuesoYTocino() {
	        imgMegaDobleQuesoYTocino.click();
	    }

	    public void clickImgBaconKing() {
	        imgBaconKing.click();
	    }

	    public void clickImgMegaBkStackerRodeoTriple() {
	        imgMegaBkStackerRodeoTriple.click();
	    }

	    public void clickImgMegaBkStacker() {
	        imgMegaBkStacker.click();
	    }

	    public void clickImgWhopperDobleConQueso() {
	        imgWhopperDobleConQueso.click();
	    }

	    public void clickImgMegaBigKing() {
	        imgMegaBigKing.click();
	    }

	    public void clickImgMegaBkStackerRodeo() {
	        imgMegaBkStackerRodeo.click();
	    }

	    public void clickImgMegaBkStackerAtomica2() {
	        imgMegaBkStackerAtomica2.click();
	    }

	    public void clickImgBkStackerTriple() {
	        imgBkStackerTriple.click();
	    }

	    public void clickImgWhopper() {
	        imgWhopper.click();
	    }

	    public void clickImgHamburguesa() {
	        imgHamburguesa.click();
	    }

	    public void clickImgWhopperJrConQueso() {
	        imgWhopperJrConQueso.click();
	    }

	    public void clickImgWhopperConQueso() {
	        imgWhopperConQueso.click();
	    }

	    public void clickImgWhopperTejano() {
	        imgWhopperTejano.click();
	    }

	    public void clickImgBkStackerCuadruple() {
	        imgBkStackerCuadruple.click();
	    }

	    public void clickImgBkTorito() {
	        imgBkTorito.click();
	    }

	    public void clickImgBigKing() {
	        imgBigKing.click();
	    }

	    public void clickImgWhopperJr() {
	        imgWhopperJr.click();
	    }

	    public void clickImgQuesoburguesa() {
	        imgQuesoburguesa.click();
	    }
	    

}
