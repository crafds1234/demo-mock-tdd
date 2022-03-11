package nz.co.demo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DemoSteps {

    @Given("today is Sunday")
    public void todayIsSunday() {

    }

    @When("I ask whether it's Friday yet")
    public void iAskWhetherItSFridayYet() {

    }

    @Then("I should be told {string}")
    public void iShouldBeTold(String yeahNah) {
        assertThat(Boolean.TRUE, is(Boolean.FALSE));
    }
}
