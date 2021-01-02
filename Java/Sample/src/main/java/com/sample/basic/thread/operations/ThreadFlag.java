package com.sample.basic.thread.operations;

public class ThreadFlag extends Thread {
    public volatile boolean exit = false;

    public void run() {
        int i=0;
        while (!exit) {
            System.out.println(i++ + " running!");
        }
    }

    public static void main(String[] args) throws Exception {
        ThreadFlag thread = new ThreadFlag();
        thread.start();
        sleep(1); // 主线程延迟5秒
        thread.exit = true;  // 终止线程thread
//        thread.join();
        System.out.println("线程退出!");
    }
}