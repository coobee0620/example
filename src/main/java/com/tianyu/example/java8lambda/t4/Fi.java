package com.tianyu.example.java8lambda.t4;

@FunctionalInterface
public interface Fi<T, R> {
    R apply(T t);

    static void test() {
        System.out.println("aaa");
    }

    default void test1() {

    }

    default void test2() {

    }
}
