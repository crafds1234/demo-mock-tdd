package nz.co.demo.controller;


import nz.co.demo.model.Task;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(path = "/v1/tasks")
public class TaskController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public String addTask(@RequestBody Task task) {
        System.out.println(task);

        return task.toString();
    }

    

}