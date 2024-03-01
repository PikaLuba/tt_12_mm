package org.example.Task1;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;


public class HttpUtils {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    public String createNewUser() throws IOException, InterruptedException {
        String uri = "https://jsonplaceholder.typicode.com/users";
        String jsonFilePath = "./files/user.json";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type","application/json")
                .POST(HttpRequest.BodyPublishers.ofFile(Paths.get(jsonFilePath)))
                .build();
        HttpResponse<String> response = CLIENT
                .send(request, HttpResponse
                        .BodyHandlers.ofString()
                        );
        return response.body();
    }

    public String updateUser(int userId) throws IOException, InterruptedException {
        String uri = "https://jsonplaceholder.typicode.com/users/" + userId;
        String jsonFilePath = "./files/user1.json";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type","application/json")
                .PUT(HttpRequest.BodyPublishers.ofFile(Paths.get(jsonFilePath)))
                .build();
        HttpResponse<String> response = CLIENT
                .send(request, HttpResponse
                        .BodyHandlers.ofString()
                );
        return response.body();
    }

    public int deleteUser(int userId) throws IOException, InterruptedException {
        String uri = "https://jsonplaceholder.typicode.com/users/" + userId;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .DELETE()
                .build();
        HttpResponse<String> response = CLIENT
                .send(request, HttpResponse
                        .BodyHandlers.ofString()
                );
        return response.statusCode();
    }

    public String getAllUser() throws IOException, InterruptedException {
        String uri = "https://jsonplaceholder.typicode.com/users";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT
                .send(request, HttpResponse
                        .BodyHandlers.ofString()
                );
        return response.body();
    }

    public String getUser(int userId) throws IOException, InterruptedException {
        String uri = "https://jsonplaceholder.typicode.com/users/" + userId;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT
                .send(request, HttpResponse
                        .BodyHandlers.ofString()
                );
        return response.body();
    }

    public String getUserName(String userName) throws IOException, InterruptedException {
        String uri = "https://jsonplaceholder.typicode.com/users?username=" + userName;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT
                .send(request, HttpResponse
                        .BodyHandlers.ofString()
                );
        return response.body();
    }
}
