package nz.co.demo;

import nz.co.demo.model.Task;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DemoConfiguration {

    @Bean
    public List<Task> tasks() {
        return new ArrayList<>();
    }
}
