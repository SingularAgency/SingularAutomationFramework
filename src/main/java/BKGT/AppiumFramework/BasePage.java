package BKGT.AppiumFramework;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Interaction;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class BasePage {
	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"banner\"]/XCUIElementTypeImage")
	@AndroidFindBy(xpath = "//*[contains(@text,'arrow-square-left')]")
	protected WebElement btnBack;

	
	@iOSXCUITFindBy(accessibility = "Ver Carrito")
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Ver Carrito\"]")
	protected WebElement btnCart;

	@iOSXCUITFindBy(accessibility = "Home")
	@AndroidFindBy(xpath = "//*[contains(@text,'Home')]")
	protected WebElement btnHome;

	@iOSXCUITFindBy(accessibility = "Órdenes")
	@AndroidFindBy(xpath = "//*[contains(@text,'Órdenes')]")
	protected WebElement btnOrders;

	
	@iOSXCUITFindBy(accessibility = "Restaurantes")
	@AndroidFindBy(xpath = "//*[contains(@text,'Restaurantes')]")
	protected WebElement btnRestaurants;

	@iOSXCUITFindBy(accessibility = "Cupones")
	@AndroidFindBy(xpath = "//*[contains(@text,'Cupones')]")
	protected WebElement btnCoupons;

	@iOSXCUITFindBy(accessibility = "Mi cuenta")
	@AndroidFindBy(xpath = "//*[contains(@text,'Mi cuenta')]")
	protected WebElement btnAccount;

	
	@iOSXCUITFindBy(accessibility = "Promoción")
	@AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'Promo')]")
	protected WebElement btnPromo;
	
	@iOSXCUITFindBy(accessibility = "Combos")
	@AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'Combos')]")
	protected WebElement btnCombos;

	@iOSXCUITFindBy(accessibility = "Carne")
	@AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'Carne')]")
	protected WebElement btnBeef;

	@iOSXCUITFindBy(accessibility = "Pollo")
	@AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'Pollo')]")
	protected WebElement btnChicken;

	@iOSXCUITFindBy(accessibility = "Extra")
	@AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'Extra')]")
	protected WebElement btnExtra;

	@iOSXCUITFindBy(accessibility = "Bebidas")
	@AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'Bebidas')]")
	protected WebElement btnDrinks;

	@iOSXCUITFindBy(accessibility = "Postres")
	@AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'Postres')]")
	protected WebElement btnDesserts;

	@iOSXCUITFindBy(accessibility = "Ensaladas")
	@AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'Ensaladas')]")
	protected WebElement btnSalads;

	@iOSXCUITFindBy(accessibility = "Niños")
	@AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'Niños')]")
	protected WebElement btnKids;
	
	@iOSXCUITFindBy(accessibility = "Otros")
	@AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'Otros')]")
	protected WebElement btnOthers;

	@iOSXCUITFindBy(accessibility = "Croissant")
	@AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'Croissant')]")
	protected WebElement btnCroissants;

	@iOSXCUITFindBy(accessibility = "Bk Muffin")
	@AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'Bk Muffin')]")
	protected WebElement btnMuffin;

	@iOSXCUITFindBy(accessibility = "Bk Chapin")
	@AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'Bk Chap')]")
	protected WebElement btnChapin;

	@iOSXCUITFindBy(accessibility = "Panqueques")
	@AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'Panqueques')]")
	protected WebElement btnHotcakes;

	@iOSXCUITFindBy(accessibility = "Guardar")
	@AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'Guardar')]")
	protected WebElement btnSave;
	
	@iOSXCUITFindBy(accessibility ="Permitir una vez")
	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	protected WebElement btnAllowLocation;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert[@name=\"¿Permitir a Burger King Guatemala utilizar tu ubicación?\"]")
	@AndroidFindBy(id = "com.android.permissioncontroller:id/grant_dialog")
	protected WebElement mobileDialog;
	JavascriptExecutor js;

	protected AppiumDriver driver;
	protected WebDriverWait wait;

	public BasePage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.js = (JavascriptExecutor) driver;

	}

	public WebElement waitForElementPresent(By locator) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public WebElement waitForElementVisible(WebElement locator) {
		return wait.until(ExpectedConditions.visibilityOf(locator));
	}
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "FINGER");

	public void clickAtCoordinate(int xCord, int yCord) {
		Point tapPoint = new Point(xCord, yCord);
		Sequence tap = new Sequence(FINGER, 1);
		tap.addAction(
				FINGER.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
		tap.addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		tap.addAction(FINGER.createPointerMove(Duration.ofMillis(50), PointerInput.Origin.viewport(), tapPoint.x,
				tapPoint.y));
		tap.addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(tap));
	}
	
	public void tap() {
		
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence tap = new Sequence(finger, 1);
		tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 100, 100));
		tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(tap));

	}

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
				.addAction(FINGER.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), end.getX(),
						end.getY()))
				.addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(swipe));
	}
	
	public void scrollDownTwoTimes() {
		scrollDown();
		scrollDown();
	}

	public void scrollUp() {

		Point end = new Point(576, 1516);
		Point start = new Point(599, 854);
		Sequence swipe = new Sequence(FINGER, 1)
				.addAction(FINGER.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), start.getX(),
						start.getY()))
				.addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(FINGER.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), end.getX(),
						end.getY()))
				.addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(swipe));

	}

	public void scrollLeft() throws InterruptedException {
		Point start = new Point(100, 375);
		Point end = new Point(900, 375);
		Sequence swipe = new Sequence(FINGER, 1)
				.addAction(FINGER.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), start.getX(),
						start.getY()))
				.addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(FINGER.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), end.getX(),
						end.getY()))
				.addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(swipe));

	}

	public void scrollRight() throws InterruptedException {
		Point end = new Point(100, 375);
		Point start = new Point(900, 375);
		Sequence swipe = new Sequence(FINGER, 1)
				.addAction(FINGER.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), start.getX(),
						start.getY()))
				.addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(FINGER.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), end.getX(),
						end.getY()))
				.addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(swipe));
	}
	
	public void scrollRightiOS() {
		Point end = new Point(100, 200);
		Point start = new Point(900, 200);
		Sequence swipe = new Sequence(FINGER, 1)
				.addAction(FINGER.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), start.getX(),
						start.getY()))
				.addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(FINGER.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), end.getX(),
						end.getY()))
				.addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(swipe));
	}

	public void allowLocation() {
		wait.until(ExpectedConditions.visibilityOf(mobileDialog));
		btnAllowLocation.click();
	}

	public void clickHome() {
		btnHome.click();
	}

	public void clickOrders() {
		btnOrders.click();
	}

	public void clickRestaurants() {
		btnRestaurants.click();
	}

	public void clickCoupon() {
		btnCoupons.click();
	}

	public void clickAccount() {
		btnAccount.click();
	}

	public void clickPromo() {
		btnPromo.click();
	}

	public void clickCombos() {
		btnCombos.click();
	}

	public void clickBeef() {
		btnBeef.click();
	}

	public void getBack() {
		btnBack.click();
	}

	public void clickChicken() {
		btnChicken.click();
	}

	public void clickExtra() {
		wait.until(ExpectedConditions.visibilityOf(btnExtra));

		btnExtra.click();
	}

	public void clickDrinks() {
		wait.until(ExpectedConditions.visibilityOf(btnDrinks));
		btnDrinks.click();
	}

	public void clickDesserts() {
		wait.until(ExpectedConditions.visibilityOf(btnDesserts));

		btnDesserts.click();
	}

	public void clickSalads() {
		btnSalads.click();
	}

	public void clickKids() {
		btnKids.click();
	}

	public void clickCroissants() {
		btnCroissants.click();
	}

	public void clickMuffins() {
		btnMuffin.click();
	}

	public void clickChapin() {
		btnChapin.click();
	}

	public void clickHotcakes() {
		waitForElementVisible(btnHotcakes);
		btnHotcakes.click();
	}

	public void clickCart() {
		btnCart.click();
	}
	

}
