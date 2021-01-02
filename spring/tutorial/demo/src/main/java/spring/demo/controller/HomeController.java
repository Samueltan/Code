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
import spring.demo.model.Greeting;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class HomeController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/hi", method = RequestMethod.GET)
    @ResponseBody
    public String hi(
        @RequestParam(value="name", defaultValue = "world")
        String name
    ) {
        return String.format("Hello, %s!", name);
    }

    @GetMapping(value={"/greeting/{name}", "/greeting"})
    @ResponseBody
    public Greeting greeting(
        @PathVariable(required = false) String name
    ) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }
}
