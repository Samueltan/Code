package com.sample;

public class Test {

    class CException extends RuntimeException
    {
        public CException() {}
        public CException(String message)
        {
            super(message);
        }
    }

    public void  method1() throws CException
    {
        if(true) {
            throw new CException("Test Exception");
        }
    }


    public void method2() throws CException
    {
        method1();
    }

//    public static void main(String[] args) {
    public static void main(String[] args) {
//        try{
            Test t = new Test();
            t.method2();
//        }catch(Exception ioe){
//            ioe.printStackTrace();
//        }
    }
}