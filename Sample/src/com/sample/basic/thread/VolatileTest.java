package com.sample.basic.thread;

public class VolatileTest {
    static volatile int count = 0;

    public static void main(String[] args) {
        // 线程1
        new Thread(()->{
            do{}while (count<1);
            System.out.println("exit when count = "+count);
        }).start();
        // 线程2
        new Thread(()->{
            try {
                Thread.sleep(1000);
                count = 10;
                System.out.println("change value of count to "+count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
