package com.sample.designpattern.singleton;

/**
 * 双重检验锁模式（double checked locking pattern），是一种使用同步块加锁的方法。
 * 称其为双重检查锁，因为会有两次检查 instance == null，一次是在同步块外，一次是在同步块内。
 * 为什么在同步块内还要再检验一次？因为可能会有多个线程一起进入同步块外的 if，如果在同步块内不进行二次检验的话就会生成多个实例了。
 */
public class SingletonDoubleCheck {

    private volatile static SingletonDoubleCheck singletonDoubleCheck;

//    private SingletonDoubleCheck(){}

    /**
     * 这段代码看起来很完美，很可惜，它是有问题。主要在于instance = new Singleton()这句，这并非是一个原子操作，
     * 事实上在 JVM 中这句话大概做了下面 3 件事情。
     *
     * 1.给 instance 分配内存
     * 2.调用 Singleton 的构造函数来初始化成员变量
     * 3.将instance对象指向分配的内存空间（执行完这步 instance 就为非 null 了）
     *
     * 但是在 JVM 的即时编译器中存在指令重排序的优化。也就是说上面的第二步和第三步的顺序是不能保证的，
     * 最终的执行顺序可能是 1-2-3 也可能是 1-3-2。如果是后者，则在 3 执行完毕、2 未执行之前，被线程二抢占了，
     * 这时 instance 已经是非 null 了（但却没有初始化），所以线程二会直接返回 instance，然后使用，然后顺理成章地报错。
     *
     * 我们只需要将 instance 变量声明成 volatile 就可以了。
     *
     * 有些人认为使用 volatile 的原因是可见性，也就是可以保证线程在本地不会存有 instance 的副本，每次都是去主内存中读取。但其实是不对的。
     * 使用 volatile 的主要原因是其另一个特性：禁止指令重排序优化。
     * 也就是说，在 volatile 变量的赋值操作后面会有一个内存屏障（生成的汇编代码上），读操作不会被重排序到内存屏障之前。
     * 比如上面的例子，取操作必须在执行完 1-2-3 之后或者 1-3-2 之后，不存在执行到 1-3 然后取到值的情况。
     */
    public static SingletonDoubleCheck getInstance(){
        if (singletonDoubleCheck == null) {
            synchronized (SingletonDoubleCheck.class) {
                if (singletonDoubleCheck == null) {
                    singletonDoubleCheck = new SingletonDoubleCheck();
                }
            }
        }

        return singletonDoubleCheck;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        SingletonDoubleCheck instance1 = SingletonDoubleCheck.getInstance();
        SingletonDoubleCheck instance2 = SingletonDoubleCheck.getInstance();
        System.out.println(instance1 == instance2);
        System.out.println(System.currentTimeMillis() - start + "ms");
    }
}
