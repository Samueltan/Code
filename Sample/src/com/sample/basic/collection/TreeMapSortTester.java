package com.sample.basic.collection;

import java.util.*;

public class TreeMapSortTester {
    public static void main(String[] args) {
        System.out.println("Sort by key:");
        TreeMap<Integer, String> treeMap1 = new TreeMap<>();
        init(treeMap1);
        print(treeMap1);

        System.out.println("\nSort by key desc:");
        TreeMap<Integer, String> treeMap2 = new TreeMap<Integer, String>(
            (o1, o2) -> o2.compareTo(o1)
        );
        init(treeMap2);
        print(treeMap2);

        System.out.println("\nSort by value:");
        List<Map.Entry<Integer, String>> list = new ArrayList<>(treeMap2.entrySet());
        Collections.sort(
            list,
//            (o1, o2) -> o1.getValue().compareTo(o2.getValue())

            Comparator.comparing(Map.Entry::getValue)

//            new Comparator<Map.Entry<Integer, String>>() {
//                @Override
//                public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
//                    return o1.getValue().compareTo(o2.getValue());
//                }
//            }
        );
        print(list);
    }

    public static void init(Map<Integer, String> map) {
        map.put(6, "g");
        map.put(2, "a");
        map.put(3, "e");
        map.put(5, "d");
        map.put(4, "c");
    }

    public static void print(Map<Integer, String> map) {
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer, String> e = it.next();
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }

    public static void print(List<Map.Entry<Integer, String>> list) {
        for (Map.Entry<Integer, String> e : list) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
}
