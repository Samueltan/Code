package com.sample.basic.thread.producerconsumer;

import java.util.ArrayList;

public class MyProducerConsumer {
    ArrayList<Object> list = new ArrayList<>();
    private static final int MAX = 10;

    public static void main(String[] args) {
        MyProducerConsumer mypc = new MyProducerConsumer();
        mypc.start();
    }

    public void start() {
        new Thread(new MyProducer()).start();
        new Thread(new MyConsumer()).start();
    }

    class MyProducer implements Runnable {

        @Override
        public void run() {
            while(true) {
                synchronized (list) {
                    while (MAX == list.size()) {
                        try {
                            System.out.println("warning: it's full!");
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    list.add(new Object());
                    System.out.println("Producer: " + list.size());
                    list.notifyAll();
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class MyConsumer implements Runnable {

        @Override
        public void run() {
            while(true) {
                synchronized (list) {
                    while (0 == list.size()) {
                        try {
                            System.out.println("warning: it's empty!");
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    list.remove(0);
                    System.out.println("Consumer: " + list.size());
                    list.notifyAll();
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
