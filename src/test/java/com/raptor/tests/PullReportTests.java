package com.raptor.tests;

import com.appium.setup.AppTestCase;
import com.appium.util.ConfigKey;
import com.raptor.pages.PullReport;
import com.raptor.pages.Reports;
import com.raptor.pages.steps.ReportSteps;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class PullReportTests extends AppTestCase {
    private String className = this.getClass().getSimpleName();

    ReportSteps reportSteps;
    PullReport pullReport;
    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        initializeAppTest(className, "Android");
    }

    @BeforeMethod
    public void initializePageObjects() throws IOException {
        AndroidDriver driver = (AndroidDriver) AppTestCase.getActionDriver().getAppiumDriver();
        reportSteps = new ReportSteps(driver);
        pullReport = new PullReport(driver);
        Runtime.getRuntime().exec("/Users/cruyfj/Library/Android/sdk/platform-tools/adb pm clear "+ ConfigKey.MAIN_ACTIVITY);
        Runtime.getRuntime().exec("/Users/cruyfj/Library/Android/sdk/platform-tools/adb shell am start -n "+ ConfigKey.MAIN_ACTIVITY);

    }

    @Test
    public void TC01_NaviageteToReports(){
        reportSteps.createNewEmptyReport();
        common.log(pullReport.getBtnGeneralDetails().getDomAttribute("content-desc"));
    }


    @Override
    protected void cleanPageObjects() {

    }
}
