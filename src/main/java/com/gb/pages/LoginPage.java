package com.gb.pages;

import com.appium.setup.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
@Getter
public class LoginPage extends BasePage {
    public LoginPage(AppiumDriver driver) {
        super(driver);
    }


    @AndroidFindBy(accessibility = "Login with phone number")
    private WebElement btnLoginWithPhone;

    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement txtEditBox;

    @AndroidFindBy(accessibility = "Continue")
    private WebElement btnContinue;

    @AndroidFindBy(accessibility = "Verify your identity")
    private WebElement lblVerifyIdentity;

}

