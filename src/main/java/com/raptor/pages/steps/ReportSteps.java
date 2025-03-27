package com.raptor.pages.steps;

import com.appium.util.CommonUtil;
import com.appium.util.WaitHelpers;
import com.raptor.pages.PullReport;
import com.raptor.pages.Reports;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import org.testng.asserts.Assertion;


public class ReportSteps {

    PullReport pullReport;
    Reports report;

    public ReportSteps(AppiumDriver driver){
        pullReport = new PullReport(driver);
        report = new Reports(driver);
    }

    public void createNewEmptyReport(){
        report.getBtnReports().click();
        report.getBtnCreate().click();
        WaitHelpers.waitForElementPresent(pullReport.getBtnGeneralDetails());
        Assert.assertTrue(pullReport.getBtnGeneralDetails().isDisplayed());
        Assert.assertTrue(pullReport.getBtnGeneralDetails().getDomAttribute("content-desc").contains("Not started"));
    }


}
