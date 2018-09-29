package com.sample.basic.collection.sort.person;

import java.util.Set;
import java.util.TreeSet;

class PersonComparableTreeSetTest {
    public static void main(String[] args) {
        System.out.println("Use comparable Person: ");
        // Here PersonComparable elements are required to instantiate the TreeSet, or the following error is thrown:
        // Exception in thread "main" java.lang.ClassCastException:
        // com.sample.basic.collection.sort.person.Person cannot be cast to java.lang.Comparable
        Set<PersonComparable> set = new TreeSet<>();     // Java 7的钻石语法(构造器后面的尖括号中不需要写类型)
        set.add(new PersonComparable("Hao LUO", 33));
        set.add(new PersonComparable("XJ WANG", 32));
        set.add(new PersonComparable("Bruce LEE", 60));
        set.add(new PersonComparable("Bob YANG", 22));

        for (PersonComparable stu : set) {
            System.out.println(stu);
        }

        System.out.println("\nUse plain Person but provide a Comparator: ");
        // Another way to do is not using PersonComparable but giving a explicit Comparator for the TreeSet
        Set<Person> set2 = new TreeSet<>(
            ((o1, o2) -> o1.getAge() - o2.getAge())
        );     // Java 7的钻石语法(构造器后面的尖括号中不需要写类型)
        set2.add(new Person("Hao LUO", 33));
        set2.add(new Person("XJ WANG", 32));
        set2.add(new Person("Bruce LEE", 60));
        set2.add(new Person("Bob YANG", 22));

        for (Person stu : set2) {
            System.out.println(stu);
        }
    }
}