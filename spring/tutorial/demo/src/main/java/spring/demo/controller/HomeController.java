package spring.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping(value="/hi", method = RequestMethod.GET)
    @ResponseBody
    public String hi() {
        return "Hello, Spring Boot!";
    }

    @RequestMapping("/greeting")
    @ResponseBody
    public String greeting() {
        return "Greetings from Spring Boot!";
    }

//    @GetMapping("/home")
//    public String home() {
//        return "home";
//    }
//
//    @GetMapping("/hello")
//    public String hello() {
//        return "hello";
//    }
}
