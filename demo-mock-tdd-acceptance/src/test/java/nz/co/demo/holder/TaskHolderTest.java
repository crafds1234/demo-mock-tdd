package nz.co.demo.holder;

import nz.co.demo.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;

class TaskHolderTest {

    private TaskHolder holder;

    @BeforeEach
    void setUp() {
        holder = new TaskHolder();
    }

    @Test
    void CanHoldATask() {
        // Given
        Task task = mock(Task.class);
        holder.hold(task);

        // When
        Task actual = holder.get();

        // Then
        assertThat(actual, is(task));
    }
}