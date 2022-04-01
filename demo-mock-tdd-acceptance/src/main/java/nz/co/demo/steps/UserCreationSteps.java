package nz.co.demo.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.co.demo.client.UserClient;
import nz.co.demo.factory.UserFactory;
import nz.co.demo.holder.UserHolder;
import nz.co.demo.model.User;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserCreationSteps {

    private UserFactory userFactory;
    private UserHolder userHolder;
    private final UserClient userClient;
    private final UserHolder createdUserHolder;

    public UserCreationSteps(UserFactory userFactory,
                             UserHolder userHolder,
                             UserClient userClient,
                             UserHolder createdUserHolder) {
        this.userFactory = userFactory;
        this.userHolder = userHolder;
        this.userClient = userClient;
        this.createdUserHolder = createdUserHolder;
    }

    @Given("I have a valid user")
    public void iHaveAValidUser() {
        userHolder.hold(userFactory.createValidUser());
    }

    @When("I register that user")
    public void iRegisterThatUser() {
        User createdUser = userClient.registerUser(userHolder.get());
        createdUserHolder.hold(createdUser);
    }

    @Then("The user should be registered")
    public void theUserShouldBeRegistered() {
        assertThat(createdUserHolder.get(), is(notNullValue()));
    }
}