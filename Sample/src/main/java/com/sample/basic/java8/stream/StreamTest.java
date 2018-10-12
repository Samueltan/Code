package com.sample.basic.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.System.out;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream = numbers.stream();
        stream.filter(x -> x % 2 == 0)
                .map(x -> x * x)
                .forEach(out::println);

        out.println();
        List<String> strings = Arrays.asList("abc", "", null, "bc", "efg", "abcd","", "jkl");

        Supplier<Stream<String>> supplier = () -> strings.stream()
                .filter(string -> (string != null && !string.isEmpty()))
                .sorted();
//                .collect(Collectors.toList());
        supplier.get().forEach(out::println);
        System.out.println(supplier.get().count());
        System.out.println(supplier.get().min(String::compareTo));
        System.out.println(supplier.get().max(String::compareTo));

        System.out.println();
        int[] arr = {2, 5, 6, 9, 3};
        Supplier<IntStream> supplier2 = () -> IntStream.of(arr).sorted();
        supplier2.get().forEach(System.out::println);
        System.out.println("count == " + supplier2.get().count());
        System.out.println(supplier2.get().min());
        System.out.println(supplier2.get().max());
        System.out.println(supplier2.get().average());
    }
}
