package nz.co.demo.steps;

import nz.co.demo.client.UserClient;
import nz.co.demo.factory.UserFactory;
import nz.co.demo.holder.UserHolder;
import nz.co.demo.model.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

public class UserCreationStepsTest {

    private UserCreationSteps steps;
    private UserFactory userFactory;
    private UserHolder userHolder;
    private UserClient userClient;
    private UserHolder createdUserHolder;

    @Before
    public void setUp() throws Exception {
        userFactory = mock(UserFactory.class);
        userHolder = mock(UserHolder.class);
        userClient = mock(UserClient.class);
        createdUserHolder = mock(UserHolder.class);
        steps = new UserCreationSteps(userFactory, userHolder, userClient, createdUserHolder);
    }

    @Test
    public void shouldHaveAValidUser() {
        User validUser = mock(User.class);

        // Given
        given(userFactory.createValidUser()).willReturn(validUser);

        // When
        steps.iHaveAValidUser();

        // Then
        then(userHolder).should().hold(validUser);
    }

    @Test
    public void shouldRegisterAUser() {

        User user = mock(User.class);
        User createdUser = mock(User.class);

        // Given
        given(userHolder.get()).willReturn(user);
        given(userClient.registerUser(user)).willReturn(createdUser);

        // When
        steps.iRegisterThatUser();

        // Then
        then(createdUserHolder).should().hold(createdUser);

    }

    @Test
    public void shouldVerifyUserIsCreated() {

        // Given
        given(createdUserHolder.get()).willReturn(mock(User.class));

        // When
        steps.theUserShouldBeRegistered();

    }

    @Test(expected = AssertionError.class)
    public void shouldFailVerifyUserIsCreated() {

        // Given
        given(createdUserHolder.get()).willReturn(null);

        // When
        steps.theUserShouldBeRegistered();
    }

}