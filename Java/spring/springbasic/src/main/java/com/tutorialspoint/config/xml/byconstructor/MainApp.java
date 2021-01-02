package com.tutorialspoint.config.xml.byconstructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("BeansXmlByConstructor.xml");
        TextEditor te = (TextEditor)context.getBean("textEditor");
        te.spellCheck();
    }
}
