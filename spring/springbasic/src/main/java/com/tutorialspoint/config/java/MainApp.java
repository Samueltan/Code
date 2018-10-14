package com.tutorialspoint.config.java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ctx.start();
        HelloWorld hello = ctx.getBean(HelloWorld.class);

        hello.setMessage("Michael");
        hello.getMessage();

        HelloWorld hello2 = ctx.getBean(HelloWorld.class);
        hello2.getMessage();

        TextEditor te = ctx.getBean(TextEditor.class);
        te.spellCheck();

        ctx.stop();
    }
}
