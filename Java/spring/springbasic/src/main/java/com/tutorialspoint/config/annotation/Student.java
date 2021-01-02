package com.tutorialspoint.config.annotation;

import org.springframework.beans.factory.annotation.Required;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Student {
    private Integer age;
    private String name;

    @Required
    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    @Required
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

//    @PostConstruct
//    public void init() {
//        System.out.println("Bean is going through init.");
//    }
//
//    @PreDestroy
//    public void destroy() {
//        System.out.println("Bean will destroy now.");
//    }
}