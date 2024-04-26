package BKGT.AppiumFramework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RegisterPage {
	
	AndroidDriver driver;

	
	@AndroidFindBy(xpath="//android.view.View[2]/android.view.View/android.widget.EditText")
	private WebElement txtName;
	
	
	@AndroidFindBy(xpath="//android.view.View[3]/android.view.View/android.widget.EditText")
	private WebElement txtEmail;
	
	@AndroidFindBy(xpath="//android.view.View[4]/android.view.View/android.widget.EditText")
	private WebElement txtPassword;
	
	@AndroidFindBy(xpath="//android.view.View[5]/android.view.View/android.widget.EditText")
	private WebElement txtConfirmPassword;
	
	@AndroidFindBy(xpath="//android.view.View/android.widget.CheckBox[1]")
	private WebElement chkTerms;
	
	@AndroidFindBy(xpath="//android.view.View/android.widget.CheckBox[2]")
	private WebElement chkMark;
	
	@AndroidFindBy(xpath="//android.widget.Button[contains(@text,'Continuar')]")
	private WebElement btnContinue;
	
	@AndroidFindBy(xpath="//android.view.View[2]/android.view.View[1]/android.widget.EditText")
	private WebElement txtFirstDigit;
	
	@AndroidFindBy(xpath="//android.view.View[2]/android.view.View[2]/android.widget.EditText")
	private WebElement txtSecondDigit;
	
	@AndroidFindBy(xpath="//android.view.View[2]/android.view.View[3]/android.widget.EditText")
	private WebElement txtThirdDigit;
	
	@AndroidFindBy(xpath="//android.view.View[2]/android.view.View[4]/android.widget.EditText")
	private WebElement txtFourthDigit;
	
	public RegisterPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);	
		}
    public void enterName(String name) {
        txtName.sendKeys(name);
    }

    public void enterEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void enterPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        txtConfirmPassword.sendKeys(confirmPassword);
    }

    public void checkTerms() {
        chkTerms.click();
    }

    public void checkMark() {
        chkMark.click();
    }

    public void clickContinueButton() {
        btnContinue.click();
    }

    public void enterFirstDigit(String digit) {
        txtFirstDigit.sendKeys(digit);
    }

    public void enterSecondDigit(String digit) {
        txtSecondDigit.sendKeys(digit);
    }

    public void enterThirdDigit(String digit) {
        txtThirdDigit.sendKeys(digit);
    }

    public void enterFourthDigit(String digit) {
        txtFourthDigit.sendKeys(digit);
    }

}
