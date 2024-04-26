package BKGT.AppiumFramework.categories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Chapin {
	
	AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'30')]")
    private WebElement imgDESAYUNO_CHAPIN;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'31')]")
    private WebElement imgDESAYUNO_CHAPIN_CON_JAMON;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'32')]")
    private WebElement imgDESAYUNO_CHAPIN_CON_SALCHICHA;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'33')]")
    private WebElement imgDESAYUNO_CHAPIN_CON_TOCINO;
    
    public Chapin(AndroidDriver driver) {
        this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    
    public void clickImgDESAYUNO_CHAPIN() {
        imgDESAYUNO_CHAPIN.click();
    }

    public void clickImgDESAYUNO_CHAPIN_CON_JAMON() {
        imgDESAYUNO_CHAPIN_CON_JAMON.click();
    }

    public void clickImgDESAYUNO_CHAPIN_CON_SALCHICHA() {
        imgDESAYUNO_CHAPIN_CON_SALCHICHA.click();
    }

    public void clickImgDESAYUNO_CHAPIN_CON_TOCINO() {
        imgDESAYUNO_CHAPIN_CON_TOCINO.click();
    }
    
}
