package com.sample.basic.java8.methodreference.staticmethod;

import java.util.ArrayList;
import java.util.List;

public class StaticMethodTest {
    public static void main(String args[]){
        List names = new ArrayList();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach(System.out::println);
    }
}