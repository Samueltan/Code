package com.sample.basic.thread.singleton;

public class SingletonLazy {
    private static SingletonLazy singletonLazy;

    private SingletonLazy(){}

    public static synchronized SingletonLazy getInstance(){
        if (singletonLazy == null) {
            singletonLazy = new SingletonLazy();
        }

        return singletonLazy;
    }

    public static void main(String[] args) {
        SingletonLazy instance1 = SingletonLazy.getInstance();
        SingletonLazy instance2 = SingletonLazy.getInstance();
        System.out.println(instance1 == instance2);
    }
}
