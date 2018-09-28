package com.sample.basic.collection.sort.student;

import java.util.*;
import java.util.stream.Collectors;

public class MySorter {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Nicole", 18),
                new Student("Xiaoyin", 16),
                new Student("Fenbi", 39)
        };

        Arrays.sort(
            students,
            (s1, s2) -> s1.getName().compareTo(s2.getName())
        );

        System.out.println("Array sorted by name using Arrays.sort():");
        for(Student s: students) {
            System.out.println(s);
        }

        // Array to ArrayList
        List<Student> list = new ArrayList<>(Arrays.asList(students));
        Collections.sort(
            list,
            (s1, s2) -> s1.getAge() - s2.getAge()
        );
        System.out.println();
        System.out.println("Array sorted by age using Collections.sort():");
        for(Student s: list) {
            System.out.println(s);
        }

        Map<Integer, Student> map = new HashMap<>();
        map.put(1, students[1]);
        map.put(2, students[0]);
        map.put(3, students[2]);
        System.out.println();
        System.out.println("HashMap:");
        for(Map.Entry<Integer, Student> e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        // Map to ArrayList
        System.out.println();
        System.out.println("HashMap to ArrayList sorted by key:");
        ArrayList<Map.Entry<Integer, Student>> mapEntryList = new ArrayList<>(map.entrySet());
        Collections.sort(
                mapEntryList,
                (e1, e2) -> e2.getKey() - e1.getKey()
        );
        for(Map.Entry<Integer, Student> e : mapEntryList) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        //List to Map
        map = mapEntryList.stream().collect(
                Collectors.toMap(
//                        e -> e.getKey(),
//                        e -> e.getValue()
                        Map.Entry::getKey,
                        Map.Entry::getValue
                )
        );
        System.out.println();
        System.out.println("ArrayList to Map: ");
        for(Map.Entry<Integer, Student> e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
}
