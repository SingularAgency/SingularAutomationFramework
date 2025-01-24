package com.playground;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.vuzo.construyamos.services.ConstruyamosServices;
import com.vuzo.construyamos.services.CustomerAPI;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApiTests {


    public ApiTests() throws UnirestException, IOException {
    }

    @Test
    public void getUsers() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://dev.vuzo.gt/api/usuarios")
                .asString();
        // Parse the JSON response
        JSONObject responseObject = new JSONObject(response.getBody());

        // Extract the "users" array
        JSONArray usersArray = responseObject.getJSONArray("users");

        // Create a list to store the IDs
        List<Integer> ids = new ArrayList<>();

        // Loop through the array and extract "id"
        for (int i = 0; i < usersArray.length(); i++) {
            JSONObject userObject = usersArray.getJSONObject(i);
            int id = userObject.getInt("id");
            ids.add(id);
        }

        // Print the list of IDs
        System.out.println("User IDs: " + ids);

    }
}
