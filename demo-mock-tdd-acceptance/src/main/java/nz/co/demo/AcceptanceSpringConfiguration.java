package nz.co.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
@ComponentScan("nz.co.*")
public class AcceptanceSpringConfiguration {

    @Bean
    public Random random()
    {
        return new Random();
    }
}
