package com.bkgt.services;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class AddressApi {

	
	private static final String URL ="https://api-dev.bk.gt/v1/client/address";
	
	

    public JSONArray getAddress(String user, String password) throws IOException, UnirestException {
        String bearerToken = new AccessTokenProvider().getAccessToken(user, password);
        Unirest.setTimeouts(0, 0);
        HttpResponse<JsonNode> response = Unirest.get(URL)
                .header("Authorization", "Bearer " + bearerToken)
                .asJson();
       
        JsonNode responseBody = response.getBody();
		JSONObject jsonResponse = responseBody.getObject();
		JSONArray dataArray = jsonResponse.getJSONArray("data");
		return dataArray;
    }
    
    public void addAddress(String user, String password) throws UnirestException, IOException {
        String bearerToken = new AccessTokenProvider().getAccessToken(user, password);

    	Unirest.setTimeouts(0, 0);
    	Unirest.post("https://api-dev.bk.gt/v1/geolocation")
    	  .header("Content-Type", "application/json")
    	  .header("Authorization", "Bearer " + bearerToken)
    	  .body("{\"address\":\"Salida a Avenida 14 5A Calle 5-17, Zona 6, Ciudad de Guatemala, Ciudad de Guatemala. Observaciones: Desde Appium\",\"description\":\"Casa Test\",\"latitude\":14.6496064,\"longitude\":-90.4892139}")
    	  .asString();

    }

}
