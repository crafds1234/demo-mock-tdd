package nz.co.demo.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import nz.co.demo.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomStrings.someAlphaString;

public class TaskClientTest {

    private TaskClient taskClient;
    private HttpClient httpClient;
    private ObjectMapper objectMapper;

    @Before
    public void setUp() {
        httpClient = mock(HttpClient.class);
        objectMapper = mock(ObjectMapper.class);
        taskClient = new TaskClient(httpClient, objectMapper, "ahost", 123123);
    }

    @Test
    public void canAddATask() throws IOException, InterruptedException {

        //need to think how to test this easly. i dun like powermock
    }

}