package com.sample.basic.java8.methodreference.typemethod;

interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}