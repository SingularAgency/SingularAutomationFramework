package com.bkgt.services;

import org.json.JSONArray;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class CoreApi {

	public JSONArray getCoreRespone(int id) throws UnirestException {
		 Unirest.setTimeouts(0, 0);
	        JSONArray responseBody = Unirest.post("http://190.113.88.135:4001/api2023/consulta")
	                .header("KEY", "J0#N<@nn0n@Gch23")
	                .header("FV", "APP")
	                .header("Content-Type", "application/json")
	                .body("{\n    \"forma_venta\":\"APP\",\n    \"orden\":\"" + id + "\"\n\n}")
	                .asJson()
	                .getBody()
	                .getArray();
	        
	      return responseBody;
	}
}
