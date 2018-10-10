package com.sample.basic.async.future;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class TestFuture1 {
    public static int getData() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Random().nextInt(1000);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> f = CompletableFuture.supplyAsync(TestFuture1::getData);

        CompletableFuture cf = f.whenComplete(
                (v, e) -> {
                    System.out.println("v: " + v);
                    System.out.println("e: " + e);
                }
        );

        System.out.println("<<< cf.get()");
        System.out.println("cf.get() = " + cf.get());
        System.out.println(">>> cf.get()");

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            return 100;
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            return "abc";
        });
        CompletableFuture<String> fx =  future.thenCombine(future2, (x,y) -> y + "-" + x);
        System.out.println(fx.get()); //abc-100

        Random rand = new Random();
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });
        CompletableFuture<Integer> future4 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 200;
        });
        CompletableFuture<String> fx2 =  future3.applyToEither(future4,i -> i.toString());
        System.out.println(fx2.get());
    }
}
