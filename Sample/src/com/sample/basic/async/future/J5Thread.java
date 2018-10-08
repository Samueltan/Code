package com.sample.basic.async.future;

import java.util.concurrent.*;

public class J5Thread {

    public static void main(String[] args) {
        // ES
        System.out.println("Get request from TC, thread id="+Thread.currentThread().getId());
        ExecutorService es= Executors.newCachedThreadPool();

//        //task
//        Callable<Integer> task1= new Task1();
//        Callable<Integer> task2 = new Task2();

        //ES submit task,
        //param is callable
        //return result
        Future<Integer> future1=es.submit(
            () -> {
                System.out.println("creating Task1, thread id="+Thread.currentThread().getId());
                TimeUnit.SECONDS.sleep(2);
                System.out.println("end Task1, thread id="+Thread.currentThread().getId());
                return new Integer(3);
            }
        );
        Future<Integer> future2= es.submit(
            () -> {
                System.out.println("creating Task2, thread id=" + Thread.currentThread().getId());
                TimeUnit.SECONDS.sleep(6);
                System.out.println("end Task2, thread id=" + Thread.currentThread().getId());
                return new Integer(10);
            }
        );
        es.shutdown();

        System.out.println("ES shutdown, thread id="+Thread.currentThread().getId());
        //ES shutdown

        try {
            System.out.println("<<<<< waiting for task1 result:");
            Integer result1 = future1.get();
            System.out.println(">>>>> task1 result returned: result1="+result1);

            System.out.println("<<<<< waiting for task2 result:");
            Integer result2 = future2.get();
            System.out.println(">>>>> task2 result returned: result2="+result2);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}

////define task
//class Task1 implements Callable<Integer>{
//
//    @Override
//    public Integer call() throws Exception {
//        // TODO Auto-generated method stub
//        System.out.println("creating Task1, thread id="+Thread.currentThread().getId());
//        Thread.sleep(2000);
//        System.out.println("end Task1, thread id="+Thread.currentThread().getId());
//        return new Integer(3);
//    }
//
//}
//
//class Task2 implements Callable<Integer> {
//
//    @Override
//    public Integer call() throws Exception {
//        System.out.println("creating Task2, thread id=" + Thread.currentThread().getId());
//        Thread.sleep(6000);
//        System.out.println("end Task2, thread id=" + Thread.currentThread().getId());
//        return new Integer(10);
//    }
//
//}