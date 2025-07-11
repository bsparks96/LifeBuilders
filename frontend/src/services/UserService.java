package services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class UserService {

    private static final String API_URL = "http://localhost:8000/api/users";

    public static Map<String, Integer> fetchAllUsers() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Failed to fetch users: HTTP " + response.statusCode());
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode userArray = mapper.readTree(response.body());

        Map<String, Integer> nameToIdMap = new HashMap<>();

        for (JsonNode user : userArray) {
            int userID = user.get("userID").asInt();
            String firstName = user.get("firstName").asText();
            String lastName = user.get("lastName").asText();
            String fullName = firstName + " " + lastName;
            nameToIdMap.put(fullName, userID);
        }

        return nameToIdMap;
    }
}
