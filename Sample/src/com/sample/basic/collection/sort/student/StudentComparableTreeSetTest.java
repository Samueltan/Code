package com.sample.basic.collection.sort.student;

import java.util.Set;
import java.util.TreeSet;

class StudentComparableTreeSetTest {
    public static void main(String[] args) {
        System.out.println("Use comparable Student: ");
        Set<StudentComparable> set = new TreeSet<>();     // Java 7的钻石语法(构造器后面的尖括号中不需要写类型)
        set.add(new StudentComparable("Hao LUO", 33));
        set.add(new StudentComparable("XJ WANG", 32));
        set.add(new StudentComparable("Bruce LEE", 60));
        set.add(new StudentComparable("Bob YANG", 22));

        for (StudentComparable stu : set) {
            System.out.println(stu);
        }

        System.out.println("\nUse plain Student but provide a Comparator: ");
        Set<Student> set2 = new TreeSet<>(
            ((o1, o2) -> o1.getAge() - o2.getAge())
        );     // Java 7的钻石语法(构造器后面的尖括号中不需要写类型)
        set2.add(new Student("Hao LUO", 33));
        set2.add(new Student("XJ WANG", 32));
        set2.add(new Student("Bruce LEE", 60));
        set2.add(new Student("Bob YANG", 22));

        for (Student stu : set2) {
            System.out.println(stu);
        }
    }
}