package com.osmo.pages.steps;

import com.osmo.pages.HomePage;
import com.osmo.pages.LoginPage;
import io.appium.java_client.AppiumDriver;
import com.appium.util.GmailOTPReader;
import io.appium.java_client.clipboard.HasClipboard;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class LoginSteps extends LoginPage {

    HomePage homepage;

    public LoginSteps(AppiumDriver driver) {
        super(driver);
        homepage = new HomePage(driver);
    }

    public void performLoginWithEmail(String email) throws Exception {
        waitForVisibilityOfElement(getBtnLogin());
        getBtnLogin().click();
        waitForVisibilityOfElement(getBtnAccessWithEmail());
        getBtnAccessWithEmail().click();
        waitForVisibilityOfElement(getTxtEmail());
        getTxtEmail().sendKeys(email);

        try {
            // Wait for the view to appear, then tap the 'X' or skip it
            // Or use xpath if needed
            waitForVisibilityOfElement(getBtnCloseGoogleWindow());
            if (getBtnCloseGoogleWindow().isDisplayed()) {
                getBtnCloseGoogleWindow().click();
            }
        } catch (Exception ignored) {
        }
        getBtnContinue().click();
        Thread.sleep(10000);
        GmailOTPReader reader = new GmailOTPReader();
        String otp = reader.getLatestOTP();
        Assert.assertNotNull("OTP was not found in the email inbox.", otp);
        if (otp != null) {
            ((HasClipboard) driver).setClipboardText(otp);
        } else {
            throw new RuntimeException("OTP is null. Clipboard not set.");
        }
        Thread.sleep(10000);
        getBtnPaste().click();
        try{
            waitForVisibilityOfElement(getPasskey());
            clickCenterView();
        } catch (Exception ignored){

        }
        acceptLocationService();
        waitForVisibilityOfElement(homepage.getLblForReference());
        Assert.assertTrue(homepage.getLblForReference().isDisplayed());
    }

    public boolean isLoginScreenDisplayed(){
        return getBtnLogin().isDisplayed();
    }
}
