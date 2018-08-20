package com.sample.basic.thread.singleton;

public class SingletonEager {
    private static SingletonEager singletonEager = new SingletonEager();

    private SingletonEager(){}

    public static SingletonEager getInstance() {
        return singletonEager;
    }

    public static void main(String[] args) {
        SingletonEager instance1 = SingletonEager.getInstance();
        SingletonEager instance2 = SingletonEager.getInstance();
        System.out.println(instance1 == instance2);
    }
}
