package BKGT.AppiumFramework.pages;


import org.openqa.selenium.WebElement;

import BKGT.AppiumFramework.BasePage;
import BKGT.AppiumFramework.categories.Promotions;
import BKGT.AppiumFramework.products.Detalle;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MenuPage extends BasePage{
	Detalle detalle;
	
	public Promotions promotions;
	
    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'17')]")
    private WebElement imgKingDePolloFrances;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'16')]")
    private WebElement imgKingDePolloAmericano;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'145')]")
    private WebElement imgBkNuggets4Piezas;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'187')]")
    private WebElement imgTenderGrill;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'14')]")
    private WebElement imgKingDePollo;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'146')]")
    private WebElement imgBkNuggets10Piezas;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'186')]")
    private WebElement imgCrispyChicken;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'18')]")
    private WebElement imgKingDePolloItaliano;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'147')]")
    private WebElement imgBkNuggets35Piezas;
	
    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'2537')]")
    private WebElement imgCafePie;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'216')]")
    private WebElement imgMegaBkStackerRodeoTriple;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'197')]")
    private WebElement imgComboMegaBkStackerRodeo;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'78')]")
    private WebElement imgComboWhopperJr;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'25')]")
    private WebElement imgComboBigKing;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'165')]")
    private WebElement imgComboMegaBkStacker;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'160')]")
    private WebElement imgComboMegaDobleQuesoYTocino;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'141')]")
    private WebElement imgComboWhopperTejano;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'266')]")
    private WebElement imgComboWhopperDobleConQueso;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'246')]")
    private WebElement imgComboCaliforniaWhopper;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'182')]")
    private WebElement imgComboKingDePescado;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'202')]")
    private WebElement imgComboMegaBkStackerAtomica2;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'209')]")
    private WebElement imgComboBaconKing;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'75')]")
    private WebElement imgComboWhopper;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'137')]")
    private WebElement imgComboWhopperDoble;

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'77')]")
    private WebElement imgComboKingDePollo;
    

    @AndroidFindBy(xpath = "//android.widget.Image[contains(@text,'77')]")
    private WebElement btnAgregar;
    
	
	@AndroidFindBy(xpath = "//*[@resource-id='radio-PAPAS FRITAS MEDIANAS']")
	private WebElement rbtPapasMed;
    
	@AndroidFindBy(xpath = "//*[@resource-id='radio-PEPSI BLACK']")
	public WebElement rbtPepsiBlack;
    
	@AndroidFindBy(xpath="//*[@resource-id='addCartActive']")
	protected WebElement btnAddCart;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,\"Pepsi Black\")]")
	protected WebElement lblPepsiBlack;
	
	AppiumDriver driver;

	public MenuPage(AppiumDriver driver) {
		super(driver);
		this.detalle = new Detalle(driver);
		this.driver=driver;
		this.promotions = new Promotions(driver);
	}
	
	public String agregarComboWhoperTejano() {
		waitForElementVisible(imgComboWhopperTejano);
		imgComboWhopperTejano.click();
		String producto = detalle.getProductName();
		
		waitForElementVisible(rbtPapasMed);
		rbtPapasMed.click();

		scrollDown();
		waitForElementVisible(rbtPepsiBlack);
		rbtPepsiBlack.click();
		
		waitForElementVisible(btnAddCart);
		btnAddCart.click();
		
		return producto;
		
		
	}
	

	
	

}
