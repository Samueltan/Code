package com.sample.basic;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Integer[] t = {1,2,3,4,5};
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(t));

        for(Integer i : list) {
            System.out.println(i);
        }
    }

}