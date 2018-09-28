package com.sample.basic.collection.convert;

import com.sample.basic.collection.sort.student.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentListArrayConverter {
    public static void main(String[] args) {
        Student[] students = {
            new Student("Nicole", 18),
            new Student("Xiaoyin", 16),
            new Student("Fenbi", 39)
        };

        List<Student> list = new ArrayList(Arrays.asList(students));
        list.add(new Student("Tom", 20));

        for(Student s : list) {
            System.out.println(s);
        }

        System.out.println();
        Student[] arr = list.toArray(new Student[list.size()]);
        for(Student s : arr) {
            System.out.println(s);
        }
    }
}
