package BKGT.AppiumFramework.products;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Product {
	public Modificadores mods;

	public AppiumDriver driver;
	protected WebDriverWait wait;
	
	@iOSXCUITFindBy(accessibility="Combo Reconciliación")
	@AndroidFindBy(xpath="//*[@resource-id='productName']")
	private WebElement lblProductName;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[contains(@name,'Agregar')]")
	@AndroidFindBy(xpath="//*[@resource-id='addCartActive']")
	protected WebElement btnAddCart;
	

	public Product(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));	
// TODO Auto-generated constructor stub
	}
	
	public void setMods() {
		this.mods=new Modificadores(driver);
	}
	
	
	public boolean isProductVisible() {
		return wait.until(ExpectedConditions.visibilityOf(lblProductName)).isDisplayed();

	}
	
	public WebElement waitForElement(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public String getRandomElement(String [] locators) {
	    Random random = new Random();
        int randomIndex = random.nextInt(locators.length);

        // Choose the string at the random index
        String randomString = locators[randomIndex];
        return randomString;
	}
	
	public void addCounters(String []array, Map<String, WebElement> hashMap, int count) throws InterruptedException {
		
		for(int i=0;i<count;i++) {
			hashMap.get(getRandomElement(array)).click();;
		}
		
	}
	
	public void addSingles(String []array, Map<String, WebElement> hashMap) {
		hashMap.get(getRandomElement(array)).click();;

	}
	
	public void addSingles( Map<String, WebElement> hashMap) {
        List<Entry<String, WebElement>> list = new ArrayList<>(hashMap.entrySet());
        Random random = new Random();
        Entry<String, WebElement> randomEntry = list.get(random.nextInt(list.size()));
        randomEntry.getValue().click();
        
	}
	
	public void addToCart() {
	
		wait.until(ExpectedConditions.elementToBeClickable(btnAddCart));
		btnAddCart.click();
	}
	
	final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "FINGER");

	public void scrollDown() {

		
	int startX = driver.manage().window().getSize().getWidth() / 2;
		int startY = driver.manage().window().getSize().getHeight() / 2;
		Point start = new Point(startX,startY);

		int endY = (int) (driver.manage().window().getSize().getHeight() * 0.2);
		Point end = new Point(startX,endY);
		
		Sequence swipe = new Sequence(FINGER, 1)
				.addAction(FINGER.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), start.getX(),
						start.getY()))
				.addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(FINGER.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), end.getX(),
						end.getY()))
				.addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(swipe));
		

	}


}
