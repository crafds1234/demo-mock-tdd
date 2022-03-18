package nz.co.demo.client;

import nz.co.demo.client.factory.DemoClientRequestFactory;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class DemoClient {

    private final HttpClient httpClient;
    private final DemoClientRequestFactory demoClientRequestFactory;

    public DemoClient(HttpClient httpClient, DemoClientRequestFactory demoClientRequestFactory) {
        this.httpClient = httpClient;
        this.demoClientRequestFactory = demoClientRequestFactory;
    }

    public String test() throws IOException, InterruptedException {
        return httpClient
                .send(demoClientRequestFactory.createDemoRequest(), HttpResponse.BodyHandlers.ofString())
                .body();
    }
}
