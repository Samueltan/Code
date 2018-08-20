package com.sample.basic.collection;

import java.util.Set;
import java.util.TreeSet;

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

class TreeSetTest {
    public static void main(String[] args) {
        Set<StudentComparable> set = new TreeSet<>();     // Java 7的钻石语法(构造器后面的尖括号中不需要写类型)
        set.add(new StudentComparable("Hao LUO", 33));
        set.add(new StudentComparable("XJ WANG", 32));
        set.add(new StudentComparable("Bruce LEE", 60));
        set.add(new StudentComparable("Bob YANG", 22));

        for (StudentComparable stu : set) {
            System.out.println(stu);
        }
    }
}