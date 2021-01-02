package com.sample.basic.collection.convert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class ListArrayConverter {
    public static void main(String[] args) {
        String[] array = {"India", "Switzerland", "Italy", "France"};
        print(array);

        // Array to ArrayList
        System.out.println();
        ArrayList<String> list = new ArrayList<>(Arrays.asList(array));
        print(list);

        // List to Array (give an Array with proper size to be the container)
        System.out.println();
        String[] convertedArray = list.toArray(new String[list.size()]);
        print(convertedArray);
    }

    public static <T> void print(T[] arr) {
        for(T t: arr) {
            System.out.println((String)t);
        }
    }

    public static <T> void print(Collection<T> coll) {
        for(T t : coll) {
            System.out.println((String)t);
        }
    }
}
