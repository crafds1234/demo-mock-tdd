package nz.co.demo.factory;

import nz.co.demo.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class TaskFactoryTest {

    private TaskFactory factory;

    @BeforeEach
    void setUp() {
        factory = new TaskFactory();
    }

    @Test
    void canCreateTaskToGoToTheGym() {
        // Given

        // When
        Task actual = factory.createTaskToGoToTheGym();

        // Then
        assertThat(actual.getName(), is("Go to the gym"));
        assertThat(actual.getDescription(), is("need some gains"));
    }
}