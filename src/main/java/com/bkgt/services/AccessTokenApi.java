package com.bkgt.services;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

public class AccessTokenApi {
	
	private static final String ACCESS_TOKEN_API_URL = "https://auth-dev.bk.gt/realms/master/protocol/openid-connect/token";
    private static final String CLIENT_SECRET = "EEosFuNl0rRhvxzRr1Azq0mte9NxbJWP";

    @SuppressWarnings("deprecation")
	public String getAccessToken(String userName, String password) throws IOException {
        String urlParameters = generateGetAccessTokenParameters(userName, password);
        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);

        HttpURLConnection con = configureHttpConnection(new URL(ACCESS_TOKEN_API_URL), "POST");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        con.setRequestProperty("Content-Length", Integer.toString(postData.length));

        try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
            wr.write(postData);
        }

        int responseCode = con.getResponseCode();
        if (responseCode == 200) {
            try (InputStream inputStr = con.getInputStream()) {
                String jsonResponse = IOUtils.toString(inputStr);
                JSONObject jsonObject = new JSONObject(jsonResponse);
                return jsonObject.getString("access_token");
            }
        } else {
            throw new IOException("Failed to obtain access token. HTTP response code: " + responseCode);
        }
    }

    private HttpURLConnection configureHttpConnection(URL url, String method) throws IOException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoOutput(true);
        con.setInstanceFollowRedirects(false);
        con.setRequestMethod(method);
        con.setRequestProperty("charset", "utf-8");
        con.setUseCaches(false);
        return con;
    }
    
	private static String generateGetAccessTokenParameters(String userName, String password) {
		return "grant_type=password&client_id=admin-cli&username=" + userName + "&password=" + password
				+ "&client_secret=" + CLIENT_SECRET + "&scope=openid";
	}
}
