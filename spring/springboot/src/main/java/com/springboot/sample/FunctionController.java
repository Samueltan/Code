package com.springboot.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FunctionController {
    @Autowired
    FunctionService service;

    public void sayHello(String message) {
        service.sayHello(message);
    }
}
