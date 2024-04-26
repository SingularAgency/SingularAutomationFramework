package BKGT.AppiumFramework.pages;


import org.openqa.selenium.WebElement;

import BKGT.AppiumFramework.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Homepage extends BasePage{
	AppiumDriver driver;
	
	@iOSXCUITFindBy(accessibility = "Buscar dirección")
	@AndroidFindBy(xpath="//android.widget.Button[contains(@text,'Buscar dirección')]")
	private WebElement btnBannerAddress;
	
	@iOSXCUITFindBy(accessibility = "web dialog")
	private WebElement divModal;
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'La hora de la comida ha llegado')]")
	private WebElement lblWelcomeMessage;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'¡Buenos')]")
	private WebElement lblWelcomeMessageMorning;
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Escoge')]")
	private WebElement lblWelcomeMessagePart2;
	
	@AndroidFindBy(xpath="//android.widget.Image[contains(@text,'good-afternoon')]")
	private WebElement imgBanner;
	
	@AndroidFindBy(id="swiper-wrapper-2e5b9d1894426225")
	private WebElement swpMenu;
	
	//(//XCUIElementTypeOther[@name="banner"]//XCUIElementTypeStaticText)[1]
	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"banner\"]/XCUIElementTypeOther[1]/XCUIElementTypeOther//XCUIElementTypeStaticText")
	@AndroidFindBy(xpath="//*[@resource-id=\"address\"]")
	private WebElement btnAddress;
		
	

	public Homepage(AppiumDriver driver) {
		super(driver);
		this.driver=driver;
	
	}
	
	
	public boolean isBannerLoaded() {
		return waitForElementVisible(btnBannerAddress).isDisplayed();
	}
	public boolean isPageLoaded() {
		return waitForElementVisible(btnHome).isDisplayed();
	}
	
	public String getWelcomeMessage() {
		waitForElementVisible(imgBanner);
		String txtMessage = lblWelcomeMessage.getText() + " " + lblWelcomeMessagePart2.getText();
		
		return txtMessage;
	}
	
	public String getWelcomeMessageMorning() {
		waitForElementVisible(lblWelcomeMessageMorning);
		String txtMessage = lblWelcomeMessageMorning.getText() + " " + lblWelcomeMessagePart2.getText();
		
		return txtMessage;
	}
	
	
	public void closeModal() throws InterruptedException {
		waitForElementVisible(btnBannerAddress);
		tap();
		Thread.sleep(5000);
	}
	
	public void goToDirections() throws InterruptedException {
		waitForElementVisible(btnBannerAddress);
		btnBannerAddress.click();
		Thread.sleep(2000);
	

		allowLocation();
	}
	

	
	public void clickAddress() {
		//utils.waitForElementVisible(btnAddress);
		btnAddress.click();
		
		
	}
	

	
	public boolean validateSavedAddress(String address) {
		
		waitForElementVisible(btnAddress);
		String addressText = btnAddress.getText().toString();
		return addressText.contentEquals(address);
		
	}
	
	
}
