package com.sample.exercise;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        // you can write to stdout for debugging purposes, e.g.
        // System.out.println("this is a debug message");
        int[] arr = {2, 7, -5, -9, 6, -3, 2, -8};
        rearrange(arr);
    }

    public static void rearrange(int[] arr) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for(int i=0;i<arr.length; i++) {
            if(arr[i] < 0) {
                l1.add(arr[i]);
            } else {
                l2.add(arr[i]);
            }
        }

        l1.addAll(l2);

         l1.forEach(System.out::println);
    }


    // /** You can write unit tests here if you want! **/
    // public static class Tests {
    //     @Test
    //     public void sampleTest() {
    //         Assert.assertEquals((1+2), 3);
    //         new Solution().main();
    //     }
    // }
}