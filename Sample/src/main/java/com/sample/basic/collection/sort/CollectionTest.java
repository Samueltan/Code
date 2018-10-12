package com.sample.basic.collection.sort;

import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add(null);
        list.add("b");
        list.add(null);
        list.add("c");
        System.out.println("elements in list:");
        print(list);

        HashSet<String> set = new HashSet<>();
        set.add("a");
        set.add("xb");
        set.add("qc");
        set.add("fm");
        set.add(null);
        set.add(null);
        set.add("dae");
        set.add("feagaawe aet");
        System.out.println("\nelements in set:");
        print(set);

        HashMap<Integer, String> map = new HashMap<>();
        map.put(9, "a");
        map.put(4, null);
        map.put(5, "aikdi");
        map.put(7, null);
        map.put(null, "b");
        map.put(null, "c");
        map.put(6, null);
        map.put(1, "a changed");
        System.out.println("\nelements in map:");

        for (Map.Entry<Integer, String> e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        LinkedHashMap<Integer, String> map2 = new LinkedHashMap<Integer, String>(10, 0.75f, false);
        map2.put(19, "a");
        map2.put(14, null);
        map2.put(25, "aikdi");
        map2.put(27, null);
        map2.put(null, "b");
        map2.put(null, "c");
        map2.put(36, null);
        map2.put(11, "a changed");
        System.out.println("\nelements in map2:");

        for (Map.Entry<Integer, String> e : map2.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        ArrayList<Map.Entry<Integer, String>> arrayMap = new ArrayList<Map.Entry<Integer, String>>(map.entrySet());
        Collections.sort(
            arrayMap,
            (e1, e2) -> {
                if (e1.getValue() == null) return -1;
                if (e2.getValue() == null) return 1;
                return e1.getValue().compareTo(e2.getValue());
            }
        );
        System.out.println("\nelements in map sorting by value:");
        for (Map.Entry<Integer, String> e : arrayMap) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        ArrayList<String> arrList = new ArrayList<>();
        arrList.add("f");
        arrList.add("c");
        arrList.add("g");
        arrList.add("e");
        arrList.add("x");
        arrList.add(null);
        Collections.sort(
            arrList,
            (o1,o2) -> {
                if (o1 == null) return -1;
                if (o2 == null) return 1;
                return o1.compareTo(o2);
            }
        );
//        arrList.sort((o1,o2) -> {
//            if (o1 == null) return -1;
//            if (o2 == null) return 1;
//            return o1.compareTo(o2);
//        });

        System.out.println("\nelements in ArrayList after sorting:");
        print(arrList);
    }

    public static void print(Collection<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }
}
