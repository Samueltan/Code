package com.springboot.ch1.di;

import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;

@Service
public class FunctionService {
    public void sayHello(String message) {
        System.out.println("Hello, " + message);
    }

}
