package com.sample.basic.async.callback;

/**
 * 这个就是B啦
 * @author xiaanming
 *
 */
public class B {
    /**
     * 相当于B类有参数为CallBack callBack的f()---->背景三
     * @param callBack
     * @param question A问的问题
     */
    public void executeMessage(CallBack callBack, String question){
        System.out.println("A问的问题--->" + question);

        //模拟B办自己的事情需要很长时间
        for(int i=0; i<100000;i++){
            for(int j=0; j<30000;j++){
                for(int k=0; k<10000;k++){

                }
            }
        }

        /**
         * B办完自己的事情之后想到了答案是2
         */
        String result = "答案是2";

        /**
         * 于是就打电话告诉A，调用A中的方法
         * 这就相当于B类反过来调用A的方法D
         */
        callBack.callback(result);

    }

}
