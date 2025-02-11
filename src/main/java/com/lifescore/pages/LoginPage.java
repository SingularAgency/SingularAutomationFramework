package com.lifescore.pages;

import com.appium.setup.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

import java.util.List;

@Getter
public class LoginPage extends BasePage {
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Password']/following-sibling::android.widget.EditText")
    private WebElement txtPassword;

    @AndroidFindBy(xpath ="(//android.view.View[@content-desc='Email']/following-sibling::android.widget.EditText)[1]")
    private WebElement txtEmail;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Login\"]")
    private WebElement btnLogin;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Register\"]")
    private WebElement btnRegister;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"This field is required\"])")
    private List<WebElement> lblMandatoryFields;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Email is not valid\"]")
    private WebElement lblEmailInvalid;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"This field is required\"])")
    private WebElement lblMandatoryField;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Error\n" +
            "Email is not registered with us.\"]")
    private WebElement lblEmailNotRegistered;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Error\n" +
            "Invalid Login Credentials.\"]")
    private WebElement lblWrongPassword;

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }


}
