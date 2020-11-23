package com.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamConcatFlatMap {
    public static void main(String[] args) {
        ArrayList<String> listOne = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));

        ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("a", "b", "c", "f", "g"));

        List<String> combinedList = Stream.of(listOne, listTwo)
//                .flatMap(e -> e.stream())
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(combinedList);

        List<String> combinedList2 = Stream.concat(listOne.stream(), listTwo.stream())
                .collect(Collectors.toList());
        System.out.println(combinedList2);
    }
}