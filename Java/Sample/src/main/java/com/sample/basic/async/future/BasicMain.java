package com.sample.basic.async.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class BasicMain {
    public static void main(String[] args) throws Exception {
        final CompletableFuture<Integer> f = new CompletableFuture<>();

        class Client extends Thread {
            CompletableFuture<Integer> f;
            Client(String threadName, CompletableFuture<Integer> f) {
                super(threadName);
                this.f = f;
            }
            @Override
            public void run() {
                try {
                    System.out.println(this.getName() + ": " + f.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
        new Client("Client1", f).start();
        new Client("Client2", f).start();
        System.out.println("waiting");
        f.complete(107);
        //f.completeExceptionally(new Exception());
//        System.in.read();
    }
}