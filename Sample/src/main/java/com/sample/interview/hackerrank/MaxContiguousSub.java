package com.sample.interview.hackerrank;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class MaxContiguousSub {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        int m = 3;

        int[] num = {5, 3, 5, 2, 5, 2};
        int max = 0;
        for (int n: num) {
            deque.add(n);
            set.add(n);
            if(set.size() > max) max = set.size();
            if(deque.size() == m) {
                Integer first = deque.remove();
                if(!deque.contains(first)) set.remove(first);
            }
        }
        System.out.println(max);
    }
}
