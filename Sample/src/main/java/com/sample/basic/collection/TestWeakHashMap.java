package com.sample.basic.collection;

import java.util.WeakHashMap;

public class TestWeakHashMap {
    public static void main(String args[]) {

        WeakHashMap map = new WeakHashMap();

        map.put(new String("1"), "1");
        map.put("2", "2");
        String s = new String("3");
        map.put(s, "3");
        map.put(new String("4"), "4");

        while (map.size() > 0) {

            try {

                Thread.sleep(1000);

            } catch (InterruptedException ignored) {

            }

            System.out.println("Map Size:"+map.size());
            System.out.println(map.get("1"));
            System.out.println(map.get("2"));
            System.out.println(map.get("3"));
            System.out.println(map.get("4"));

            System.gc();

        }

    }
}
