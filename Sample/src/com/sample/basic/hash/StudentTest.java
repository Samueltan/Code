package com.sample.basic.hash;

import com.sample.basic.collection.sort.person.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class StudentTest extends Person {

    int score;

    public StudentTest(int score) {
        super();
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentTest that = (StudentTest) o;
        return Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }

    public static void main(String[] args) {
        Map<Person, String> map = new HashMap<>(4);
        Person test = new Person("nicole", 16);
        Person test2 = new Person("nicole", 16);
        map.put(test, "He");
        System.out.println(test.equals(test2));
        System.out.println(test.hashCode() == test2.hashCode());
        System.out.println(map.get(test2));
    }
}