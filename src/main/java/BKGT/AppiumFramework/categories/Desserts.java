package BKGT.AppiumFramework.categories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Desserts {
	
		AndroidDriver driver;
	
	 	@AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'180')]")
	    private WebElement imgShakeDeOreo;

	    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'175')]")
	    private WebElement imgShakeDeChocolate;

	    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'177')]")
	    private WebElement imgShakeDeChocomenta;

	    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'176')]")
	    private WebElement imgShakeDeCafe;

	    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'45')]")
	    private WebElement imgPieDeManzana;

	    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'61')]")
	    private WebElement imgBkCookieChocolateChip;

	    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'124')]")
	    private WebElement imgPieDeQueso;

	    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'174')]")
	    private WebElement imgShakeDeFresa;

	    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'178')]")
	    private WebElement imgShakeDeVainilla;

	    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'43')]")
	    private WebElement imgTostadasFrancesas;
	    
	    public Desserts(AndroidDriver driver) {
	    	this.driver = driver;
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);		// TODO Auto-generated constructor stub

	    }
	    
	    public void clickImgShakeDeOreo() {
	        imgShakeDeOreo.click();
	    }

	    public void clickImgShakeDeChocolate() {
	        imgShakeDeChocolate.click();
	    }

	    public void clickImgShakeDeChocomenta() {
	        imgShakeDeChocomenta.click();
	    }

	    public void clickImgShakeDeCafe() {
	        imgShakeDeCafe.click();
	    }

	    public void clickImgPieDeManzana() {
	        imgPieDeManzana.click();
	    }

	    public void clickImgBkCookieChocolateChip() {
	        imgBkCookieChocolateChip.click();
	    }

	    public void clickImgPieDeQueso() {
	        imgPieDeQueso.click();
	    }

	    public void clickImgShakeDeFresa() {
	        imgShakeDeFresa.click();
	    }

	    public void clickImgShakeDeVainilla() {
	        imgShakeDeVainilla.click();
	    }

	    public void clickImgTostadasFrancesas() {
	        imgTostadasFrancesas.click();
	    }

}
