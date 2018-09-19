package com.sample.basic.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        ReentrantLockTest test = new ReentrantLockTest();
        new MyThread("T-one", test.lock).start();
        new MyThread("T-two", test.lock).start();
        new MyThread("T-three", test.lock).start();
    }
}

class MyThread extends Thread {
    String name;
    ReentrantLock lock;
    public MyThread(String name, ReentrantLock lock) {
        this.name = name;
        this.lock = lock;
    }
    @Override
    public void run() {
        if (lock.isLocked()) {
            System.out.println(name + " wait as lock");
        }
        lock.lock();
        System.out.println(name + " lock it");
        try {
            for (int i = 0; i < 2; i++) {
                System.out.println(name + " index:" + i);
            }
        } finally {
            lock.unlock();
            System.out.println(name + " unlock it");
        }
    }
}