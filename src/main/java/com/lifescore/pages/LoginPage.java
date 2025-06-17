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

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Password']/following-sibling::android.widget.EditText")
    private List<WebElement> txtPasswords;

    @AndroidFindBy(accessibility = "Continue")
    private WebElement btnContinue;

    @AndroidFindBy(accessibility = "Get Started")
    private WebElement btnGetStarted;

    @AndroidFindBy(accessibility = "Next")
    private  WebElement btnNext;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement txtInput;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private List<WebElement> txtInputs;

    @AndroidFindBy(xpath = "//android.widget.Button")
    private List<WebElement> selectOptions;

    @AndroidFindBy(accessibility = "Account Set Up Background Info")
    private  WebElement lblSetUpBackgroundInfo;

    @AndroidFindBy(accessibility = "Select")
    private  WebElement select;

    @AndroidFindBy(accessibility = "Start")
    private  WebElement btnStart;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Date of Birth\n" +
            "Biological Sex\n" +
            "Sexual Orientation\n" +
            "Race\"]//android.view.View)[1]")
    private WebElement btnDOB;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Select date\")]/android.view.View/android.widget.Button")
    private WebElement editDOB;
    @AndroidFindBy(accessibility = "Choose Date")
    private  WebElement btnChooseDate;
    @AndroidFindBy(xpath = "//android.widget.RadioButton")
    private  WebElement rbt;
    @AndroidFindBy(xpath = "(//android.widget.Button[@content-desc=\"Select\"])[1]")
    private  WebElement selectSexualOrientation;

    @AndroidFindBy(xpath = "(//android.widget.Button[@content-desc=\"Select\"])[2]")
    private WebElement selectRace;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Heterosexual\"]")
    private WebElement btnHetero;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Hispanic/Latino\"]")
    private WebElement btnHispanic;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Select\"]")
    private List<WebElement> selects;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Dismiss\"]/android.view.View/android.view.View/android.view.View")
    private List<WebElement> selectsOptions;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"No\"]/preceding-sibling::android.widget.RadioButton)[2]")
    private WebElement rbtNo;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Congrats, You just earned\")]")
    private WebElement modalPoints;

    @AndroidFindBy(accessibility = "Continue to Assessment")
    private WebElement btnContinueToAssesment;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"?\")]/following-sibling::android.view.View")
    private List<WebElement> btnAnswers;
    @AndroidFindBy(accessibility = "Demographics")
    private WebElement lblDemographics;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Very OK\"]")
    private WebElement btnVeryOk;

    @AndroidFindBy(accessibility = "Nutrition")
    private  WebElement lblNutrition;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Very Often\"]")
    private  WebElement veryOftenBtn;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"All water/water based all the time\"]")
    private WebElement allWaterBtn;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"0 to 2\"]")
    private WebElement zeroToTwo;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Never\"]")
    private WebElement btnNever;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"None\"]")
    private WebElement btnNone;
    public LoginPage(AppiumDriver driver) {
        super(driver);
    }


}
