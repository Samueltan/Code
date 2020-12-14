package spring.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String hello() {
        return "Hello, Spring Boot!";
    }

    @RequestMapping("/greeting")
    public String greeting() {
        return "Greetings from Spring Boot!";
    }
}
