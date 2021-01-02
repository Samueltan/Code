package com.sample.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FactorialSquareCalculator extends RecursiveTask<Integer> {
//    private Integer n;
//
//    public FactorialSquareCalculator(Integer n) {
//        this.n = n;
//    }
//
//    @Override
//    protected Integer compute() {
//        if (n <= 1) return 1;
//        FactorialSquareCalculator cal = new FactorialSquareCalculator(n - 1);
//        cal.fork();
//
//        Integer r =  n * n + cal.join();
//        System.out.println(r);
//        return r;
//    }
    private Integer n;

    public FactorialSquareCalculator(Integer n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) {
            return n;
        }

        FactorialSquareCalculator calculator
                = new FactorialSquareCalculator(n - 1);

        calculator.fork();
        Integer r = n * n + calculator.join();
        System.out.println(r);
        return r;
    }

    public static void main(String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        FactorialSquareCalculator cal = new FactorialSquareCalculator(5);
        pool.submit(cal);
        cal.join();
//        Integer r = cal.invoke();
//        Integer r = pool.invoke(cal);
//        System.out.println(r);
    }
}
