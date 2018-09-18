package com.sample.basic;
import java.util.*;

public class Test {
    private static int nonLeadingZeroComplement(int i) {
        int ones = (Integer.highestOneBit(i) << 1) - 1;
        return i ^ ones;
    }

    // Driver Code
    public static void main (String[] args)
    {
        int result = nonLeadingZeroComplement(50);

        System.out.println(result);
    }
}