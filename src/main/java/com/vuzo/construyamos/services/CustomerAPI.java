package com.vuzo.construyamos.services;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.Getter;
import org.json.JSONArray;
import org.json.JSONObject;


public class CustomerAPI {

    private static final String CUSTOMER_URL ="https://dev.vuzo.gt/api/customers";
    @Getter
    private int customerID;
    @Getter
    private int lastResponse;
    @Getter
    private String customerName;




    public void createCustomer(String name, String email, String phone, String address, String dpi, String territory) throws UnirestException {
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("name", name);
        jsonBody.put("email", email);
        jsonBody.put("phone", phone);
        jsonBody.put("address", address);
        jsonBody.put("dpi", dpi);
        jsonBody.put("territory_id", territory);

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post(CUSTOMER_URL)
                .header("Content-Type", "application/json")
                .body(jsonBody.toString())
                .asString();

        // Parse the response body to extract the ID
        JSONObject responseObject = new JSONObject(response.getBody());
        JSONObject customerObject = responseObject.getJSONObject("customer");
        customerID = customerObject.getInt("id");

        lastResponse = response.getStatus();
        customerName = customerObject.getString("name");

    }

    public int getLastCustomerID() throws UnirestException {
        Unirest.setTimeouts(0,0);
        HttpResponse<String> response = Unirest.get(CUSTOMER_URL).asString();
        // Parse the response as a JSON array
        JSONArray customersArray = new JSONArray(response.getBody());

        // Get the last object in the array
        JSONObject lastCustomer = customersArray.getJSONObject(customersArray.length() - 1);
        customerName = lastCustomer.getString("name");

        // Extract the id
        return lastCustomer.getInt("id");

    }



    public void deleteCustomer(int id) throws UnirestException {
        Unirest.setTimeouts(0,0);
        HttpResponse<String> response = Unirest.delete(CUSTOMER_URL+"/"+id).asString();
        lastResponse = response.getStatus();


    }

}
