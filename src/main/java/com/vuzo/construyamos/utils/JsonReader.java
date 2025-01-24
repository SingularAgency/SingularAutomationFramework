package com.vuzo.construyamos.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.util.List;
import java.util.Map;

public class JsonReader {
    @Setter
    @Getter
    static class User {
        // Getters and Setters
        private String tag;
        private List<Map<String, String>> data;

    }

    public static Map<String, String> getCredentials(String filePath, String targetTag) {
        try {
            // Parse the JSON file
            ObjectMapper objectMapper = new ObjectMapper();
            List<User> users = objectMapper.readValue(new File(filePath), new TypeReference<List<User>>() {});

            // Find the matching tag and return the credentials
            for (User user : users) {
                if (user.getTag().equals(targetTag)) {
                    return user.getData().get(0); // Return the first entry in the data array
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Tag not found or error reading JSON");
    }
}
