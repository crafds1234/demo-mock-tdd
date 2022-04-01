package nz.co.demo.factory;

import nz.co.demo.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {
    public User createValidUser() {
        throw new UnsupportedOperationException();
    }
}
