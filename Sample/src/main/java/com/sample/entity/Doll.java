package com.sample.entity;

import java.util.Objects;

public class Doll {
    int id;
    String name;
    Color color;
    Cup cup;
    int age;

    public Doll(int id, String name, Color color, Cup cup, int age) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.cup = cup;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Cup getCup() {
        return cup;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doll doll = (Doll) o;
        return id == doll.id &&
                age == doll.age &&
                Objects.equals(name, doll.name) &&
                color == doll.color &&
                cup == doll.cup;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, color, cup, age);
    }

    @Override
    public String toString() {
        return "Doll{" +
                "id=" + id +
                ", 姓名='" + name + '\'' +
                ", 颜色=" + color +
                ", 罩杯尺寸=" + cup +
                ", 年龄=" + age +
                '}';
    }

    public String stringMe() {
        return "我是" + name + "，我是" + color.getValue() + "，尺寸是" + cup;
    }

    public void printMe() {
        System.out.println(stringMe());
    }
}
