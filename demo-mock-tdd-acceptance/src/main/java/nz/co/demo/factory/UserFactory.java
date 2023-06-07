package nz.co.demo.factory;

import nz.co.demo.model.User;
import org.springframework.stereotype.Component;

import static shiver.me.timbers.data.random.RandomStrings.someAlphaString;

@Component
public class UserFactory {
    public User createValidUser() {
        User user = new User();

        user.setFirstName(someAlphaString(10));
        user.setLastName(someAlphaString(10));

        return user;
    }
}
