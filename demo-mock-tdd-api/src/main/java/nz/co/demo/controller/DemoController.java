package nz.co.demo.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "/demo")
public class DemoController {

    private String test;

    public DemoController(@Value("${test.value}") String test) {
        this.test = test;
    }

    @GetMapping(path = "/hello")
    public String helloWorld() {
        return "Hello world " + test;
    }

    @GetMapping("/")
    public String helloWorld2() {
        return "Hello world";
    }
}
