package nz.co.demo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.co.demo.factory.TestFactory;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DemoSteps {

    private Random random;
    private final TestFactory testFactory;

    public DemoSteps(Random random, TestFactory testFactory) {
        this.random = random;
        this.testFactory = testFactory;
    }

    @Given("today is Sunday")
    public void todayIsSunday() {
        testFactory.test();
    }

    @When("I ask whether it's Friday yet")
    public void iAskWhetherItSFridayYet() {

    }

    @Then("I should be told {string}")
    public void iShouldBeTold(String yeahNah) {
        System.out.println("" + random.nextBoolean());
        assertThat(Boolean.TRUE, is(Boolean.FALSE));
    }
}
