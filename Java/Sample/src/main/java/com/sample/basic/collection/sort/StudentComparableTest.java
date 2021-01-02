package com.sample.basic.collection.sort;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

class StudentComparable implements Comparable<StudentComparable> {
    String name;
    int age;
    float score;

    StudentComparable(String name, int age, float score) {
        this.age = age;
        this.score = score;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String toString() {
        return "name:" + name + ", age: " + age + ", score: " + score;
    }

    @Override
    public int compareTo(StudentComparable ss) {
        int result = (int)(score - ss.score);
        if (result == 0) {
            result = (int)(ss.age - age);
        }
        return result;
    }
}

public class StudentComparableTest {
    public static void main(String[] args) {
        Set<StudentComparable> treeSet = new TreeSet<StudentComparable>();
        treeSet.add(new StudentComparable("zhangsan", 12, 95));
        treeSet.add(new StudentComparable("lisi", 11, 89));
        treeSet.add(new StudentComparable("wangwu", 13, 96));
        treeSet.add(new StudentComparable("mazi", 12, 96));

        System.out.println(treeSet);//直接输出

        Iterator itTSet = treeSet.iterator();//遍历输出
        while(itTSet.hasNext())
            System.out.print(itTSet.next() + "\t");
        System.out.println();
    }
}