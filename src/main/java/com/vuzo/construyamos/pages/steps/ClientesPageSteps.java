package com.vuzo.construyamos.pages.steps;

import com.vuzo.construyamos.pages.ClientesPage;
import com.vuzo.construyamos.pages.SharedPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class ClientesPageSteps extends ClientesPage {
    SharedPage sharedPage;
    public ClientesPageSteps(AppiumDriver driver) {
        super(driver);
        sharedPage = new SharedPage(driver);
    }


    public WebElement filterResult(String search){
        return driver.findElement(By.xpath("//android.view.View[@content-desc='"+search+"']"));
    }


    public void createCliente(String DPI, String name, String phone, String email, String address){

        //getBtnAgregarCliente().click();


        wait.until(ExpectedConditions.visibilityOf(getTxtDPI()));
        getTxtDPI().click();
        getTxtDPI().sendKeys(DPI);
        getTxtName().click();
        getTxtName().sendKeys(name);
        getTxtPhone().click();
        getTxtPhone().sendKeys(phone);
        getTxtCorreo().click();
        getTxtCorreo().sendKeys(email);
        getCbxTerritorio().click();
        List<WebElement> territorios = getTerritorios();
        Random rand = new Random();
        WebElement randomTerritorio = territorios.get(rand.nextInt(territorios.size()));
        randomTerritorio.click();
        getTxtDireccion().click();
        getTxtDireccion().sendKeys(address);
        getBtnAgregar().click();
    }

    public boolean wasClientCreated(){
        boolean flag = getLblConfirmacionCliente().isDisplayed();
        getBtnGenial().click();
        return flag;
    }


    public void filterClient(String DPI, String name, String phone){
        getBtnClientesFiltros().click();

        wait.until(ExpectedConditions.visibilityOf(getTxtFilterName()));

        getTxtFilterName().click();
        getTxtFilterName().sendKeys(name);
        getTxtFilterPhone().click();
        getTxtFilterPhone().sendKeys(phone);
        getTxtFilterDPI().click();
        getTxtFilterDPI().sendKeys(DPI);
        getBtnAplicarFiltros().click();
    }

    public boolean isClientFiltered(String DPI, String name, String phone){
        WebElement rowNombre = filterResult(name);
        int maxLength = 10;
        String truncated = DPI.length() > maxLength ? DPI.substring(0, maxLength) : DPI;

        WebElement rowDPI = filterResult(truncated);
        WebElement rowPhone = filterResult(phone);

        return rowNombre.isDisplayed() && rowDPI.isDisplayed() && rowPhone.isDisplayed();

    }

}
