package com.sample.basic.collection.convert;

import com.sample.basic.collection.sort.person.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListMapConverter {

    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();
        list.add(new Person("liquidweb.com", 80000));
        list.add(new Person("linode.com", 90000));
        list.add(new Person("digitalocean.com", 120000));
        list.add(new Person("aws.amazon.com", 200000));
        list.add(new Person("linode.com", 1));

        // ArrayList to Map via stream collector (Method reference)
        Map<String, Integer> result1 = list.stream().collect(
                Collectors.toMap(
                        Person::getName,
                        Person::getAge,
                        (s1, s2) -> s1)
                );
        System.out.println("Result 1 : " + result1);

        // ArrayList to Map via stream collector (lambda function)
        Map<String, Integer> result2 = list.stream().collect(
                Collectors.toMap(
                        x -> x.getName(),
                        x -> x.getAge(),
                        (s1, s2) -> s2)
        );
        System.out.println("\nResult 2 : " + result2);
    }
}