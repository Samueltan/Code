package com.sample.basic.collection.sort.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class StudentListTest {

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
        Collections.sort(
            list,
            Collections.reverseOrder(
            Comparator.comparing(Student::getAge)
//            (o1, o2) -> o1.getAge() - o2.getAge()
            )
        );

        System.out.println("After sorting:");
        for(Student stu : list) {
            System.out.println(stu);
        }
    }
}