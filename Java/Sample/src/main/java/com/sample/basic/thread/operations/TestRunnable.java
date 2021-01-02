package com.sample.basic.thread.operations;

class TestRunnable implements Runnable{

    volatile boolean isRunning = true;
    int count = 0;
    public void run() {
        while(isRunning){

            System.out.print("\n RunThread "+ count++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }


    }

}


class Main {

    public static void main(String args[]){

        TestRunnable run = new TestRunnable();
        Thread thread = new Thread(run,"runnable");
        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.print("\n parpare to stop the thread ");
        run.isRunning = false;

    }
}