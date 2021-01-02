package com.sample.interview.hackerrank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountOccurences {
    public static void main(String[] args) {
        String s = "aabbccddeeffggaaxxaaddyy";
        String t = "aa";

        String r = "(" + t + ")+";
        Pattern p = Pattern.compile(r);
        Matcher m = p.matcher(s);

        int cnt = 0;
        while(m.find()) {
            cnt++;
        }
        System.out.println(cnt);
    }
}
