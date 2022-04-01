package nz.co.demo.holder;

import nz.co.demo.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserHolder {

    public void hold(User user) {
        throw new UnsupportedOperationException();
    }

    public User get() {
        throw new UnsupportedOperationException();
    }
}
