package com.sample.basic.collection.convert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionConvertTest {
    public static void main(String[] args) {
        String[] array = {"India", "Switzerland", "Italy", "France"};
        print(array);

        System.out.println();
        ArrayList<String> list = new ArrayList<>(Arrays.asList(array));
        print(list);

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
