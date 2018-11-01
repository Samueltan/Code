package com.sample.algrithm.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack {
    public static void main(String[] args) {
        Deque<String> myStack = new ArrayDeque();
        myStack.push("Nicole");
        myStack.push("Pheobe");
        myStack.push("Eva");
        myStack.forEach(System.out::println);

        System.out.println(myStack.size());
        System.out.println(myStack.pop());
        System.out.println(myStack.size());
    }
}
