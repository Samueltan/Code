package com.sample.basic.java8.methodreference.constructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class MethodRefConstructorTest {
    public static void main(String[] args) {
        // Using an anonymous class
        Supplier<List<String>> s = new Supplier() {
            public List<String> get() {
                return new ArrayList<String>();
            }
        };
        List<String> l = s.get();

        // Using a lambda expression
        Supplier<List<String>> s2 = () -> new ArrayList<String>();
        List<String> l2 = s2.get();

        // Using a method reference
        Supplier<List<String>> s3 = ArrayList::new;
        List<String> l3 = s3.get();
    }
}
