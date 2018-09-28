package com.sample.basic.collection.convert;

import com.sample.basic.collection.sort.student.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMapTest2 {

    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();
        list.add(new Student("liquidweb.com", 80000));
        list.add(new Student("linode.com", 90000));
        list.add(new Student("digitalocean.com", 120000));
        list.add(new Student("aws.amazon.com", 200000));
        list.add(new Student("linode.com", 1));

        // key = name, value - websites , but the key 'linode' is duplicated!?
        Map<String, Integer> result1 = list.stream().collect(
                Collectors.toMap(
                        Student::getName,
                        Student::getAge,
                        (s1, s2) -> s2));

        System.out.println("Result 1 : " + result1);

    }
}