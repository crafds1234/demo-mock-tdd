package nz.co.demo.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import nz.co.demo.client.factory.DemoClientRequestFactory;
import nz.co.demo.model.User;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class DemoClient {

    private final HttpClient httpClient;
    private final DemoClientRequestFactory demoClientRequestFactory;
    private ObjectMapper objectMapper;

    public DemoClient(HttpClient httpClient, DemoClientRequestFactory demoClientRequestFactory, ObjectMapper objectMapper) {
        this.httpClient = httpClient;
        this.demoClientRequestFactory = demoClientRequestFactory;
        this.objectMapper = objectMapper;
    }

    public User test() throws IOException, InterruptedException {
        String body = httpClient
                .send(demoClientRequestFactory.createDemoRequest(), HttpResponse.BodyHandlers.ofString())
                .body();
        return objectMapper.convertValue(body, User.class);
    }

    public User test2() throws IOException, InterruptedException {
        String body = httpClient
                .send(demoClientRequestFactory.createDemoRequest(), HttpResponse.BodyHandlers.ofString())
                .body();
        return objectMapper.convertValue(body, User.class);
    }
}
