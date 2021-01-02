package com.sample.basic.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class StreamDemo {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Apple", "Abc", "Bob", "Capture", "Dog", "Rome");
        OptionalInt possibleMax = strings.stream().filter(s -> s.startsWith("A"))
                .mapToInt(String::length)
                .max();

        if(possibleMax.isPresent()){
            System.out.println(possibleMax.getAsInt());
        }

        strings.stream().map(s -> s.replace('A', 'X')).forEach(System.out::println);
    }
}
