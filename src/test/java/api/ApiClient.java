package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ApiClient {

    private String baseUri;

    public ApiClient(String baseUri) {
        this.baseUri = baseUri;
        RestAssured.baseURI = this.baseUri;
    }

    /**
     * Perform GET request
     * @param endpoint API endpoint (e.g., "/users")
     * @return Response object
     */
    public Response get(String endpoint) {
        RequestSpecification request = given()
                .header("Content-Type", "application/json");

        return request.get(endpoint)
                .then()
                .log().all()
                .extract().response();
    }
    public Response get(String endpoint, String bearerToken) {
        RequestSpecification request = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + bearerToken); // Add token here

        return request.get(endpoint)
                .then()
                .log().all()
                .extract().response();
    }

    /**
     * Perform POST request
     * @param endpoint API endpoint
     * @param jsonBody JSON payload as String
     * @return Response object
     */
    public Response post(String endpoint, String jsonBody) {
        RequestSpecification request = given()
                .header("Content-Type", "application/json")
                .body(jsonBody);

        return request.post(endpoint)
                .then()
                .log().all()
                .extract().response();
    }

    /**
     * Perform PUT request
     * @param endpoint API endpoint
     * @param jsonBody JSON payload as String
     * @return Response object
     */
    public Response put(String endpoint, String jsonBody) {
        RequestSpecification request = given()
                .header("Content-Type", "application/json")
                .body(jsonBody);

        return request.put(endpoint)
                .then()
                .log().all()
                .extract().response();
    }

    /**
     * Perform DELETE request
     * @param endpoint API endpoint
     * @return Response object
     */
    public Response delete(String endpoint) {
        RequestSpecification request = given()
                .header("Content-Type", "application/json");

        return request.delete(endpoint)
                .then()
                .log().all()
                .extract().response();
    }
}
