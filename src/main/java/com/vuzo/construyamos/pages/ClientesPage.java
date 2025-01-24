package com.vuzo.construyamos.pages;

import com.appium.setup.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@Getter
public class ClientesPage extends BasePage {
    public ClientesPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "Agregar Cliente")
    private WebElement btnAgregarCliente;

    @AndroidFindBy(accessibility = "Agregar")
    private WebElement btnAgregar;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[4]")
    private WebElement txtCorreo;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
    private WebElement txtDPI;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
    private WebElement txtFilterName;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
    private WebElement txtName;
    @AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
    private WebElement txtFilterPhone;
    @AndroidFindBy(xpath = "(//android.widget.EditText)[3]")
    private WebElement txtPhone;
    @AndroidFindBy(xpath = "(//android.widget.EditText)[3]")
    private WebElement txtFilterDPI;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[5]")
    private WebElement txtDireccion;

    @AndroidFindBy(accessibility = "Selecciona un territorio")
    private WebElement cbxTerritorio;

    @AndroidFindBy(xpath = "//android.widget.Button")
    private List<WebElement> territorios;

    @AndroidFindBy(accessibility = "¡Genial!")
    private  WebElement btnGenial;

    @AndroidFindBy(accessibility = "¡Felicidades!")
    private  WebElement lblConfirmacionCliente;

    @AndroidFindBy(accessibility = "Seleccione territorio...")
    private WebElement btnFiltroTerritorio;

    @AndroidFindBy(accessibility = "Filtros")
    private  WebElement btnClientesFiltros;

    @AndroidFindBy(accessibility = "Aplicar Filtros")
    private  WebElement btnAplicarFiltros;

    private WebElement getEditTextField(int index) {
        return driver.findElement(By.xpath("(//android.widget.EditText)[" + index + "]"));
    }

    public WebElement filterResult(String search){
        return driver.findElement(By.xpath("//android.view.View[@content-desc="+search+"]"));
    }



}
