package com.sample.basic.collection.sort.person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class PersonListTest {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();     // Java 7的钻石语法(构造器后面的尖括号中不需要写类型)
        list.add(new Person("Hao LUO", 33));
        list.add(new Person("XJ WANG", 32));
        list.add(new Person("Bruce LEE", 60));
        list.add(new Person("Bob YANG", 22));

        System.out.println("Before sorting:");
        for(Person stu : list) {
            System.out.println(stu);
        }

        // 通过sort方法的第二个参数传入一个Comparator接口对象
        // 相当于是传入一个比较对象大小的算法到sort方法中
        // 由于Java中没有函数指针、仿函数、委托这样的概念
        // 因此要将一个算法传入一个方法中唯一的选择就是通过接口回调
        Collections.sort(
            list,
            Collections.reverseOrder(
            Comparator.comparing(Person::getAge)
//            (o1, o2) -> o1.getAge() - o2.getAge()
            )
        );

        System.out.println("After sorting:");
        for(Person stu : list) {
            System.out.println(stu);
        }
    }
}