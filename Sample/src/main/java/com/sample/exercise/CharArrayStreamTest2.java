package com.sample.exercise;

import java.util.Arrays;

public class CharArrayStreamTest2 {
    public static void main(String[] args) {
        int n = 15;

        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = i + 1;
        }

        String[] res = Arrays.stream(a).mapToObj(c -> {
            if (c % 3 == 0) {
                if (c % 15 == 0) {
                    return "x15";
                } else {
                    return "x3";
                }
            } else if (c % 5 == 0 ) {
                return "x5";
            } else {
                return String.valueOf(c);
            }
        }).toArray(String[]::new);

        for(String e : res) {
            System.out.println(e);
        }
    }
}
