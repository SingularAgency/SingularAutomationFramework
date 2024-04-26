package com.bkgt.services;


import java.io.IOException;

public class AccessTokenProvider {
    public String getAccessToken(String userName, String password) throws IOException {
        return new AccessTokenApi().getAccessToken(userName, password);
    }
}
