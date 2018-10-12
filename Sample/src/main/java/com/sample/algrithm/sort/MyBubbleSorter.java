package com.sample.algrithm.sort;

import java.util.Comparator;

public class MyBubbleSorter implements MySorter{
    @Override
    public <T extends Comparable<T>> void sort(T[] list) {
        int len = list.length;
        boolean swapped = true;

        for (int i = 1; i < len && swapped; i++) {
            swapped = false;
            for (int j = 0; j < len - 1; j++) {
                if (list[j].compareTo(list[j+1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                    swapped = true;
                }
            }
        }
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] list, Comparator<T> comparator) {
        boolean swapped = true;

        for (int i = 1, len = list.length; i < len && swapped; i++) {
            swapped = false;
            for (int j = 0; j < len - 1; j++) {
                if (comparator.compare(list[j], list[j+1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                    swapped = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        MySorter mySorter = new MyBubbleSorter();
        String[] list = {"Nicole", "Pheobe", "Xiaoyin", "Lynn"};

        mySorter.sort(list);
        for(String s : list) {
            System.out.println(s);
        }
    }
}
