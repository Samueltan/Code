package com.sample.basic.reflection;

import java.lang.reflect.Method;

class MethodInvokeTest {

    public static void main(String[] args) throws Exception {
        String str = "hello";
        Method m = Class.forName("java.lang.String").getMethod("toUpperCase");
        System.out.println(m.invoke(str));  // HELLO
    }
}