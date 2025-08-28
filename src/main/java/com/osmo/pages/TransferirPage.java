package com.osmo.pages;

import com.appium.setup.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TransferirPage extends BasePage {

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"ENVIAR\")]")
    private WebElement btnSend;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement txtAddress;

    @AndroidFindBy(xpath = "//android.widget.Button[6]")
    private WebElement btnNext;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"RECIBIR\")]")
    private WebElement btnReceive;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Billetera Bitcoin\n" +
            "Envía a cualquier billetera Bitcoin\"]")
    private WebElement btnSendBTC;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Enviar globalmente\n" +
            "A cuenta de banco internacional\"]")
    private WebElement btnSendGlobally;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Billetera USDC\n" +
            "Envia a cualquier billetera USDC (Polygon)\"]")
    private WebElement btnSendUSDC;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Continuar\"]")
    private WebElement btnContinue;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,\"SATS\")]")
    private WebElement txtSatsField;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"TOTAL\"]/following-sibling::android.view.View[contains(@content-desc,\" SATS\")]")
    private WebElement lblTotalSats;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Enviar dinero\"]")
    private WebElement btnSendMoney;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"¡RECIBISTE\")]")
    private WebElement receivedModal;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"DINERO ENVIADO CORRECTAMENTE\"]")
    private WebElement sentModal;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Regresar al inicio\"]")
    private WebElement btnGoHome;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Ver comprobante\"]")
    private WebElement btnSeeReceipt;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Pegar dirección\"]")
    private WebElement btnPasteAddress;

    public TransferirPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getBtnPasteAddress() {
        waitForVisibilityOfElement(btnPasteAddress);
        return btnPasteAddress;
    }

    public WebElement getTxtAddress() {
        waitForVisibilityOfElement(txtAddress);
        return txtAddress;
    }

    public WebElement getBtnSendBTC() {
        waitForVisibilityOfElement(btnSendBTC);
        return btnSendBTC;
    }

    public WebElement getBtnSendGlobally() {
        waitForVisibilityOfElement(btnSendGlobally);
        return btnSendGlobally;
    }

    public WebElement getBtnSendUSDC() {
        waitForVisibilityOfElement(btnSendUSDC);
        return btnSendUSDC;
    }

    public WebElement getBtnSend() {
        waitForVisibilityOfElement(btnSend);
        return btnSend;
    }

    public WebElement getBtnReceive() {
        waitForVisibilityOfElement(btnReceive);
        return btnReceive;
    }

    public WebElement getLblTotalSats() {
        waitForVisibilityOfElement(lblTotalSats);
        return lblTotalSats;
    }

    public WebElement getBtnGoHome() {
        waitForVisibilityOfElement(btnGoHome);
        return btnGoHome;
    }

    public WebElement getBtnContinue() {
        waitForVisibilityOfElement(btnContinue);
        waitForElementToBeEnabled(btnContinue);
        return btnContinue;
    }

    public WebElement getBtnNext() {
        waitForVisibilityOfElement(btnNext);
        return btnNext;
    }

    public WebElement getBtnSeeReceipt() {
        waitForVisibilityOfElement(btnSeeReceipt);
        return btnSeeReceipt;
    }

    public WebElement getBtnSendMoney() {
        waitForVisibilityOfElement(btnSendMoney);
        return btnSendMoney;
    }

    public WebElement getReceivedModal() {
        waitForVisibilityOfElement(receivedModal);
        return receivedModal;
    }

    public WebElement getSentModal() {
        waitForVisibilityOfElement(sentModal);
        return sentModal;
    }

    public WebElement getTxtSatsField() {
        waitForVisibilityOfElement(txtSatsField);
        return txtSatsField;
    }

    //Can pass either the name or the code ex = Colones - CRC
    public WebElement getFIATAccountRbt(String fiatCurrency){
        return driver.findElement(By.xpath("//android.widget.RadioButton[contains(@content-desc,'"+fiatCurrency+"')]"));
    }


}
