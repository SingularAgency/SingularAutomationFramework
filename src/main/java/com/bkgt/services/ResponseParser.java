package com.bkgt.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.mashape.unirest.http.exceptions.UnirestException;

public class ResponseParser {
	
	private String userName;
	private String password;
	private JSONArray dataOrdersArray;
	public ResponseParser(String user, String password) throws IOException, UnirestException {
		this.setUserName(user);
		this.setPassword(password);
		this.setDataArray();
	}
	
	
	public List<String> parseDetails() throws IOException, UnirestException {
		JSONArray orderDetailArray = dataOrdersArray.getJSONObject(0).getJSONArray("orderDetail");
		List<String> productDetails = new ArrayList<>();
		for (int i = 0; i < orderDetailArray.length(); i++) {
		    String productName = orderDetailArray.getJSONObject(i).getString("description").replaceAll("\n", " ");
		    productDetails.add(productName);
		}

		return productDetails;

	}

	public List<String> parseProduct() throws IOException, UnirestException {
		JSONArray orderDetailArray = dataOrdersArray.getJSONObject(0).getJSONArray("orderDetail");
		List<String> productNames = new ArrayList<>();
		for (int i = 0; i < orderDetailArray.length(); i++) {
		    String productName = orderDetailArray.getJSONObject(i).getString("productName");
		    productNames.add(productName);
		}

		return productNames;

	}

	public String parseAddress() throws IOException, UnirestException {
		JSONArray dataArray = new AddressApi().getAddress(this.getUserName(),this.getPassword());

		return dataArray.toString();

	}

    public int parseOrderID() throws IOException, UnirestException {
        JSONObject firstOrder = dataOrdersArray.getJSONObject(0);
	    return firstOrder.getInt("orderId");
    }

	
	
	public int parsePaymentMethod() throws IOException, UnirestException {
		JSONObject firstOrder = dataOrdersArray.getJSONObject(0);
		
		return firstOrder.getInt("paymentMethod");
	}
	
	
	public String parseFullAddress() throws IOException, UnirestException {
		JSONArray dataArray = new AddressApi().getAddress(this.getUserName(),this.getPassword() );
		Gson gson = new Gson();
		Data[] data = gson.fromJson(dataArray.toString(), Data[].class);
		StringBuilder concatenatedString = new StringBuilder();
		// Accessing and printing the stored data
		for (Data entry : data) {
			concatenatedString.append("Address: ").append(entry.address).append("\n");
			concatenatedString.append("ID: ").append(entry.id).append("\n");
			concatenatedString.append("User ID: ").append(entry.userId).append("\n");
			concatenatedString.append("Description: ").append(entry.description).append("\n");
			concatenatedString.append("Coordinates: [").append(entry.point.coordinates[0]).append(", ")
					.append(entry.point.coordinates[1]).append("]\n");
			concatenatedString.append("\n"); // Add a newline to separate entries
		}
		return concatenatedString.toString();

	}

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public JSONArray getDataArray() {
		return dataOrdersArray;
	}


	public void setDataArray() throws IOException, UnirestException {
		this.dataOrdersArray = new OrderHistoryApi().getOrders(this.getUserName(),this.getPassword());
	}

	static class Data {
		String address;
		int id;
		int userId;
		String description;
		Point point;
	}

	static class Point {
		double[] coordinates;
		String type;
	}

}
