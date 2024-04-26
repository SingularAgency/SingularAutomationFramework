package com.bkgt.pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Address extends BasePage{
	public Address(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@iOSXCUITFindBy(accessibility ="Continuar")
	protected WebElement btnContinue;
	
	@iOSXCUITFindBy(accessibility ="Guardar dirección")
	protected WebElement btnSaveAddress;
	
	@iOSXCUITFindBy(xpath="(//XCUIElementTypeStaticText[@name=\"Departamento*\"]/following-sibling::XCUIElementTypeTextField)[1]")
	protected WebElement txtDepartment;
	
	@iOSXCUITFindBy(xpath="(//XCUIElementTypeStaticText[@name=\"Municipio*\"]/following-sibling::XCUIElementTypeTextField)[1]")
	protected WebElement txtMunicipio;
	
	@iOSXCUITFindBy(xpath="(//XCUIElementTypeStaticText[@name=\"Zona*\"]/following-sibling::XCUIElementTypeTextField)[1]")
	protected WebElement txtZone;
	
	@iOSXCUITFindBy(xpath="(//XCUIElementTypeStaticText[@name=\"Dirección exacta*\"]/following-sibling::XCUIElementTypeTextField)[1]")
	protected WebElement txtExactAddress;
	
	@iOSXCUITFindBy(xpath="(//XCUIElementTypeStaticText[@name=\"Detalles adicionales\"]/following-sibling::XCUIElementTypeTextField)[1]")
	protected WebElement txtAdditionalDetails;
	
	@iOSXCUITFindBy(xpath="(//XCUIElementTypeStaticText[@name=\"Nombre de tu dirección\"]/following-sibling::XCUIElementTypeTextField)[1]")
	protected WebElement txtAddressName;
	

	@iOSXCUITFindBy(xpath="(//XCUIElementTypeOther[@name=\"main\"]//XCUIElementTypeStaticText)[position() = 3]")
	@AndroidFindBy(xpath="//android.widget.ListView[1]")
	protected WebElement lvResult;
	
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Nueva dirección\"]")
	protected WebElement btnNewDirection;
	
	//xpath for saveddirections delete button //XCUIElementTypeOther[@name="main"]//XCUIElementTypeOther//XCUIElementTypeStaticText/following-sibling::XCUIElementTypeImage
	// and for direction  //XCUIElementTypeOther[@name="main"]//XCUIElementTypeOther//XCUIElementTypeStaticText
	
	@iOSXCUITFindBy(accessibility = "web dialog")
	protected WebElement formModal;

	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Confirmar direcc')]")
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Confirmar direcc')]")
	protected WebElement lblConfirmHeader;

	@iOSXCUITFindBy(xpath="(//XCUIElementTypeImage)[5]")
	@AndroidFindBy(xpath="(//android.widget.Image)[5]")
	protected WebElement btnFirstResultDelete;
	
	@iOSXCUITFindBy(accessibility ="Permitir una vez")
	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	protected WebElement btnAllowLocation;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert[@name=\"¿Permitir a Burger King Guatemala utilizar tu ubicación?\"]")
	@AndroidFindBy(id = "com.android.permissioncontroller:id/grant_dialog")
	protected WebElement mobileDialog;
	
	@iOSXCUITFindBy(accessibility = "Guardar")
	@AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'Guardar')]")
	protected WebElement btnSave;
	
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"main\"]/XCUIElementTypeTextField")
	@AndroidFindBy(xpath="//android.widget.EditText")
	protected WebElement txtSearch;
		

	
	@iOSXCUITFindBy(accessibility = "Your Position")
	protected WebElement userPin;
	
	@iOSXCUITFindBy(accessibility = "Mapa")
	protected WebElement map;
	

	
	
}
