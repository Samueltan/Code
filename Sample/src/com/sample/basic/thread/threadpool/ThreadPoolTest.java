package com.sample.basic.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
//        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//
//        for (int i = 0; i < 10; i++) {
//            final int index = i;
//            try {
//                Thread.sleep(index * 10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            cachedThreadPool.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(index);
//                }
//            });
//        }
//        cachedThreadPool.shutdown();

//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
//        for (int i = 0; i < 10; i++) {
//            final int index = i;
//
//            fixedThreadPool.execute(new Runnable() {
//
//                @Override
//                public void run() {
//                    try {
//                        System.out.println(index);
//                        Thread.sleep(200);
//                    } catch (InterruptedException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }
//        fixedThreadPool.shutdown();

//        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
//        scheduledThreadPool.schedule(new Runnable() {
//
//            @Override
//            public void run() {
//                System.out.println("delay 2 seconds");
//            }
//        }, 2, TimeUnit.SECONDS);
//
//        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
//
//            @Override
//            public void run() {
//                System.out.println("delay 1 seconds, and excute every 2 seconds");
//            }
//        }, 1, 2, TimeUnit.SECONDS);
//        TimeUnit.SECONDS.sleep(8);
//        scheduledThreadPool.shutdown();

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {

                @Override
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
        }
        singleThreadExecutor.shutdown();
    }
}
