package test.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/mvc")
public class MvcController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}