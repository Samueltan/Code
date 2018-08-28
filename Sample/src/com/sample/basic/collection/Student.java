package com.sample.basic.collection;

import java.util.*;

public class Student {
    private String name;    // 姓名
    private int age;        // 年龄

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取学生姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 获取学生年龄
     */
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }
}

class ListTest {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();     // Java 7的钻石语法(构造器后面的尖括号中不需要写类型)
        list.add(new Student("Hao LUO", 33));
        list.add(new Student("XJ WANG", 32));
        list.add(new Student("Bruce LEE", 60));
        list.add(new Student("Bob YANG", 22));

        System.out.println("Before sorting:");
        for(Student stu : list) {
            System.out.println(stu);
        }

        // 通过sort方法的第二个参数传入一个Comparator接口对象
        // 相当于是传入一个比较对象大小的算法到sort方法中
        // 由于Java中没有函数指针、仿函数、委托这样的概念
        // 因此要将一个算法传入一个方法中唯一的选择就是通过接口回调
        Collections.sort(list, Collections.reverseOrder(new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();    // 比较学生姓名
            }
        }));

        System.out.println("After sorting:");
        for(Student stu : list) {
            System.out.println(stu);
        }
    }
}

class HashSetTest{
    public static void main(String[] args) {
        HashSet<Student> hashSet = new HashSet<>();
        Student s1 = new Student("Nicole", 16);
        Student s2 = new Student("粉笔", 18);
        Student s3 = new Student("小尹", 14);
        hashSet.add(s1);
        hashSet.add(s2);
        hashSet.add(s3);

        ArrayList<Student> list = new ArrayList<>(hashSet);
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        for(Student stu : list) {
            System.out.println(stu);
        }
    }
}