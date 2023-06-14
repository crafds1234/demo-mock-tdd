package nz.co.demo.controller;

import nz.co.demo.model.Task;
import nz.co.demo.repository.TaskRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

public class TaskControllerTest {


    private TaskController controller;
    private TaskRepository taskRepository;

    @Before
    public void setUp() throws Exception {
        taskRepository = mock(TaskRepository.class);
        controller = new TaskController(taskRepository);
    }

    @Test
    public void canAddATask() {

        // Given
        Task task = mock(Task.class);

        // When
        String actual = controller.addTask(task);

        // Then
        then(taskRepository).should().store(task);
        assertThat(actual, is(task.toString()));
    }

    @Test
    public void canFetchAllTasks() {
        List<Task> expected = asList(mock(Task.class), mock(Task.class), mock(Task.class));

        // Given
        given(taskRepository.fetchAll()).willReturn(expected);

        // When
        List<Task> actual = controller.fetchAll();

        // Then
        assertThat(actual, is(expected));
    }
}