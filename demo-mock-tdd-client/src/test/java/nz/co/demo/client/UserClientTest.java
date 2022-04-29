package nz.co.demo.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import nz.co.demo.client.exception.UserCreationException;
import nz.co.demo.client.factory.UserRequestFactory;
import nz.co.demo.model.User;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomStrings.someString;

public class UserClientTest {

    private UserClient client;
    private UserRequestFactory userRequestFactory;
    private HttpClient httpClient;
    private ObjectMapper objectMapper;

    @Before
    public void setUp() {
        userRequestFactory = mock(UserRequestFactory.class);
        httpClient = mock(HttpClient.class);
        objectMapper = mock(ObjectMapper.class);
        client = new UserClient(userRequestFactory, httpClient, objectMapper);
    }

    @Test
    public void shouldRegisterAUser() throws IOException, InterruptedException {

        User user = mock(User.class);
        HttpRequest httpRequest = mock(HttpRequest.class);
        HttpResponse httpResponse = mock(HttpResponse.class);
        String body = someString();
        User expected = mock(User.class);

        // Given
        given(userRequestFactory.createRegisterUserRequest(user)).willReturn(httpRequest);
        given(httpClient.send(httpRequest, BodyHandlers.ofString())).willReturn(httpResponse);
        given(httpResponse.body()).willReturn(body);
        given(objectMapper.convertValue(body, User.class)).willReturn(expected);

        // When
        User actual = client.registerUser(user);

        // Then
        assertThat(actual, is(expected));
    }

    @Test(expected = UserCreationException.class)
    public void shouldFailToRegisterAUser() throws IOException, InterruptedException {

        User user = mock(User.class);
        HttpRequest httpRequest = mock(HttpRequest.class);

        // Given
        given(userRequestFactory.createRegisterUserRequest(user)).willReturn(httpRequest);
        given(httpClient.send(httpRequest, BodyHandlers.ofString())).willThrow(new IOException());

        // When
        client.registerUser(user);

    }
}