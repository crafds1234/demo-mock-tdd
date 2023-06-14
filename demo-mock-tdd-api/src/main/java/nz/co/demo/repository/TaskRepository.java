package nz.co.demo.repository;

import nz.co.demo.model.Task;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskRepository {
    private List<Task> cache;

    public TaskRepository(List<Task> cache) {
        this.cache = cache;
    }

    public void store(Task task) {
        cache.add(task);
    }

    public List<Task> fetchAll() {
        return cache;
    }
}
