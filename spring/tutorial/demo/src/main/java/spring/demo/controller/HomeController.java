package spring.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping(value="/hi", method = RequestMethod.GET)
    @ResponseBody
    public String hi(
        @RequestParam(value="name", defaultValue = "world")
        String name
    ) {
        return String.format("Hello, %s!", name);
    }

    @RequestMapping("/greeting/{name}")
    @ResponseBody
    public String greeting(
        @PathVariable("name")
        String name
    ) {
        return String.format("Greetings from Spring Boot to %s!", name);
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
