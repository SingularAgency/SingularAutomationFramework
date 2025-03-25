package com.lifescore.pages.steps;

import com.lifescore.pages.LoginPage;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;


public class LoginPageSteps extends LoginPage {
    public LoginPageSteps(AppiumDriver driver) {
        super(driver);
    }

    public void attemptToLoginWithoutEmailAndPassword() {
        waitForVisibilityOfElement(getTxtEmail());
        cleanTextFields();
        getBtnLogin().click();
        waitForVisibilityOfAllElements(getLblMandatoryFields());
        Assert.assertEquals(2, getLblMandatoryFields().size(),"Mandatory fields must be 2");
    }

    public void attemptToLoginWithoutPassword(String email){
        waitForVisibilityOfElement(getTxtEmail());
        cleanTextFields();
        getTxtEmail().click();
        getTxtEmail().sendKeys(email);
        getBtnLogin().click();
        waitForVisibilityOfElement(getLblMandatoryField());
        Assert.assertTrue(getLblMandatoryField().isDisplayed());
    }

    public void attemptToLoginWithoutEmail(String password){
        waitForVisibilityOfElement(getTxtPassword());
        cleanTextFields();
        getTxtPassword().click();
        getTxtPassword().sendKeys(password);
        getBtnLogin().click();
        waitForVisibilityOfElement(getLblMandatoryField());
        Assert.assertTrue(getLblMandatoryField().isDisplayed());
    }

    public void failWithoutPasswordAndEmailIssue(String email) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        attemptToLoginWithoutPassword(email);
        if(email.matches(emailRegex)){
            waitForVisibilityOfElement(getLblEmailNotRegistered());
            Assert.assertTrue(getLblEmailNotRegistered().isDisplayed());
        }else{
            waitForVisibilityOfElement(getLblEmailInvalid());
            Assert.assertTrue(getLblEmailInvalid().isDisplayed());
        }
    }

    public void failLoginDueUnregisteredEmail(String email,String password){
        waitForVisibilityOfElement(getTxtEmail());
        cleanTextFields();
        getTxtEmail().click();
        getTxtEmail().sendKeys(email);
        waitForVisibilityOfElement(getTxtPassword());
        getTxtPassword().click();
        getTxtPassword().sendKeys(password);
        getBtnLogin().click();
        waitForVisibilityOfElement(getLblEmailNotRegistered());
        Assert.assertTrue(getLblEmailNotRegistered().isDisplayed());


    }

    public void failLoginDueWrongPassword(String email, String password){
        waitForVisibilityOfElement(getTxtEmail());
        cleanTextFields();
        getTxtEmail().click();
        getTxtEmail().sendKeys(email);
        waitForVisibilityOfElement(getTxtPassword());
        getTxtPassword().click();
        getTxtPassword().sendKeys(password);
        getBtnLogin().click();
        waitForVisibilityOfElement(getLblWrongPassword());
        Assert.assertTrue(getLblWrongPassword().isDisplayed());

    }

    public void cleanTextFields(){
        getTxtEmail().click();
        getTxtEmail().clear();
        getTxtPassword().click();
        getTxtPassword().clear();
    }

    public void register(){
        getBtnRegister().click();
    }

}