package com.sample.basic.java8.methodreference.typemethod;

public class TriFunctionTest {
    public static void main(String[] args) {
        TriFunction<Sum, String, String, Integer> anon =
                new TriFunction<Sum, String, String, Integer>() {
                    @Override
                    public Integer apply(Sum s, String arg1, String arg2) {
                        return s.doSum(arg1, arg2);
                    }
                };
        System.out.println(anon.apply(new Sum(), "1", "4"));

        TriFunction<Sum, String, String, Integer> lambda =
                (sum, s1, s2) -> sum.doSum(s1, s2);
        System.out.println(lambda.apply(new Sum(), "2", "5"));

        TriFunction<Sum, String, String, Integer> mRef = Sum::doSum;
        System.out.println(mRef.apply(new Sum(), "3", "6"));
    }
}
