package com.sample.basic.collection.convert;

import com.sample.basic.collection.sort.student.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMapTest {

    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();
        list.add(new Student("liquidweb.com", 80000));
        list.add(new Student("linode.com", 90000));
        list.add(new Student("digitalocean.com", 120000));
        list.add(new Student("aws.amazon.com", 200000));
        list.add(new Student("mkyong.com", 1));

        Map<String, Integer> result2 = list.stream().collect(
                Collectors.toMap(Student::getName, Student::getAge));

        System.out.println("Result 2 : " + result2);

        Map<String, Integer> result3 = list.stream().collect(
                Collectors.toMap(x -> x.getName(), x -> x.getAge()));

        System.out.println("Result 3 : " + result3);
    }
}