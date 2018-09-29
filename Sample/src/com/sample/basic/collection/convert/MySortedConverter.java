package com.sample.basic.collection.convert;

import com.sample.basic.collection.sort.person.Person;

import java.util.*;
import java.util.stream.Collectors;

public class MySortedConverter {
    public static void main(String[] args) {
        Person[] people = {
                new Person("Nicole", 18),
                new Person("Xiaoyin", 16),
                new Person("Fenbi", 39)
        };

        Arrays.sort(
            people,
            (s1, s2) -> s1.getName().compareTo(s2.getName())
        );

        System.out.println("Array sorted by name using Arrays.sort():");
        for(Person s: people) {
            System.out.println(s);
        }

        // Array to ArrayList
        List<Person> list = new ArrayList<>(Arrays.asList(people));
        Collections.sort(
            list,
            (s1, s2) -> s1.getAge() - s2.getAge()
        );
        System.out.println();
        System.out.println("ArrayList sorted by age using Collections.sort():");
        for(Person s: list) {
            System.out.println(s);
        }
        System.out.println(list);

        // ArrayList to Array
        Person[] convertedArray = list.toArray(new Person[list.size()]);
        System.out.println();
        System.out.println("Array converted from ArrayList:");
        for(Person s: convertedArray) {
            System.out.println(s);
        }

        Map<Integer, Person> map = new HashMap<>();
        map.put(1, people[1]);
        map.put(2, people[0]);
        map.put(3, people[2]);
        System.out.println();
        System.out.println("HashMap:");
        for(Map.Entry<Integer, Person> e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
        System.out.println(map.entrySet());

        // Map to ArrayList (Create ArrayList from entrySet of the map)
        System.out.println();
        System.out.println("HashMap to ArrayList sorted by key:");
        ArrayList<Map.Entry<Integer, Person>> mapEntryList = new ArrayList<>(map.entrySet());
        Collections.sort(
                mapEntryList,
                (e1, e2) -> e2.getKey() - e1.getKey()
        );
        for(Map.Entry<Integer, Person> e : mapEntryList) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
        System.out.println(mapEntryList);

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
        for(Map.Entry<Integer, Person> e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
        System.out.println(map.entrySet());
    }
}
