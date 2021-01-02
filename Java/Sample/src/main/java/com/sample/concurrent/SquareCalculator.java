package com.sample.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SquareCalculator {
    private ExecutorService es = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SquareCalculator ft = new SquareCalculator();
        Future<Integer> f1 = ft.calculate(10);
        Future<Integer> f2 = ft.calculate(25);

        while (!(f1.isDone() && f2.isDone())) {
            System.out.println(
                String.format(
                    "Future1 is %s and Future2 is %s",
                    f1.isDone() ? "done" : "not done",
                    f2.isDone() ? "done" : "not done"
                ));

            Thread.sleep(300);
        }

        System.out.println(f1.get() + " and " + f2.get());
        ft.close();
    }

    public Future<Integer> calculate(int a) {
        return es.submit(() -> {
            System.out.println("Calculating square for " + a);
            Thread.sleep(1000);
            return a * a;
        });
    }

    public void close() {
        es.shutdown();
    }
}
