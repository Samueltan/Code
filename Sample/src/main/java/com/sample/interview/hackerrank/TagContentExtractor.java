package com.sample.interview.hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(
            "<h1><a>a and b</a>test</h1>"
        );

        String regex = "<([^<>]+)>([^<]+)</\\1>";
        Pattern pattern = Pattern.compile(regex);
        for (String s: list) {
            System.out.println(">>> Current string is: " + s);
            Matcher m = pattern.matcher(s);
            boolean found = false;
            while(m.find()) {
                found = true;
                String match = m.group(2);
                System.out.println(m.group(2));
            }
            if(!found) System.out.println("None");
        }
    }
}
