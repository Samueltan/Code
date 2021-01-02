package com.springboot.ch2.lifecycle;

import org.springframework.stereotype.Component;

//@Component
public class BeanWayService {
    public void init() {
        System.out.println("Bean init()");
    }

    public BeanWayService() {
        System.out.println("new BeanWayService constructor!");
    }

    public void destroy() {
        System.out.println("Bean destroy()");
    }
}
