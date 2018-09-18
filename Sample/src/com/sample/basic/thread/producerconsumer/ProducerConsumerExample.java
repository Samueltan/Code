package com.sample.basic.thread.producerconsumer;

import java.util.LinkedList;

public class ProducerConsumerExample {

    private LinkedList<Object> myList = new LinkedList<Object>();

    private int MAX = 10;

    public ProducerConsumerExample() {
        super();
    }

    public void start(){
        new Producerder().start();
        new Consumereder().start();
    }



    class Producerder extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 15; i++) {
                try {
                    this.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (myList) {
                    try {
                        while(myList.size() == MAX){
                            System.out.println("warning: it's full!");
                            myList.wait();
                        }

                        //*************把这一段注释掉********************
                        Object o = new Object();
                        if(myList.add(o)){
                            System.out.println("Producer: " + o);
                            myList.notify();
                        }
                        //*******************************
                        //把上面注释掉后,启用下面一行后。你再在Consumereder中分别是用while和if看下输出结果
                        //myList.notify();
                    } catch (Exception e) {
                        System.out.println("producer is interrupted!");
                    }
                }
            }
        }

    }


    class Consumereder extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 15; i++) {
                try {
                    this.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                synchronized (myList) {
                    try {
                        while(myList.size() == 0){
                            System.out.println("warning: it's empty!");
                            myList.wait();
                        }
                        System.out.println("oooooooooooooooooo");
                        Object o = myList.removeLast();
                        System.out.println("Consumereder" + o);
                        myList.notify();
                    } catch (Exception e) {
                        System.out.println("consumer is interrupted!");
                    }
                }
            }
        }

    }


    public static void main(String[] args) {
        ProducerConsumerExample ex10 = new ProducerConsumerExample();
        ex10.start();
    }
}