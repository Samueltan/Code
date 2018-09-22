package com.sample;
public class Test {
    private static boolean stopRequest;
    public static void main(String args[]) throws InterruptedException {
        Thread myThread = new Thread(new Runnable() {
            public void run() {
                int count = 0;
                while (!stopRequest) { //访问类属性，共享的
                    System.out.println("count: " + count++);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        myThread.start();
        Thread.sleep(2000);
        stopRequest = true;
    }
}