package com.sample.basic.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest2 {
    public static void main(String[] args) {
        Service service = new Service();
        MyThread2 t1 = new MyThread2(service);
        MyThread2 t2 = new MyThread2(service);
        MyThread2 t3 = new MyThread2(service);
        t1.start();
        t2.start();
        t3.start();
    }
}

class Service {
    private Lock lock = new ReentrantLock();
    public void testMethod() {
        lock.lock();
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " i=" + (i + 1));
        }
        lock.unlock();
    }
}

class MyThread2 extends Thread {
    private Service service;
    public MyThread2(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
