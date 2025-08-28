package com.osmo.pages.steps;

import com.osmo.pages.TransferirPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.clipboard.HasClipboard;
import org.testng.Assert;

import java.util.Objects;

public class TransferirPageSteps extends TransferirPage {
    public TransferirPageSteps(AppiumDriver driver) {
        super(driver);
    }

    public void sentBTCToLightning(String lightningAddress, String amount, String coin){
        getBtnSend().click();
        getBtnSendBTC().click();
        getTxtAddress().click();
        ((HasClipboard) driver).setClipboardText(lightningAddress);
        getBtnPasteAddress().click();
        getBtnContinue().click();
        getTxtSatsField().sendKeys(amount);
        getBtnNext().click();
        String amountToBeSent = Objects.requireNonNull(getLblTotalSats().getDomAttribute("content-desc")).replaceAll("[^0-9]", "");;
        Assert.assertEquals(amountToBeSent, amount);
        getBtnSendMoney().click();
        getBtnContinue().click();
        Assert.assertTrue(getSentModal().isDisplayed());
    }
}
