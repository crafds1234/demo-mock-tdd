package nz.co.demo.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.http.HttpClient;

import static org.mockito.Mockito.mock;

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