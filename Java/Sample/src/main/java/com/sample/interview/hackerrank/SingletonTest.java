package com.sample.interview.hackerrank;

public class SingletonTest {
    public static String str;
    private static SingletonTest singleton;

    public static void main(String[] args) {
//        SingletonTest st = SingletonTest.getSingleInstance();
    }

}

// Lazy without threadsafe
class SingletonLazy {
    private static SingletonLazy instance;
    private SingletonLazy() {}

    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}

// Lazy with synchronized method
class SingletonLazySynchronized {
    private static SingletonLazySynchronized instance;
    private SingletonLazySynchronized(){}

    public static synchronized SingletonLazySynchronized getInstance() {
        if (instance == null) {
            instance = new SingletonLazySynchronized();
        }
        return instance;
    }
}

// Lazy with double check
class SingletonLazyDoubleChecked {
    private volatile static SingletonLazyDoubleChecked instance;
    private SingletonLazyDoubleChecked(){}

    public static SingletonLazyDoubleChecked getInstance() {
        if (instance == null) {
            synchronized (SingletonLazyDoubleChecked.class) {
                if (instance == null) {
                    instance = new SingletonLazyDoubleChecked();
                }
            }
        }
        return instance;
    }
}

// Eager style
class SingletonEager {
    private static final SingletonEager instance = new SingletonEager();
    private SingletonEager(){}

    public static SingletonEager getInstance() {
        return instance;
    }
}

// Static Inner class
class SingletonInnerClass {
    private SingletonInnerClass(){}

    private static class SingletonHolder {
        private static final SingletonInnerClass instance = new SingletonInnerClass();
    }

    public static final SingletonInnerClass getInstance() {
        return SingletonHolder.instance;
    }
}

// Enum style
enum SingletonEnum {
    INSTANCE;
}