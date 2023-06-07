package nz.co.demo.holder;

import nz.co.demo.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskHolder {
    private Task task;

    public void hold(Task task) {
        this.task = task;
    }

    public Task get() {
        return task;
    }
}
