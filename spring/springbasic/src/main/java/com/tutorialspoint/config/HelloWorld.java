package com.tutorialspoint.config;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class HelloWorld {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void getMessage() {
        System.out.println("Your Message : " + message);
    }
}