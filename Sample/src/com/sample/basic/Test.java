package com.sample.basic;

public class Test {
    public static void main(String[] args) {
        int low = 0;
        int high = 3;
        System.out.println("low = " + low);

        int a1 = (low + high) >> 1;
        int a2 = (low + high) >>> 1;
        int a3 = (low + high) / 2;

        System.out.println("a1 = " + a1);
        System.out.println("a2 = " + a2);
        System.out.println("a3 = " + a3);
    }
}