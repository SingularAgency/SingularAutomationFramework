package com.osmo.test;

import api.steps.OsmoAPISteps;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class ApiTest {

    @Test
    public void verifyWallets() throws Exception {
        OsmoAPISteps osmoAPISteps = new OsmoAPISteps();
        osmoAPISteps.getWallets();
    }
}
