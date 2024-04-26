package BKGT.AppiumFramework.categories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Muffins {
	AndroidDriver driver;


    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'39')]")
    private WebElement imgBK_MUFFIN_HUEVO_Y_QUESO;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'40')]")
    private WebElement imgBK_MUFFIN_HUEVO_QUESO_Y_JAMON;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'41')]")
    private WebElement imgBK_MUFFIN_HUEVO_QUESO_Y_TOCINO;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'42')]")
    private WebElement imgBK_MUFFIN_HUEVO_QUESO_Y_SALCHICHA;
    
    public Muffins(AndroidDriver driver) {
        this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    public void clickImgBK_MUFFIN_HUEVO_Y_QUESO() {
        imgBK_MUFFIN_HUEVO_Y_QUESO.click();
    }

    public void clickImgBK_MUFFIN_HUEVO_QUESO_Y_JAMON() {
        imgBK_MUFFIN_HUEVO_QUESO_Y_JAMON.click();
    }

    public void clickImgBK_MUFFIN_HUEVO_QUESO_Y_TOCINO() {
        imgBK_MUFFIN_HUEVO_QUESO_Y_TOCINO.click();
    }

    public void clickImgBK_MUFFIN_HUEVO_QUESO_Y_SALCHICHA() {
        imgBK_MUFFIN_HUEVO_QUESO_Y_SALCHICHA.click();
    }
}
