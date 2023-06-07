package nz.co.demo.factory;

import nz.co.demo.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskFactory {
    public Task createTaskToGoToTheGym() {
        Task task = new Task();
        task.setName("Go to the gym");
        task.setDescription("need some gains");
        return task;
    }
}
