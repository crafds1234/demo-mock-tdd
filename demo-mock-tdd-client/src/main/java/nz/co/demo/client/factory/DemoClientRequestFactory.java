package nz.co.demo.client.factory;

import org.springframework.stereotype.Component;

import java.net.http.HttpRequest;

@Component
public class DemoClientRequestFactory {
    public HttpRequest createDemoRequest() {
        throw new UnsupportedOperationException();
    }
}
