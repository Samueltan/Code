package com.sample.basic.thread.test;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
    public static void main(String[] args){
        Map map = new HashMap<String, Integer>(1000*10);


        for(int i=0; i<10; i++){
            new Runner(map).start();

            //这个方法可以测试,线程安全时,Hashmap的大小最后能够达到多少
            // new Runner(map).run();
        }
    }

}

class Runner extends Thread {
    Map map;

    Runner(Map map) {
        this.map = map;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            map.put(this.getName() + i, i);
        }
        //如果是线程安全,那么HashMap的大小,最后能够达到1W.
        System.out.println(this.getName()+": "+map.size());

    }

}