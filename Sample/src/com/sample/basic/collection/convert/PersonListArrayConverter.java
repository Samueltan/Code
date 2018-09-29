package com.sample.basic.collection.convert;

import com.sample.basic.collection.sort.person.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonListArrayConverter {
    public static void main(String[] args) {
        Person[] people = {
            new Person("Nicole", 18),
            new Person("Xiaoyin", 16),
            new Person("Fenbi", 39)
        };

        List<Person> list = new ArrayList(Arrays.asList(people));
        list.add(new Person("Tom", 20));

        for(Person s : list) {
            System.out.println(s);
        }

        System.out.println();
        Person[] arr = list.toArray(new Person[list.size()]);
        for(Person s : arr) {
            System.out.println(s);
        }
    }
}
