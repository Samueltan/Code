package com.sample.interview.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramTest {
    public static void main(String[] args) {
        List<String> d = Arrays.asList("hack", "a", "rank", "khac", "ackh", "kran", "rankhacker", "a", "ab", "ba", "stairs", "raits");
        List<String> q = Arrays.asList("a", "nark", "bs", "hack", "stair");

        List<Integer> res = stringAnagram(d, q);
        System.out.println(res);
    }

    public static List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        int len = query.size();
        for(int i=0; i<len; i++) {
            list.add(0);
        }

        for(int i=0; i< len; i++) {
            String q = query.get(i);
            for(String d : dictionary) {
                if (isAnagram(q, d)) {
                    if (list.get(i) != 0) {
                        list.set(i, list.get(i) + 1);
                    } else {
                        list.set(i, 1);
                    }
                } else {
                    continue;
                }
            }
        }

        System.out.println(list);

        return list;
    }

    public static boolean isAnagram(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) return false;

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return new String(arr1).equals(new String(arr2));
    }

}
