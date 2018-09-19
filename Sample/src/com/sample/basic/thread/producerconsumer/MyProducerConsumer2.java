package com.sample.basic.thread.producerconsumer;

import java.util.LinkedList;

public class MyProducerConsumer2 {
    LinkedList<Object> buffer = new LinkedList <Object>();
    private static final int MAX_BUFFER = 10;

    public static void main(String[] args) {
        MyProducerConsumer2 myProducerConsumer2 = new MyProducerConsumer2();
        myProducerConsumer2.start();
    }

    public void start() {
        new Thread(new MyProducer()).start();
        new Thread(new MyConsumer()).start();
    }

    class MyProducer implements Runnable{
        @Override
        public void run() {
            while(true) {
                synchronized (buffer) {
                    while (MAX_BUFFER == buffer.size()) {
                        System.out.println("Warning: Buffer is full!");
                        try {
                            buffer.wait();
                        } catch (InterruptedException e) {
                            System.out.println("Producer is interrupted!");;
                        }
                    }

                    buffer.add(new Object());
                    System.out.println("Producer: " + buffer.size());
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    buffer.notifyAll();
                }
            }
        }
    }

    class MyConsumer implements Runnable {
        @Override
        public void run() {
            while(true) {
                synchronized (buffer) {
                    while (0 == buffer.size()) {
                        System.out.println("Warning: Buffer is empty!");
                        try {
                            buffer.wait();
                        } catch (InterruptedException e) {
                            System.out.println("Consumer is interrupted!");
                        }
                    }

                    buffer.removeLast();
                    System.out.println("Consumer: " + buffer.size());
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    buffer.notifyAll();
                }
            }
        }
    }
}
