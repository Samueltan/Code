package com.sample.basic.collection.sort.person;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

class PersonHashSetTest {
    public static void main(String[] args) {
        HashSet<Person> hashSet = new HashSet<>();
        Person s1 = new Person("Nicole", 16);
        Person s2 = new Person("粉笔", 18);
        Person s3 = new Person("小尹", 14);
        hashSet.add(s1);
        hashSet.add(s2);
        hashSet.add(s3);

        ArrayList<Person> list = new ArrayList<>(hashSet);
        Collections.sort(
            list,
            Comparator.comparing(Person::getAge)
//            (o1, o2) -> o1.getAge() - o2.getAge()
        );

        for(Person stu : list) {
            System.out.println(stu);
        }
    }
}