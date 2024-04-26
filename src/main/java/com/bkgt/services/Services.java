package com.bkgt.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Services {

	    private ResponseParser parser;
	    private AddressApi addressApi;
	    public CoreApi core;
	    public Map<String, Object> responseMap = new HashMap<>();
	    public String user,password;
	    public Services(String user, String password) throws IOException, UnirestException {
	    	this.addressApi = new AddressApi();
	    	this.user=user;
	    	this.password=password;
	    	this.core = new CoreApi();
	        this.parser = new ResponseParser(user,password);
	    }

	    public List<String> getOrderDescription() throws IOException, UnirestException {
	        return parser.parseDetails();
	    }
	    
	    public List<String> getProducto() throws IOException, UnirestException {
	    	return parser.parseProduct();
	    }

	    public int getLastOrderId() throws IOException, UnirestException {
	        return parser.parseOrderID();
	    }
	    
	    public HashMap<String,String> getProductAndDescription() throws IOException, UnirestException{
	        HashMap<String,String> mapProducts = new HashMap<>();
	        for (int i = 0; i < getProducto().size(); i++) {
	            String key = getProducto().get(i);
	            String value = getOrderDescription().get(i);
	            mapProducts.put(key, value);
	        }

	        return mapProducts;

	    }
	    
	    public String getAddress() throws IOException, UnirestException {
	    	return parser.parseAddress();
	    }
	    
	    public String getPaymentMethod() throws IOException, UnirestException {
	    	int result =parser.parsePaymentMethod();
	    	return (result==1) ? "Efectivo" : "Tarjeta";
	    }
	    
	    
	    public String printApiAddress() throws IOException, UnirestException {
	    	return parser.parseFullAddress();
	    }
	    
	    public void addNewAddress() throws UnirestException, IOException {
	    	addressApi.addAddress(this.user,this.password);
	    }
	   

    public void setResponseMap() throws UnirestException, IOException {
        int id = getLastOrderId();

        JSONArray responseBody =core.getCoreRespone(id);
        
        for (int i = 0; i < responseBody.length(); i++) {
            JSONObject jsonObject = responseBody.getJSONObject(i);
            for (String key : jsonObject.keySet()) {
            	responseMap.put(key, jsonObject.get(key));
            }
        }

     
    }
    
    public void getAmountValues() {
    	   String jsonString = responseMap.get("detalle").toString();
           JSONArray jsonArray = new JSONArray(jsonString);

           for (int i = 0; i < jsonArray.length(); i++) {
               JSONObject jsonObject = jsonArray.getJSONObject(i);
               String descripcion = jsonObject.getString("descripcion");
               double montoValue = jsonObject.getDouble("monto");
               System.out.println("Modificador/Complemento: " + descripcion + ", Monto: " + montoValue);
           }
    }
    
    public List<Integer> getAddressIds() throws IOException, UnirestException {
    	String jsonString = getAddress();
    	 Gson gson = new Gson();
         JsonArray jsonArray = gson.fromJson(jsonString, JsonArray.class);

         List<Integer> idList = new ArrayList<>();

         for (JsonElement element : jsonArray) {
             JsonObject jsonObject = element.getAsJsonObject();
             int id = jsonObject.get("id").getAsInt();
             idList.add(id);
         }
         return idList;
         // Printing the list of ID
    	
    }
    
    public int deleteAddress() throws IOException, UnirestException {
    	List<Integer> list = getAddressIds();
    	 String bearerToken = new AccessTokenProvider().getAccessToken(user, password);
    	
    	for(Integer id:list) {
    		Unirest.setTimeouts(0, 0);
    		Unirest.delete("https://api-dev.bk.gt/v1/client/address/"+id)
    		  .header("Authorization", "Bearer "+bearerToken).asString();

    	}

    	return list.size();
    }
    
    
    
    public double getTotalCoreAmount() {
        double totalMontoSum = 0.0;
 	   String jsonString = responseMap.get("detalle").toString();
       JSONArray jsonArray = new JSONArray(jsonString);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            double montoValue = jsonObject.getDouble("monto");
            totalMontoSum += montoValue;
        }
    	return totalMontoSum;
    }
    
    
}
