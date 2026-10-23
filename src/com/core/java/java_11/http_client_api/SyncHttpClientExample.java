package com.core.java.java_11.http_client_api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SyncHttpClientExample {

    public static void main(String[] args) {

        // 1. Create an HTTP client
        HttpClient client = HttpClient.newHttpClient();

        // 2. Build an HTTP GET request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://dummyjson.com/products"))
                .GET()
                .build();

        try {
            // 3. Send the request and receive the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 4. Print response details
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body:");
            System.out.println(response.body());

        } catch (IOException e) {
            // Handles network or response-reading errors
            System.err.println("HTTP request failed: " + e.getMessage());

        } catch (InterruptedException e) {
            // Restore the interrupted status of the current thread
            Thread.currentThread().interrupt();
            System.err.println("HTTP request was interrupted.");
        }
    }
}

