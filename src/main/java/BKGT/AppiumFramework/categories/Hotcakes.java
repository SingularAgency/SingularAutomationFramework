package BKGT.AppiumFramework.categories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Hotcakes {
	
	AndroidDriver driver;

	@AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'34')]")
    private WebElement imgPANQUEQUES;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'35')]")
    private WebElement imgPANQUEQUES_CON_HUEVO_Y_JAMON;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'36')]")
    private WebElement imgPANQUEQUES_CON_HUEVO_Y_SALCHICHA;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'37')]")
    private WebElement imgPANQUEQUES_CON_HUEVO_Y_TOCINO;
    
    public Hotcakes(AndroidDriver driver) {
        this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    
    public void clickImgPANQUEQUES() {
        imgPANQUEQUES.click();
    }

    public void clickImgPANQUEQUES_CON_HUEVO_Y_JAMON() {
        imgPANQUEQUES_CON_HUEVO_Y_JAMON.click();
    }

    public void clickImgPANQUEQUES_CON_HUEVO_Y_SALCHICHA() {
        imgPANQUEQUES_CON_HUEVO_Y_SALCHICHA.click();
    }

    public void clickImgPANQUEQUES_CON_HUEVO_Y_TOCINO() {
        imgPANQUEQUES_CON_HUEVO_Y_TOCINO.click();
    }


}
