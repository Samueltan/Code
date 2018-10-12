package com.sample.basic.collection.sort;

import java.util.*;

public class TreeMapSortCustomizedTester {

    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("s", 2);
        treeMap.put("w", 5);
        treeMap.put("d", 1);
        treeMap.put("f", 0);
        treeMap.put("h", 9);
        treeMap.put("q", 22);
        treeMap.put("a", 25);
        //按照value排序
        List<Map.Entry<String, Integer>> entryArrayList = new ArrayList<>(treeMap.entrySet());
        Collections.sort(
            entryArrayList,
            Comparator.comparing(Map.Entry::getValue)
//            ((o1, o2) -> o1.getValue().compareTo(o2.getValue()))
        );
        System.out.println("----------------------*------------------------------");
        for (Map.Entry<String, Integer> entry : entryArrayList) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println("----------------------*------------------------------");

    }
}