package com.sample.exercise;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class StreamTest {
    public static void main(String[] args) {
        // Test data
        Person sara = new Person("Sara", 4, "Norwegian");
        Person viktor = new Person("Viktor", 40, "Serbian");
        Person eva = new Person("Eva", 42, "Norwegian");
        List<Person> people = asList(sara, viktor, eva);
        List<Integer> iList = Arrays.asList(1, 12, 25, 36, 78, 129, 62);

        // flatMap a nested stream
        List<List<String>> nestedList = asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"));
        List<String> res = nestedList.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(res);

        // Retrieve an Object of max field value
        Person oldest = people.stream().max(Comparator.comparingInt(Person::getAge)).get();
        System.out.println(oldest);

        // Reduce to sum up a list
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        System.out.println(numbers.stream().reduce(0, Integer::sum));

        // Statistics
        IntSummaryStatistics statistics = people.stream().mapToInt(Person::getAge).summaryStatistics();

        // GroupingBy
        Map<Boolean, List<Person>> map1 = new HashMap<>();
        Map<String, List<Person>> map2 = new HashMap<>();

        map1 = people.stream().collect(Collectors.groupingBy(p -> p.getAge() > 18));
        System.out.println(map1);

        map2 = people.stream().collect(Collectors.groupingBy(Person::getNationality));
        System.out.println(map2);

        // IntStream & mapToObj
        String preInt = iList.stream().map(i -> (i%2 == 0) ? "e" + i : "o" + i).collect(Collectors.joining(","));
        System.out.println(preInt);
    }
}

class Person {
    private String name;
    private int age;
    private String nationality;

    public Person(String name, int age, String nationality) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
    }

    public Person(String name, int age) {
        this(name, age, "");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}