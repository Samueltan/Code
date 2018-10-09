package com.sample.basic.collection;

import com.sample.basic.collection.sort.person.Person;

import java.util.*;

public class PrintTest {
    public static void main(String[] args) {
        String[] arr = {"Jack", "Mike", "Nicole"};
        Arrays.stream(arr).forEach(System.out::println);

        System.out.println();
        List<Person> list = new ArrayList<>();
        list.add(new Person("liquidweb.com", 80000));
        list.add(new Person("linode.com", 90000));
        list.add(new Person("digitalocean.com", 120000));
        list.add(new Person("aws.amazon.com", 200000));
        System.out.println(list);
        list.forEach(System.out::println);

        System.out.println();
        Map<String, Person> map = new HashMap<>();
        map.put("alpha", new Person("nicole", 16));
        map.put("beta", new Person("fenbi", 39));
        map.put("gama", new Person("xiaoyin", 15));
        System.out.println(map);
        map.entrySet().forEach(System.out::println);

        System.out.println();
        Set<Person> set = new HashSet<>();
        set.add(new Person("nicole", 16));
        set.add(new Person("fenbi", 39));
        set.add(new Person("xiaoyin", 15));
        System.out.println(set);
        set.forEach(System.out::println);
    }

}
