package com.sample.exercise;

public class Complement {
    private static int nonLeadingZeroComplement(int i) {
        int ones = (Integer.highestOneBit(i) << 1) - 1;
        return i ^ ones;
    }

    // Driver Code
    public static void main (String[] args)
    {
        int i = 66;
        System.out.println("i = " + Integer.toBinaryString(i));
        Integer x = Integer.highestOneBit(i);
        System.out.println(x);
        System.out.println("highestOneBit(i) = " + Integer.toBinaryString(Integer.highestOneBit(i)));
        System.out.println("highestOneBit(i) << 1 = " + Integer.toBinaryString(Integer.highestOneBit(i) << 1));
        int ones = (Integer.highestOneBit(i) << 1) - 1;
        System.out.println("(highestOneBit(i) << 1) - 1= " + Integer.toBinaryString(ones));
        int result = i ^ ones;
        System.out.println("i ^ (highestOneBit(i) << 1) - 1= " + Integer.toBinaryString(result));
    }
}