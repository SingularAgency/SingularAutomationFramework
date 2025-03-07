package com.osmo;

import com.appium.setup.AppTestCase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SWAPTests extends AppTestCase {
    private String className = this.getClass().getSimpleName();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        initializeAppTest(className, "Android");
    }

    @Test
    public void performBTCtoQTZ(){

    }

    @Override
    protected void cleanPageObjects() {

    }
}
