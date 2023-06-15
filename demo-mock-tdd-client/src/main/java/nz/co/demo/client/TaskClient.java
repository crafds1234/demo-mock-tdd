package nz.co.demo.client;

import org.springframework.stereotype.Component;

@Component
public class TaskClient {
//    private final HttpClient httpClient;
//    private final ObjectMapper objectMapper;
//    private final String hostname;
//    private final int port;
//
//    public TaskClient(HttpClient httpClient,
//                      ObjectMapper objectMapper,
//                      @Value("${task.hostname:localhost}") String hostname,
//                      @Value("${task.port}") int port ) {
//        this.httpClient = httpClient;
//        this.objectMapper = objectMapper;
//        this.hostname = hostname;
//        this.port = port;
//    }
//
//    public void add(Task task) throws IOException, InterruptedException {
//        HttpRequest.BodyPublisher payload = HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(task));
//        URI endpoint = URI.create(String.format("http://%s:%d/v1/tasks", hostname, port));
//        HttpRequest httpRequest = HttpRequest.newBuilder()
//                .POST(payload)
//                .setHeader("Content-Type", "application/json")
//                .uri(endpoint)
//                .build();
//        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
//        if(response.statusCode() != 201)
//        {
//            throw new RuntimeException(response.body());
//        }
//    }
//
//    public List<Task> fetchAll() throws IOException, InterruptedException {
//        URI endpoint = URI.create(String.format("http://%s:%d/v1/tasks", hostname, port));
//        HttpRequest httpRequest = HttpRequest.newBuilder()
//                .GET()
//                .setHeader("Content-Type", "application/json")
//                .uri(endpoint)
//                .build();
//        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
//        if(response.statusCode() != 200)
//        {
//            throw new RuntimeException(response.body());
//        }
//        return objectMapper.readValue(response.body(), new TypeReference<List<Task>>() {});
//    }
}
