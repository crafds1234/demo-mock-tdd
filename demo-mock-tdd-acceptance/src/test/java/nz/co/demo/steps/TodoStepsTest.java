package nz.co.demo.steps;

import nz.co.demo.client.TaskClient;
import nz.co.demo.factory.TaskFactory;
import nz.co.demo.holder.TaskHolder;
import nz.co.demo.model.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static java.util.Arrays.asList;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

class TodoStepsTest {

    private TodoSteps steps;
    private TaskFactory taskFactory;
    private TaskHolder taskHolder;
    private TaskClient taskClient;

    @BeforeEach
    public void setUp() {
        taskFactory = mock(TaskFactory.class);
        taskHolder = mock(TaskHolder.class);
        taskClient = mock(TaskClient.class);
        steps = new TodoSteps(taskFactory, taskHolder, taskClient);
    }

    @Test
    public void canStoreATaskToGoToTheGym() {

        // Given
        Task taskToGoToTheGym = mock(Task.class);
        given(taskFactory.createTaskToGoToTheGym()).willReturn(taskToGoToTheGym);

        // When
        steps.iHaveATaskToGoToTheGym();

        // Then
        then(taskHolder).should().hold(taskToGoToTheGym);
    }

    @Test
    public void canAddATask() throws IOException, InterruptedException {

        // Given
        Task task = mock(Task.class);
        given(taskHolder.get()).willReturn(task);

        // When
        steps.iAddThatTask();

        // Then
        then(taskClient).should().add(task);
    }

    @Test
    public void canSeeMyTaskAddedToTheTodoList() throws IOException, InterruptedException {

        Task taskToGoToTheGym = mock(Task.class);

        // Given
        given(taskClient.fetchAll()).willReturn(asList(mock(Task.class), taskToGoToTheGym, mock(Task.class)));
        given(taskHolder.get()).willReturn(taskToGoToTheGym);

        // When
        steps.iShouldSeeThatTaskInMyTodoList();

        // Then
        then(taskHolder).should().get();
    }

    @Test
    public void canFailToSeeMyTaskAddedToTheTodoList() throws IOException, InterruptedException {

        Task taskToGoToTheGym = mock(Task.class);

        // Given
        given(taskClient.fetchAll()).willReturn(asList(mock(Task.class), mock(Task.class)));
        given(taskHolder.get()).willReturn(taskToGoToTheGym);

        // When
        Assertions.assertThrows(AssertionError.class, () -> steps.iShouldSeeThatTaskInMyTodoList());

        // Then
        then(taskHolder).should().get();
    }
}