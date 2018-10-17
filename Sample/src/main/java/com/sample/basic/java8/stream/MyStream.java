package com.sample.basic.java8.stream;

import com.sample.entity.Color;
import com.sample.entity.Cup;
import com.sample.entity.Doll;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyStream {
    public static void main(String[] args) throws IOException {
        Stream stream1 = Stream.of("a", "b", "c");
        String [] strArray = new String[] {"a", "b", "c"};
        Stream stream2 = Stream.of(strArray);
        Stream stream3 = Arrays.stream(strArray);
        List<String> list = Arrays.asList(strArray);
        Stream stream4 = list.stream();

        testDolls();
//
//        testMap();
//
//        testPeek();
//
//        testReduce();
//
//        testLimitAndSkip();

//        testLines();
    }

    private static void testLines() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/Users/samueltan/Documents/amc.log"));
//        int longest = br.lines().
//                mapToInt(String::length).
//                max().
//                getAsInt();
//        System.out.println(longest);

        br.lines()
                .flatMap(line -> Stream.of(line.split(" ")))
                .filter(w -> (w.length() > 0 && Character.isLetter(w.charAt(0))))
                .map(String::toLowerCase)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        br.close();
    }

    private static void testPeek() {
        System.out.println();
        System.out.println();
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
//                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private static void testMap() {
        System.out.println();
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        nums.stream().
                map(n -> n * n).
                forEach(i -> System.out.print(i + " "));

        System.out.println();
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        Stream<Integer> outputStream = inputStream.
                flatMap((childList) -> childList.stream());
        outputStream.forEach(i -> System.out.print(i + " "));
    }

    private static void testDolls() {
        Doll nicole = new Doll(1, "Nicole", Color.PINK, Cup.A, 22);
        Doll pheobe = new Doll(2, "Pheobe", Color.WHITE, Cup.D, 19);
        Doll changxinyi = new Doll(3, "Elain", Color.BLACK, Cup.B, 33);
        Doll zhulijuan = new Doll(4, "Vally", Color.YELLOW, Cup.C, 28);
        Doll xiaoyin = new Doll(5, "Elsa", Color.PINK, Cup.C, 16);
        Doll eva = new Doll(6, "Eva", Color.WHITE, Cup.B, 36);
        Doll feifei = new Doll(7, "Feifei", Color.PINK, Cup.B, 26);
        Doll keren = new Doll(8, "Keren", Color.PINK, Cup.A, 30);

        List<Doll> dolls = new ArrayList<>();
        dolls.add(nicole);
        dolls.add(pheobe);
        dolls.add(changxinyi);
        dolls.add(zhulijuan);
        dolls.add(xiaoyin);
        dolls.add(eva);
        dolls.add(feifei);
        dolls.add(keren);

        System.out.println();
        dolls.stream()
                .filter(d -> d.getColor() == Color.PINK)
                .sorted((d1, d2) -> d1.getCup().compareTo(d2.getCup()))
                .collect(Collectors.toList())
                .forEach(Doll::printMe);

        System.out.println();
        dolls.stream()
                .map(Doll::getName)
                .map(String::toUpperCase)
//                .collect(Collectors.toList())
                .forEach(System.out::println);

        boolean anyPink = dolls.stream()
                .anyMatch(d -> d.getColor() == Color.PINK);

        boolean allPink = dolls.stream()
                .allMatch(d -> d.getColor() == Color.PINK);
        System.out.println("Is there any pink? " + anyPink);
        System.out.println("Are all pink? " + allPink);
    }

    public static void testReduce() {
        System.out.println();
        System.out.println();
        // 字符串连接，concat = "ABCD"
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        System.out.println(concat);

        // 求最小值，minValue = -3.0
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        System.out.println(minValue);

        // 求和，sumValue = 10, 有起始值
        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        System.out.println(sumValue);
        // 求和，sumValue = 10, 无起始值
        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        System.out.println(sumValue);

        // 过滤，字符串连接，concat = "ace"
        concat = Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("Z") > 0).
                reduce("", String::concat);
        System.out.println(concat);
    }

    public static void testLimitAndSkip() {
        List<Person> persons = new ArrayList();
        for (int i = 1; i <= 10000; i++) {
            Person person = new Person(i, "name" + i);
            persons.add(person);
        }
        List<String> personList2 = persons.stream().
                map(Person::getName).limit(10).skip(3).collect(Collectors.toList());
        System.out.println(personList2);
    }
    private static class Person {
        public int no;
        private String name;
        public Person (int no, String name) {
            this.no = no;
            this.name = name;
        }
        public String getName() {
            System.out.println(name);
            return name;
        }
    }
}
