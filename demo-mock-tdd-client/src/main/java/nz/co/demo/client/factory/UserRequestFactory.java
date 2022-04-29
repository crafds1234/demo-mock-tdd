package nz.co.demo.client.factory;

import nz.co.demo.model.User;
import org.springframework.stereotype.Component;

import java.net.http.HttpRequest;

@Component
public class UserRequestFactory {
    public HttpRequest createRegisterUserRequest(User user) {
        throw new UnsupportedOperationException();
    }
}
