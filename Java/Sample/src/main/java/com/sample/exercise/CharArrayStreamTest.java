package com.sample.exercise;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CharArrayStreamTest {
    public static void main(String[] args) {
        String s = "ZorceApplezoo";

        // String to IntStream: String.chars()
        // Stream to Array: stream.toArray(T[]::new)
        // Array to Stream: Arrays.stream()

        // Stream Map to Character > Array > Collect
        Character[] arr = s.chars()
            .mapToObj(
                c -> ((c == 'Z' || c == 'z') ? Character.valueOf((char)(c - 25)) : Character.valueOf((char)(c + 1)))
            )
            .toArray(Character[]::new);
        String r1 = Arrays.stream(arr).map(String::valueOf).collect(Collectors.joining());

        // Stream Map to Character > String > joining
        String r2 = s.chars()
            .mapToObj(
                c -> ((c == 'Z' || c == 'z') ? new Character((char)(c - 25)) : new Character((char)(c + 1)))
            )
            .map(String::valueOf)
            .collect(Collectors.joining());

        // Stream Map to String > joining
        String r3 = s.chars()
            .mapToObj(
                c -> ((c == 'Z' || c == 'z') ? String.valueOf((char)(c - 25)) : String.valueOf((char)(c + 1)))
            )
            .collect(Collectors.joining());

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
    }
}
