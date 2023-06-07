package nz.co.demo.client;

import nz.co.demo.model.Task;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskClient {
    public void add(Task task) {
        throw new UnsupportedOperationException();
    }

    public List<Task> fetchAll() {
        throw new UnsupportedOperationException();
    }
}
