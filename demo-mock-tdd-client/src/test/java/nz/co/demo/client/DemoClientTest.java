package nz.co.demo.client;

import nz.co.demo.client.factory.DemoClientRequestFactory;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomStrings.someString;

public class DemoClientTest {

    private DemoClient demoClient;
    private DemoClientRequestFactory demoClientRequestFactory;
    private HttpClient httpClient;

    @Before
    public void setUp() {
        httpClient = mock(HttpClient.class);
        demoClientRequestFactory = mock(DemoClientRequestFactory.class);
        demoClient = new DemoClient(httpClient, demoClientRequestFactory);
    }

    @Test
    public void shouldRequestDemo() throws IOException, InterruptedException {
        HttpRequest httpRequest = mock(HttpRequest.class);
        HttpResponse httpResponse = mock(HttpResponse.class);
        String expected = someString();

        // Given
        given(demoClientRequestFactory.createDemoRequest()).willReturn(httpRequest);
        given(httpClient.send(eq(httpRequest), eq(HttpResponse.BodyHandlers.ofString()))).willReturn(httpResponse);
        given(httpResponse.body()).willReturn(expected);

        // When
        String actual = demoClient.test();

        // Then
        assertThat(actual, is(expected));
    }
}