package com.sample;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {
    private static boolean stopRequest;
    public static void main(String args[]) throws InterruptedException {
        List<String> emptyImmutableList = List.of();

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