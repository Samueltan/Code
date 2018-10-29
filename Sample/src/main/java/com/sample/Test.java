package com.sample;

public class Test {

    public static void main(String[] args) {
        int i = inc(0, 1_200_0);
        System.out.println(i);
    }

    private static int inc(int i, int iter) {
        if (iter > 0)
            return inc(i + 1, iter - 1);
        else
            return i;
    }

}