package com.sample.basic.collection.sort.student;

public class StudentComparable implements Comparable<StudentComparable> {
    private String name;        // 姓名
    private int age;            // 年龄

    public StudentComparable(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }

    @Override
    public int compareTo(StudentComparable o) {
        return this.age - o.age; // 比较年龄(年龄的升序)
    }

}

