package com.sample.basic.collection.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

class StudentNonComparable {
    String name;
    int age;
    float score;

    StudentNonComparable(String name, int age, float score) {
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
}

public class StudentNonComparableTest {

    public static void main(String[] args) {
        ArrayList<StudentNonComparable> stus = new ArrayList<>();
        stus.add(new StudentNonComparable("zhangsan", 12, 95));
        stus.add(new StudentNonComparable("lisi", 11, 89));
        stus.add(new StudentNonComparable("wangwu", 13, 96));
        stus.add(new StudentNonComparable("mazi", 12, 96));
        stus.add(null);

//        Comparator<StudentNonComparable> comparator = (s1, s2) -> {
//            float result = (s1.score - s2.score) == 0 ? s2.age - s1.age : s1.score - s2.score;
//            return (int)result;
//        };
//        stus.sort(comparator.reversed());

        stus.sort(Comparator.nullsLast(Comparator.comparing(StudentNonComparable::getScore)).reversed().thenComparing(StudentNonComparable::getAge));

        Iterator itr = stus.iterator();//遍历输出
        while(itr.hasNext())
            System.out.println(itr.next());
        System.out.println();
    }
}