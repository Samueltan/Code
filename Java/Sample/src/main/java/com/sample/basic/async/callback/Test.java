package com.sample.basic.async.callback;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        A a = new A(new B());
        a.askQuestion("1+1=?");
    }
}
