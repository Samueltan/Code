package com.sample.basic.thread.singleton;

public class SingletonDoubleCheck {
    private static SingletonDoubleCheck singletonDoubleCheck;

    private SingletonDoubleCheck(){}

    public static SingletonDoubleCheck getInstance(){
        if (singletonDoubleCheck == null) {
            synchronized (SingletonDoubleCheck.class) {
                if (singletonDoubleCheck == null) {
                    singletonDoubleCheck = new SingletonDoubleCheck();
                }
            }
        }

        return singletonDoubleCheck;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        SingletonDoubleCheck instance1 = SingletonDoubleCheck.getInstance();
        SingletonDoubleCheck instance2 = SingletonDoubleCheck.getInstance();
        System.out.println(instance1 == instance2);
        System.out.println(System.currentTimeMillis() - start + "ms");
    }
}
