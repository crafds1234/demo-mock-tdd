package nz.co.demo.holder;

import nz.co.demo.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserHolder {

    private User user;

    public void hold(User user) {
        this.user = user;
    }

    public User get() {
        return user;
    }
}
