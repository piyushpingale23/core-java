package com.core.java.java_11.http_client_api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class AsyncHttpClientExample {

    public static void main(String[] args) {

        // 1. Create an HTTP client
        HttpClient client = HttpClient.newHttpClient();

        // 2. Build an HTTP GET request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://dummyjson.com/products"))
                .GET()
                .build();

        // 3. Send the request asynchronously
        CompletableFuture<HttpResponse<String>> futureResponse = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        // 4. Process the response when it becomes available
        futureResponse
                .thenAccept(response -> {
                    System.out.println("Status Code: " + response.statusCode());
                    System.out.println("Response Body:");
                    System.out.println(response.body());
                })
                .exceptionally(exception -> {
                    System.err.println("HTTP request failed: " + exception.getMessage());
                    return null;
                })
                .join(); // Wait for the processing chain to complete
    }
}

