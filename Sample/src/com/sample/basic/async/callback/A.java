package com.sample.basic.async.callback;


/**
     * 这个是A
     * @author xiaanming
     * 实现了一个回调接口CallBack，相当于----->背景一
     */
    public class A implements CallBack {
        /**
         * B对象的引用
         * 相当于----->背景二
         */
        private B b;

        /**
         * A的构造方法，持有B的引用
         * @param b
         */
        public A(B b){
            this.b = b;
        }

        /**
         * A通过这个方法去问B的问题
         * @param question  就是A要问的问题,1 + 1 = ?
         */
        public void askQuestion(final String question) throws InterruptedException {
            //这里用一个线程就是异步，
            new Thread(new Runnable() {
                @Override
                public void run() {
                    /**
                     * A调用B中的方法，在这里注册回调接口
                     * 这就相当于A类调用B的方法C
                     */
                    b.executeMessage(A.this, question);
                }
            }).start();

            Thread.sleep(200);
            //A问完问题挂掉电话就去干其他的事情了，诳街去了
            doOtherTask();
        }

        public void doOtherTask(){
            System.out.println("A does other things");
        }

        /**
         * B知道答案后调用此方法告诉A，就是所谓的A的回调方法
         */
        @Override
        public void callback(String result) {
            System.out.println("B告诉A的答案是--->" + result);
        }

    }

