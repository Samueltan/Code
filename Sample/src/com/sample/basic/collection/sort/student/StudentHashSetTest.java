package com.sample.basic.collection.sort.student;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

class StudentHashSetTest{
    public static void main(String[] args) {
        HashSet<Student> hashSet = new HashSet<>();
        Student s1 = new Student("Nicole", 16);
        Student s2 = new Student("粉笔", 18);
        Student s3 = new Student("小尹", 14);
        hashSet.add(s1);
        hashSet.add(s2);
        hashSet.add(s3);

        ArrayList<Student> list = new ArrayList<>(hashSet);
        Collections.sort(
            list,
            Comparator.comparing(Student::getAge)
//            (o1, o2) -> o1.getAge() - o2.getAge()
        );

        for(Student stu : list) {
            System.out.println(stu);
        }
    }
}