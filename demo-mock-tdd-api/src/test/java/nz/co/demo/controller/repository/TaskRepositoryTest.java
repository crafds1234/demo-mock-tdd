package nz.co.demo.controller.repository;

import nz.co.demo.model.Task;
import nz.co.demo.repository.TaskRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

public class TaskRepositoryTest {

    private TaskRepository repository;
    private List<Task> cache;

    @Before
    public void setUp() throws Exception {
        cache = mock(List.class);
        repository = new TaskRepository(cache);
    }

    @Test
    public void canStoreATask() {
        // Given
        Task task = mock(Task.class);

        // When
        repository.store(task);

        // Then
        then(cache).should().add(task);
    }

    @Test
    public void canFetchAllTasks() {

        // Given

        // When
        List<Task> actual = repository.fetchAll();

        // Then
        assertThat(actual, is(cache));
    }
}