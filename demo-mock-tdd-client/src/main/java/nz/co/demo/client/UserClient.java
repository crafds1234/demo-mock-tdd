package nz.co.demo.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import nz.co.demo.client.exception.UserCreationException;
import nz.co.demo.client.factory.UserRequestFactory;
import nz.co.demo.model.User;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Component
public class UserClient {

    private final UserRequestFactory userRequestFactory;
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public UserClient(UserRequestFactory userRequestFactory, HttpClient httpClient, ObjectMapper objectMapper) {

        this.userRequestFactory = userRequestFactory;
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    public User registerUser(User user) {
        HttpRequest request = userRequestFactory.createRegisterUserRequest(user);
        try {
            HttpResponse<String> httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.convertValue(httpResponse.body(), User.class);
        } catch (IOException | InterruptedException e) {
            throw new UserCreationException();
        }
    }
}
