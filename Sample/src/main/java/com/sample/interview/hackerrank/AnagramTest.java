package com.sample.interview.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                if (isAnagram3(q, d)) {
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

    public static boolean isAnagram2(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) return false;

        int[] arr1 = new int[52];
        int[] arr2 = new int[52];
        for (int i = 0; i<len1; i++) {
            char c = s1.charAt(i);
            int x = (c > 'Z') ? (c - 'a' + 26) : (c - 'A');
            arr1[x]++;
        }
        for (int i = 0; i<len2; i++) {
            char c = s2.charAt(i);
            int x = (c > 'Z') ? (c - 'a' + 26) : (c - 'A');
            arr2[x]++;
        }

        return Arrays.equals(arr1, arr2);
    }

    public static boolean isAnagram3(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) return false;

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i=0; i<len1; i++) {
            char c = s1.charAt(i);
            if (map1.containsKey(c)) {
                map1.put(c, map1.get(c) + 1);
            } else {
                map1.put(c, 1);
            }
        }
        for (int i=0; i<len2; i++) {
            char c = s2.charAt(i);
            if (map2.containsKey(c)) {
                map2.put(c, map2.get(c) + 1);
            } else {
                map2.put(c, 1);
            }
        }

        return map1.equals(map2);
    }
}
