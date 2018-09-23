package com.sample;

public class Test {
    private static boolean stopRequest;
    public static void main(String args[]) throws InterruptedException {

        int i = sum(1, 2, 3, 4, 5);
        System.out.println("i = " + i);
    }

    public static int sum(int... args) {
        int result = 0;
        for (int value : args) {
            result += value;
        }
        return result;
    }
}