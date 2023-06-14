package nz.co.demo.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.co.demo.client.TaskClient;
import nz.co.demo.factory.TaskFactory;
import nz.co.demo.holder.TaskHolder;
import nz.co.demo.model.Task;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItem;

public class TodoSteps {
    private final TaskFactory taskFactory;
    private final TaskHolder taskHolder;
    private TaskClient taskClient;

    public TodoSteps(TaskFactory taskFactory, TaskHolder taskHolder, TaskClient taskClient) {
        this.taskFactory = taskFactory;
        this.taskHolder = taskHolder;
        this.taskClient = taskClient;
    }

    @Given("I have a task to go to the gym")
    public void iHaveATaskToGoToTheGym() {
        taskHolder.hold(taskFactory.createTaskToGoToTheGym());
    }

    @When("I add that task")
    public void iAddThatTask() throws IOException, InterruptedException {
        taskClient.add(taskHolder.get());
    }

    @Then("I should see that task in my todo list")
    public void iShouldSeeThatTaskInMyTodoList() throws IOException, InterruptedException {
        List<Task> tasks = taskClient.fetchAll();
        assertThat(tasks, hasItem(taskHolder.get()));
    }
}
