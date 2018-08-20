package com.sample.basic.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestAccount {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Account account = new Account();
        ExecutorService service = Executors.newFixedThreadPool(100);

        for(int i = 1; i <= 100; i++) {
            service.execute(new AddMoneyThread(account, 1));
        }

        service.shutdown();

        while(!service.isTerminated()) {}

        long end = System.currentTimeMillis();
        System.out.println("账户余额: " + account.getBalance() + "\t运行时长：" + (end - start) + "ms");
    }
}