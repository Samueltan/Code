package com.sample.basic.collection;

import com.sample.basic.collection.sort.student.Student;

import java.util.*;

public class PrintTest {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("liquidweb.com", 80000));
        list.add(new Student("linode.com", 90000));
        list.add(new Student("digitalocean.com", 120000));
        list.add(new Student("aws.amazon.com", 200000));
        System.out.println(list);

        Map<String, Student> map = new HashMap<>();
        map.put("alpha", new Student("nicole", 16));
        map.put("beta", new Student("fenbi", 39));
        map.put("gama", new Student("xiaoyin", 15));
        System.out.println(map);

        Set<Student> set = new HashSet<>();
        set.add(new Student("nicole", 16));
        set.add(new Student("fenbi", 39));
        set.add(new Student("xiaoyin", 15));
        System.out.println(set);
    }

}
