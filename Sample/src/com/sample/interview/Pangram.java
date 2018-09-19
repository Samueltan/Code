package com.sample.interview;

import java.util.ArrayList;
import java.util.List;

public class Pangram {
    public static String isPangram(List<String> strings) {
        // Write your code here
        StringBuffer sb = new StringBuffer();
        for(String s : strings) {
            int[] arr = new int[26];
            int sum = 0;
            for(int i = 0; i < s.length(); i++) {
                int idx = s.charAt(i) - 'a';
                if (idx < 0 || idx > 25) {
                    continue;
                }
                if (arr[idx] == 0) {
                    arr[idx] = 1;
                    sum++;
                }
                if (sum == 26){
                    sb.append("1");
                    break;
                }
            }
            if (sum < 26) {
                sb.append("0");
            }
        }

        return sb.toString();
    }

    // Driver Code
    public static void main (String[] args)
    {
        List<String> strings = new ArrayList<>();
        strings.add("the quick brown fox jumps over the lazy dog");
        strings.add("the quick brown fox jump over the lazy dogs");
        strings.add("the fake sentence");
        strings.add("abcdefg hijklmn opq rst uvw xyz");
        String result = isPangram(strings);

        System.out.println(result);
    }
}