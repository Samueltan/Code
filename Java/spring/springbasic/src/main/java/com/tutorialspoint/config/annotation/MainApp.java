package com.tutorialspoint.config.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("BeansAnnotation.xml");

//        Student student = (Student) context.getBean("student");
//        System.out.println("Name : " + student.getName());
//        System.out.println("Age : " + student.getAge());

        Profile profile = (Profile) context.getBean("profile");
        profile.printAge();
        profile.printName();

//        TextEditor te = (TextEditor) context.getBean("textEditor");
//        te.spellCheck();
    }
}