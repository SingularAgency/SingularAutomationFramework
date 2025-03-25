package com.raptor.tests;

import com.appium.setup.AppTestCase;
import org.testng.annotations.BeforeClass;

public class PullReportTests extends AppTestCase {
    private String className = this.getClass().getSimpleName();


    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        initializeAppTest(className, "Android");
    }


    @Override
    protected void cleanPageObjects() {

    }
}
