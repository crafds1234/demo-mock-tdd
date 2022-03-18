package nz.co.demo;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = AcceptanceSpringConfiguration.class)
public class CucumberSpringConfiguration {

}
