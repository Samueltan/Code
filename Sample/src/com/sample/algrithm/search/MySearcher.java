package com.sample.algrithm.search;

import com.sample.basic.collection.student.StudentComparable;

public class MySearcher {
    public static <T extends Comparable<T>> int binarySearchLoop(T[] list, T key) {
        int low = 0;
        int high = list.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int comp = list[mid].compareTo(key);
            if (comp > 0) {
                high = mid - 1;
            } else if (comp < 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static <T extends Comparable<T>> int binarySearchRecursive(T[] list, int low, int high, T key) {
        if (low <= high) {
            int mid = (low + high) >>> 1;

            int comp = list[mid].compareTo(key);
            if (comp == 0) {
                return mid;
            } else if (comp > 0) {
                return binarySearchRecursive(list, low, mid - 1, key);
            } else {
                return binarySearchRecursive(list, mid + 1, high, key);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        StudentComparable[] students = {
                new StudentComparable("蜡笔", 8),
                new StudentComparable("小尹", 14),
                new StudentComparable("Nicole", 16),
                new StudentComparable("粉笔", 18),
                new StudentComparable("浪逼", 19),
                new StudentComparable("骚笔", 28)
        };

//        int idx = binarySearchLoop(students, new StudentComparable("粉笔", 18));
//        System.out.println("idx = " + idx);

        int idx2 = binarySearchRecursive(students, 0, students.length - 1, new StudentComparable("粉笔", 18));
        System.out.println("idx2 = " + idx2);
    }
}
