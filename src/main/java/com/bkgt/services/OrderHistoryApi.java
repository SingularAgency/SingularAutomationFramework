package com.bkgt.services;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class OrderHistoryApi {
	private static final String ORDER_HISTORY_URL = "https://api-dev.bk.gt/v1/order/history";

    public JSONArray getOrders(String user, String password) throws IOException, UnirestException {
        String bearerToken = new AccessTokenProvider().getAccessToken(user, password);
        Unirest.setTimeouts(0, 0);
        HttpResponse<JsonNode> response = Unirest.get(ORDER_HISTORY_URL)
                .header("Authorization", "Bearer " + bearerToken)
                .asJson();
       
        JsonNode responseBody = response.getBody();
		JSONObject jsonResponse = responseBody.getObject();
		JSONArray dataArray = jsonResponse.getJSONArray("data");
		return dataArray;
    }
}
