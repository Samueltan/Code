package com.sample.basic.inner;

public class OuterClass {
    private String sex;
    public static String name = "chenssy";

    public void setSex(String sex) {
        this.sex = sex;
    }
    /**
     *静态内部类
     */
    static class InnerStaticClass {
        /* 在静态内部类中可以存在静态成员 */
        public static String _nameStatic = "chenssy_static";
        public int a;

        public void display(){
            /*
             * 静态内部类只能访问外围类的静态成员变量和方法
             * 不能访问外围类的非静态成员变量和方法
             */
            System.out.println("OutClass name :" + name);
        }
    }

    /**
     * 非静态内部类
     */
    class InnerNonStaticClass {
        /* 非静态内部类中不能存在静态成员 */
        public static final String _name2 = "chenssy_inner";
        /* 非静态内部类中可以调用外围类的任何成员,不管是静态的还是非静态的 */
        public void display(){
            System.out.println("OuterClass sex：" + sex);
            System.out.println("OuterClass name：" + name);
        }
    }

    /**
     * @desc 外围类方法
     * @author chenssy
     * @data 2013-10-25
     * @return void
     */
    public void display(){
        /* 外围类访问静态内部类：内部类. */
        System.out.println(InnerStaticClass._nameStatic);
        /* 静态内部类 可以直接创建实例不需要依赖于外围类 */
        new InnerStaticClass().display();

        /* 非静态内部的创建需要依赖于外围类 */
        OuterClass outerClass = new OuterClass();
        outerClass.setSex("Female");
        InnerNonStaticClass inner2 = outerClass.new InnerNonStaticClass();
        /* 访问非静态内部类的成员需要使用非静态内部类的实例 */
        System.out.println(inner2._name2);
        inner2.display();
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.display();
    }
}