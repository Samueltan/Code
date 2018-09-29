package com.sample.basic.collection.convert;

import com.sample.basic.collection.sort.person.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMapTest {

    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();
        list.add(new Person("liquidweb.com", 80000));
        list.add(new Person("linode.com", 90000));
        list.add(new Person("digitalocean.com", 120000));
        list.add(new Person("aws.amazon.com", 200000));
        list.add(new Person("mkyong.com", 1));

        Map<String, Integer> result2 = list.stream().collect(
                Collectors.toMap(Person::getName, Person::getAge));

        System.out.println("Result 2 : " + result2);

        Map<String, Integer> result3 = list.stream().collect(
                Collectors.toMap(x -> x.getName(), x -> x.getAge()));

        System.out.println("Result 3 : " + result3);
    }
}