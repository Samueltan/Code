package com.tutorialspoint.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("BeansAop.xml");
        Student student = (Student) context.getBean("student");
        student.getName();
        student.getAge();
//        student.printThrowException();
    }
}