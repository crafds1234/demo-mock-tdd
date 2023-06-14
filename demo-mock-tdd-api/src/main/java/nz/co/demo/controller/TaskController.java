package nz.co.demo.controller;


import nz.co.demo.model.Task;
import nz.co.demo.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path = "/v1/tasks")
public class TaskController {

    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public String addTask(@RequestBody Task task) {
        System.out.println(task);
        taskRepository.store(task);
        return task.toString();
    }

    @GetMapping
    public List<Task> fetchAll() {
        return taskRepository.fetchAll();
    }
}