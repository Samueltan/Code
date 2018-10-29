package com.sample.effective;
class A {

    @SuppressWarnings("unused")
    //终结守卫者
    private final Object finalizerGuardian = new Object() {

        @Override
        //终结守卫者的终结方法将被执行
        protected void finalize() {
            System.out.println("A finalize by the finalizerGuardian");
        }
    };


    @Override
    //由于终结方法被子类覆盖，该终结方法并不会被执行
    protected void finalize() {
        System.out.println("A finalize by the finalize method");
    }


    public static void main(String[] args) throws Exception {
        B b = new B();
        b = null;
        System.gc();
        Thread.sleep(500);
    }
}

class B extends A {

    @Override
    public void finalize() {
        System.out.println("B finalize by the finalize method");
    }

}