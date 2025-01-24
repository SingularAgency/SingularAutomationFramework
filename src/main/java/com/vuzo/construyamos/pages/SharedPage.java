package com.vuzo.construyamos.pages;

import com.appium.setup.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
public class SharedPage extends BasePage {

    public SharedPage(AppiumDriver driver) {
        super(driver);

    }
    @AndroidFindBy(accessibility = "Proyectos")
    public WebElement btnProyectos;

    @AndroidFindBy(accessibility = "Clientes")
    public WebElement btnClientes;

    @AndroidFindBy(accessibility = "Constructores")
    public WebElement btnConstructores;

    @AndroidFindBy(accessibility = "Dashboard")
    public WebElement btnDashboard;

    @AndroidFindBy(accessibility = "Cerrar sesión")
    public WebElement btnLogout;

    @AndroidFindBy(xpath = "(//android.view.View[contains(@content-desc,'Administración de Clientes')]//android.widget.ImageView)[2]")
    public WebElement btnAccount;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
    public WebElement txtGenericBox;



}