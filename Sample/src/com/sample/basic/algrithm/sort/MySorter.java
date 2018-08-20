package com.sample.basic.algrithm.sort;

import java.util.Comparator;

public interface MySorter {
    public <T extends Comparable<T>> void sort(T[] list);

    public <T extends Comparable<T>> void sort(T[] list, Comparator<T> comparator);
}
