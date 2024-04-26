package BKGT.AppiumFramework.pages;

import org.openqa.selenium.WebElement;

import BKGT.AppiumFramework.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Cart extends BasePage {
	
	AppiumDriver driver;

	@AndroidFindBy(id="Ver menú")
	private WebElement btnMenu;
	
	
	@AndroidFindBy(xpath="//android.widget.Button[contains(@text,'Ir a pagar')]")
	private WebElement btnIrPagar;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Total']/following-sibling::XCUIElementTypeStaticText")
	private WebElement lblTotal;
	
	@iOSXCUITFindBy(accessibility = "Ordenar")
	@AndroidFindBy(xpath="//android.widget.Button[contains(@text,'Ordenar')]")
	private WebElement btnOrder;
	
	@iOSXCUITFindBy(accessibility = "Efectivo")
	@AndroidFindBy(xpath="//android.view.View[@resource-id=\"cash\"]//android.view.View")
	private WebElement btnCash;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeTextField[3]")
	@AndroidFindBy(xpath="//android.view.View[@resource-id=\"CashField\"]")
	private WebElement txtAmmount;
	
	@iOSXCUITFindBy(xpath="//*[contains(@name,'Orden confirmada con')]")
	@AndroidFindBy(xpath="//android.widget.TextView[@contains(@text,'Orden confirmada con')]")
	private WebElement lblOrderConfirm;
	
	public Cart(AppiumDriver driver) {
		super(driver);
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	
	
	public boolean isDisplayed() {
		return waitForElementVisible(btnIrPagar).isDisplayed();
	}
	
	
	public void goPay() throws InterruptedException {
		btnIrPagar.click();
		Thread.sleep(1000);

		scrollDown();


		waitForElementVisible(btnCash);
		btnCash.click();
		
		Thread.sleep(1000);
		clickAtCoordinate(150, 1750);

	}
	
	public void order() throws InterruptedException {
		btnOrder.click();
		
	}
	
}
