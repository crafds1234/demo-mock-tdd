package nz.co.demo;

import nz.co.demo.factory.TestFactory;
import nz.co.demo.steps.DemoSteps;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class DemoStepsTest {

    private DemoSteps demoSteps;
    private TestFactory testFactory;

    @Before
    public void setUp() {
        Random random = mock(Random.class);
        testFactory = mock(TestFactory.class);
        demoSteps = new DemoSteps(random, testFactory);
    }

    @Test
    public void name() {
        given(testFactory.test()).willReturn(mock(Object.class));
        testFactory.test();
        assertTrue(true);
    }
}