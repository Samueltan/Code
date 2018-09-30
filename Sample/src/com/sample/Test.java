package com.sample;

public class Test {
    Runnable r1 = () -> { System.out.println(this); };
    Runnable r2 = () -> { System.out.println(toString()); };

    public String toString() {  return "Hello, world"; }

    public static void main(String... args) {
        new Test().r1.run();
        new Test().r2.run();
    }
}