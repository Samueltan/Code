package com.sample.exercise;

public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "hollaolloh world";
        System.out.println(findLongestPalindrome(s));
    }

    public static String findLongestPalindrome(String s) {
        int len = s.length();
        for (int l=len; l>1; l--) {
            for (int i=0; i<len-l; i++) {
                String t = s.substring(i, l+i);
                if (isPalindrome(t)) {
                    return t;
                }
            }
        }
        return "";
    }
    public static boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        for (int i=0; i< arr.length/2; i++) {
            arr[i] = arr[arr.length - i - 1];
        }
        return s.equals(new String(arr));
    }
}
