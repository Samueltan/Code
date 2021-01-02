package com.sample.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFutureTest t = new CompletableFutureTest();
//        Future<String> f = t.calculateAsync1();
//        Future<String> f = t.calculateAsync2();
        CompletableFuture<String> cf = t.calculateAsync4();
//        Future<String> f = cf.thenApply(r -> r + " world!");
        CompletableFuture<Void> f = cf.thenAccept(r -> System.out.println(r + " world!"));
//        f.get();
//        System.out.println(r);
//        assertEquals("hello world!", r);
    }

    public Future<String> calculateAsync1() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(3000);
            completableFuture.complete("hello");
            return null;
        });

        return completableFuture;
    }

    public CompletableFuture<String> calculateAsync2() {
        return CompletableFuture.completedFuture("hello");
    }

    public CompletableFuture<String> calculateAsync3() {
        return CompletableFuture.supplyAsync(() -> "hello");
    }

    public CompletableFuture<String> calculateAsync4() {
        return CompletableFuture.supplyAsync(() -> "hello")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " world!"));
    }
}
