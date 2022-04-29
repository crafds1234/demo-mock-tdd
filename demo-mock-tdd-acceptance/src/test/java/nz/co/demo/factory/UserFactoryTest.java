package nz.co.demo.factory;

import nz.co.demo.model.User;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class UserFactoryTest {

    private UserFactory factory;

    @Before
    public void setUp() {
        factory = new UserFactory();
    }

    @Test
    public void shouldCreateAValidUser() {

        // When
        User actual = factory.createValidUser();

        // Then
        assertThat(actual.getFirstName(), is(notNullValue()));
        assertThat(actual.getLastName(), is(notNullValue()));

    }
}