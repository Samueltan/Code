package com.sample.basic.thread.operations;

public class SafeStopThread implements Runnable{
    private volatile boolean stop=false;//此变量必须加上volatile
    int a=0;
    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (!stop) {
            synchronized ("") {
                a++;
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                a--;
                String tn = Thread.currentThread().getName();
                System.out.println(tn + ":a=" + a);
            }
        }
    }

    //线程终止
    public void terminate(){
        stop=true;
    }

    public static void main(String[] args) {
        SafeStopThread t=new SafeStopThread();
        Thread t1=new Thread(t);
        t1.start();
        for(int i=0;i<50;i++){
            new Thread(t).start();
        }
        t.terminate();
//        t1.stop();
    }

}