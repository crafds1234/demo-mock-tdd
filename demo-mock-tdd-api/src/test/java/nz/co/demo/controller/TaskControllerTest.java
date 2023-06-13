package nz.co.demo.controller;

import nz.co.demo.model.Task;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class TaskControllerTest {


    private TaskController controller;

    @Before
    public void setUp() throws Exception {
        controller = new TaskController();
    }

    @Test
    public void canAddATask() {
        // Given
        Task task = mock(Task.class);

        // When
        String actual = controller.addTask(task);

        // Then
        assertThat(actual, is(task.toString()));
    }
}