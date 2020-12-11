package com.sample.interview.priceline;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CharArrayStringStreamConverter {
    public static void main(String[] args) {
        String s = "hello, world!";

        // String to char array
        char[] charArr = s.toCharArray();
//        String strCharArr = String.valueOf(charArr);
        System.out.println(new String(charArr) + "\tString from char array");

        // String to IntStream > Stream of char > (List > Stream >) Character Array > Stream > String
        Character[] charArr2 = s.chars().mapToObj(i -> (char)i)
//            .collect(Collectors.toList()).stream()    // Can be skipped
            .toArray(Character[]::new);
        // Character Array > Stream > String
        String charArrStream = Arrays.stream(charArr2).map(String::valueOf).collect(Collectors.joining());
        System.out.println(charArrStream + "\tString from char array through Stream");

        // String to IntStream > Stream of char > String
        String charStream = s.chars().mapToObj(i -> (char) i)
            .map(String::valueOf)
            .collect(Collectors.joining());
        System.out.println(charStream + "\tString from char Stream");

        // String to IntStream > Stream of String
        String strStream = s.chars().mapToObj(i -> String.valueOf((char) i))
            .collect(Collectors.joining());
        System.out.println(strStream + "\tString from String Stream");
    }
}
