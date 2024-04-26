package BKGT.AppiumFramework.products;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Modificadores {
	public AppiumDriver driver;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Elige tu bebida']/following-sibling::XCUIElementTypeStaticText)[1]")
	@AndroidFindBy(xpath = "(//android.view.View[@resource-id='Elige tu bebida']//android.widget.TextView)[2]")
	public WebElement drinksContainer;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Elige tu acompañamiento']/following-sibling::XCUIElementTypeStaticText)[1]")
	@AndroidFindBy(xpath = "(//android.view.View[@resource-id='Elige tu acompañamiento']//android.widget.TextView)[2]")
	public WebElement acompContainer;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Elige tu postre']/following-sibling::XCUIElementTypeStaticText)[1]")
	@AndroidFindBy(xpath = "(//android.view.View[@resource-id='Elige tu postre']//android.widget.TextView)[2]")
	public WebElement dessertContainer;
	
	//@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Sin Queso']/following-sibling::XCUIElementTypeSwitch")
	
	//@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='¿Deseas eliminar algún ingrediente?']")
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Extras']/following-sibling::XCUIElementTypeStaticText)[1]")
	@AndroidFindBy(xpath = "(//android.view.View[@resource-id='Extras']//android.widget.TextView)[2]")
	public WebElement extrasContainer;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Pie De Manzana']/following-sibling::XCUIElementTypeSwitch")
	@AndroidFindBy(xpath = "//*[@resource-id='checkbox-M408']")
	public WebElement chkManzanaPay;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Pie De Queso']/following-sibling::XCUIElementTypeSwitch")
	@AndroidFindBy(xpath = "//*[@resource-id='checkbox-M411']")
	public WebElement chkQuesoPay;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Papas Fritas Medianas']/following-sibling::XCUIElementTypeImage)[2]")
	@AndroidFindBy(xpath = "//*[@resource-id='AddPAPAS FRITAS MEDIANAS']")
	public WebElement fries;
	@iOSXCUITFindBy(accessibility = "radio-PEPSI")
	@AndroidFindBy(xpath = "//*[@resource-id='radio-PEPSI']")
	public WebElement rbtPepsi;

	@iOSXCUITFindBy(accessibility = "radio-MIRINDA")
	@AndroidFindBy(xpath = "//*[@resource-id='radio-MIRINDA']")
	public WebElement rbtMirinda;

	@iOSXCUITFindBy(accessibility = "radio-7 UP")
	@AndroidFindBy(xpath = "//*[@resource-id='radio-7 UP']")
	public WebElement rbt7Up;

	@iOSXCUITFindBy(accessibility = "radio-TÉ FRÍO LIMÓN")
	@AndroidFindBy(xpath = "//*[@resource-id='radio-TÉ FRÍO LIMÓN']")
	public WebElement rbtTeLimon;

	@iOSXCUITFindBy(accessibility = "radio-TÉ FRÍO DURAZNO")
	@AndroidFindBy(xpath = "//*[@resource-id='radio-TÉ FRÍO DURAZNO']")
	public WebElement rbtTeDurazno;

	@iOSXCUITFindBy(accessibility = "radio-PEPSI BLACK")
	@AndroidFindBy(xpath = "//*[@resource-id='radio-PEPSI BLACK']")
	public WebElement rbtPepsiBlack;

	@iOSXCUITFindBy(accessibility = "radio-GRAPETTE")
	@AndroidFindBy(xpath = "//*[@resource-id='radio-GRAPETTE']")
	public WebElement rbtGrapette;

	@iOSXCUITFindBy(accessibility = "radio-PEPSI 1.5L")
	@AndroidFindBy(xpath = "//*[@resource-id='radio-PEPSI 1.5L']")
	public WebElement rbtPepsi1L;

	@iOSXCUITFindBy(accessibility = "radio-AGUA PURA")
	@AndroidFindBy(xpath = "//*[@resource-id='radio-AGUA PURA']")
	public WebElement rbtAgua;
	

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Pepsi']/following-sibling::XCUIElementTypeImage)[2]")
	@AndroidFindBy(xpath = "//*[@resource-id='AddPEPSI']")
	private WebElement pepsiElement;

	@iOSXCUITFindBy(xpath ="(//XCUIElementTypeStaticText[@name='7 Up']/following-sibling::XCUIElementTypeImage)[2]")
	@AndroidFindBy(xpath = "//*[@resource-id='Add7 UP']")
	private WebElement sevenUpElement;

	@iOSXCUITFindBy(accessibility = "AddMIRINDA")
	@AndroidFindBy(xpath = "//*[@resource-id='AddMIRINDA']")
	private WebElement mirindaElement;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Grapette']/following-sibling::XCUIElementTypeImage)[2]")
	@AndroidFindBy(xpath = "//*[@resource-id='AddGRAPETTE']")
	private WebElement grapetteElement;

	@iOSXCUITFindBy(accessibility = "AddCAFE 16 ONZ")
	@AndroidFindBy(xpath = "//*[@resource-id='AddCAFE 16 ONZ']")
	private WebElement cafe16Element;

	@iOSXCUITFindBy(accessibility = "AddCAFE 16 ONZ CON LECHE")
	@AndroidFindBy(xpath = "//*[@resource-id='AddCAFE 16 ONZ CON LECHE']")
	private WebElement cafe16ConLecheElement;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Dip Agridulce']/following-sibling::XCUIElementTypeImage)[2]")
	@AndroidFindBy(xpath = "//*[@resource-id='AddDIP AGRIDULCE']")
	private WebElement dipAgridulce;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Dip Bbw']/following-sibling::XCUIElementTypeImage)[2]")
	@AndroidFindBy(xpath = "//*[@resource-id='AddDRIP BBW']")
	private WebElement dipBBQ;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Dip Ranch']/following-sibling::XCUIElementTypeImage)[2]")
	@AndroidFindBy(xpath = "//*[@resource-id='AddDIP RANCH']")
	private WebElement dipRanch;

	@iOSXCUITFindBy(accessibility = "AddMAS MOZZARELLA")
	@AndroidFindBy(xpath = "//*[@resource-id='AddMAS MOZZARELLA']")
	private WebElement masMozarella;

	@iOSXCUITFindBy(accessibility = "AddEXTRA JAMON")
	@AndroidFindBy(xpath = "//*[@resource-id='AddEXTRA JAMON']")
	private WebElement extraJamon;

	@iOSXCUITFindBy(accessibility = "AddEXTRA BARBACOA")
	@AndroidFindBy(xpath = "//*[@resource-id='AddEXTRA BARBACOA']")
	private WebElement extraBBQ;

	@iOSXCUITFindBy(accessibility = "AddMAS TOCINO")
	@AndroidFindBy(xpath = "//*[@resource-id='AddMAS TOCINO']")
	private WebElement masTocino;

	@iOSXCUITFindBy(accessibility = "AddEXTRA TOCINO")
	@AndroidFindBy(xpath = "//*[@resource-id='AddEXTRA TOCINO']")
	private WebElement extraTocino;

	@iOSXCUITFindBy(accessibility = "AddEXTRA QUESO SUIZO")
	@AndroidFindBy(xpath = "//*[@resource-id='AddEXTRA QUESO SUIZO']")
	private WebElement extraSuizo;

	@iOSXCUITFindBy(accessibility = "AddMAS QUESO")
	@AndroidFindBy(xpath = "//*[@resource-id='AddMAS QUESO']")
	private WebElement masQueso;

	@iOSXCUITFindBy(accessibility = "AddEXTRA CARNE W")
	@AndroidFindBy(xpath = "//*[@resource-id='AddEXTRA CARNE W']")
	private WebElement extraCarneW;

	@iOSXCUITFindBy(accessibility = "AddMAS PEPINILLOS")
	@AndroidFindBy(xpath = "//*[@resource-id='AddMAS PEPINILLOS']")
	private WebElement masPepinillos;

	@iOSXCUITFindBy(xpath="(//XCUIElementTypeStaticText[@name=\"Mas Jamón\"]/following-sibling::XCUIElementTypeImage)[2]")
	@iOSXCUITFindBy(accessibility = "AddMAS JAMÓN")
	@AndroidFindBy(xpath = "//*[@resource-id='AddMAS JAMÓN']")
	private WebElement masJamon;

	@iOSXCUITFindBy(accessibility = "AddEXTRA TOMATE")
	@AndroidFindBy(xpath = "//*[@resource-id='AddEXTRA TOMATE']")
	private WebElement extraTomate;

	@iOSXCUITFindBy(accessibility = "radio-PAPAS FRITAS MEDIANAS")
	@AndroidFindBy(xpath = "//*[@resource-id='radio-PAPAS FRITAS MEDIANAS']")
	private WebElement rbtPapasMed;

	@iOSXCUITFindBy(accessibility = "radio-PAPAS FRITAS GRANDES")
	@AndroidFindBy(xpath = "//*[@resource-id='radio-PAPAS FRITAS GRANDES']")
	private WebElement rbtPapasG;

	@iOSXCUITFindBy(accessibility = "radio-AROS DE CEBOLLA MEDIANOS")
	@AndroidFindBy(xpath = "//*[@resource-id='radio-AROS DE CEBOLLA MEDIANOS']")
	private WebElement rbtArosMed;

	@iOSXCUITFindBy(accessibility = "radio-AROS DE CEBOLLA GRANDE")
	@AndroidFindBy(xpath = "//*[@resource-id='radio-AROS DE CEBOLLA GRANDE']")
	private WebElement rbtArosG;

	public Modificadores(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

		createSingleDrinks();
		createDrinks();
		createSingleAcomp();
		createExtras();

	}

	public Map<String, WebElement> singleDrinks = new HashMap<>();
	public Map<String, WebElement> singleAcomp = new HashMap<>();
	public Map<String, WebElement> drinks = new HashMap<>();
	public Map<String, WebElement> acomp = new HashMap<>();
	public Map<String, WebElement> extras = new HashMap<>();

	public void createSingleDrinks() {
		singleDrinks.put("Pepsi", rbtPepsi);
		singleDrinks.put("7 UP", rbt7Up);
		singleDrinks.put("Te Limon", rbtTeLimon);
		singleDrinks.put("Te Durazno", rbtTeDurazno);
		singleDrinks.put("Pepsi Black", rbtPepsiBlack);
		singleDrinks.put("Mirinda", rbtMirinda);
		singleDrinks.put("Grapette", rbtGrapette);
		singleDrinks.put("Pepsi 1.5L", rbtPepsi1L);
		singleDrinks.put("Agua", rbtAgua);

	}

	public void createSingleAcomp() {
		singleAcomp.put("Papas Medianas", rbtPapasMed);
		singleAcomp.put("Papas Grandes", rbtPapasG);
		singleAcomp.put("Aros Medianos", rbtArosMed);
		singleAcomp.put("Aros  Grandes", rbtArosG);
	}

	public void createDrinks() {
		drinks.put("Pepsi", pepsiElement);
		drinks.put("7 UP", sevenUpElement);
		drinks.put("Mirinda", mirindaElement);
		drinks.put("Grapette", grapetteElement);
		drinks.put("Cafe 16", cafe16Element);
		drinks.put("Cafe 16 con Leche", cafe16ConLecheElement);
	}

	/*
	 * public void createAcomp() { acomp.put("PapasMed",driver.findElement(By.
	 * xpath("//*[@resource-id='radio-PAPAS FRITAS MEDIANAS']")));
	 * acomp.put("PapasGrand",
	 * driver.findElement(By.xpath("//*[@resource-id='radio-PAPAS FRITAS GRANDES']")
	 * )); acomp.put("ArosMed", driver.findElement(By.
	 * xpath("//*[@resource-id='radio-AROS DE CEBOLLA MEDIANOS']")));
	 * acomp.put("ArosGrand",driver.findElement(By.
	 * xpath("//*[@resource-id='radio-AROS DE CEBOLLA GRANDE']"))); }
	 */

	public void createExtras() {
		extras.put("Dip Agridulce", dipAgridulce);
		extras.put("Dip Ranch", dipRanch);
		extras.put("Dip Bbw", dipBBQ);
		extras.put("Mas Mozzarella", masMozarella);
		extras.put("Extra Jamon", extraJamon);
		extras.put("Extra Carne W", extraCarneW);
		extras.put("Extra BBQ", extraBBQ);
		extras.put("Extra Suizo", extraSuizo);
		extras.put("Mas Jamon", masJamon);
		extras.put("Mas Pepinillos", masPepinillos);
		extras.put("Mas Queso", masQueso);
		extras.put("Mas Tocino", masTocino);
		extras.put("Extra Tocino", extraTocino);

	}

	String drinkText, acompText, dessText, extText;

	public int maxDrinks;
	public int maxAcomp;
	public int maxDesserts;
	public int maxExt;

	public int getMaxCounters(String text) {
		Pattern pattern = Pattern.compile("(?<=\\D)\\d");
		Matcher matcher = pattern.matcher(text);

		if (matcher.find()) {
			String secondDigitString = matcher.group();
			int secondDigit = Integer.parseInt(secondDigitString);
			return secondDigit;

		}
		return 0;
	}

	public void setMaxDrinks() {
		maxDrinks = getMaxCounters(drinksContainer.getText());

	}

	public void setMaxAcomp() {
		maxAcomp = getMaxCounters(acompContainer.getText());

	}

	public void setMaxDesserts() {
		maxDesserts = getMaxCounters(dessertContainer.getText());
	}

	public void setMaxExtras() {
		maxExt = getMaxCounters(extrasContainer.getText());

	}

}
