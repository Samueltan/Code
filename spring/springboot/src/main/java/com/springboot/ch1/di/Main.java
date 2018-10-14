package com.springboot.ch1.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        FunctionController functionController = context.getBean(FunctionController.class);

        functionController.sayHello("Nicole: how are you doing?");
    }
}
