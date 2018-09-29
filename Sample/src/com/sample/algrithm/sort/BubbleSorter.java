package com.sample.algrithm.sort;

import com.sample.basic.collection.sort.person.Person;

import java.util.Comparator;

/**
 * 冒泡排序
 *
 * @author骆昊
 *
 */
public class BubbleSorter implements Sorter {

    @Override
    public <T extends Comparable<T>> void sort(T[] list) {
        boolean swapped = true;
        for (int i = 1, len = list.length; i < len && swapped; ++i) {
            swapped = false;
            for (int j = 0; j < len - i; ++j) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
        }
    }

    @Override
    public <T> void sort(T[] list, Comparator<T> comp) {
        boolean swapped = true;
        for (int i = 1, len = list.length; i < len && swapped; ++i) {
            swapped = false;
            for (int j = 0; j < len - i; ++j) {
                if (comp.compare(list[j], list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSorter bubbleSorter = new BubbleSorter();
//        Integer[] list = {25, 67, 38};
        String[] list = {"abc", "xyz", "dqm"};
        bubbleSorter.sort(list);

        for(String s: list) {
            System.out.println(s);
        }

        Person s1 = new Person("Pheobe", 28);
        Person s2 = new Person("Nicole", 35);
        Person s3 = new Person("Xiaoyin", 25);
        Person[] sList = {s1, s2, s3};

        bubbleSorter.sort(sList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        for(Person s: sList) {
            System.out.println(s);
        }
    }
}