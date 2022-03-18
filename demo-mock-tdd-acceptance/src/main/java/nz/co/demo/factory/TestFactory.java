package nz.co.demo.factory;

import org.springframework.stereotype.Component;

@Component
public class TestFactory {

    public Object test() {
        return new Object();
    }
}
