package com.tutorialspoint.config.annotation;

import org.springframework.beans.factory.annotation.Autowired;

public class Profile {
    @Autowired
//    @Qualifier("student1")
    private Student student;

    public Profile() {
        System.out.println("Inside Profile constructor.");
    }

    public void printAge() {
        System.out.println("Age : " + student.getAge());
    }

    public void printName() {
        System.out.println("Name : " + student.getName());
    }
}
