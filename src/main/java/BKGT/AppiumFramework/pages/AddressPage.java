package BKGT.AppiumFramework.pages;


import org.openqa.selenium.WebElement;


import BKGT.AppiumFramework.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AddressPage extends BasePage{

	//xpath="//android.widget.EditText"
	
	//xpath="//android.widget.ListView"
	AppiumDriver driver;
	

	@AndroidFindBy(xpath="//android.widget.EditText")
	private WebElement txtSearch;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeOther[1]")
	@AndroidFindBy(xpath="//android.widget.ListView[1]")
	private WebElement lvResult;
	
	@AndroidFindBy(xpath="//android.view.View[1]/android.widget.EditText")
	private WebElement txtAddress;
	
	@AndroidFindBy(xpath="//android.view.View[2]//android.view.View[4]/android.widget.EditText")
	private WebElement txtAdditionalDetails;
	
	@AndroidFindBy(xpath="//android.widget.Image[contains(@text,'close circle')]")
	private WebElement btnClear;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Confirmar direcc')]")
	private WebElement lblConfirmHeader;

	@iOSXCUITFindBy(xpath="(//XCUIElementTypeImage[5]")
	@AndroidFindBy(xpath="(//android.widget.Image)[5]")
	private WebElement btnFirstResultDelete;
	
	
	
	public AddressPage(AppiumDriver driver) {
		super(driver);
	
	}
	
	public boolean isPageLoaded() {
		return waitForElementVisible(txtSearch).isDisplayed();
	}
	
	public void searchAddres(String address) throws InterruptedException {

		txtSearch.sendKeys(address);
		Thread.sleep(8000);
		waitForElementVisible(lvResult);
		lvResult.click();
		
		
	}
	
	public void saveAddress() {
		waitForElementVisible(btnSave);
	
		btnSave.click();
	}
	
	public void fillAddress(String address) {
		waitForElementVisible(lblConfirmHeader);
		btnClear.click();
		txtAddress.sendKeys(address);
		
		txtAdditionalDetails.sendKeys("Desde Appium");
	}
	
	public void deleteAddres() {
		waitForElementVisible(btnFirstResultDelete);
		btnFirstResultDelete.click();
		
	}
	
	
	
}
