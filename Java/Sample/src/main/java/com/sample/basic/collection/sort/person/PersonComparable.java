package com.sample.basic.collection.sort.person;

public class PersonComparable implements Comparable<PersonComparable> {
    private String name;        // 姓名
    private int age;            // 年龄

    public PersonComparable(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    @Override
    public int compareTo(PersonComparable o) {
        return this.age - o.age; // 比较年龄(年龄的升序)
    }

}

