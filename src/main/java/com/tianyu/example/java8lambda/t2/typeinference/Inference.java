package com.tianyu.example.java8lambda.t2.typeinference;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class Inference {
    public static void main(String[] args) {
        /*
        * 接口函数方法签名
        * boolean test(T t);
        * */
        Predicate<Integer> atLeast5 = x -> x >5;

        /*
        * 接口函数方法签名
        * R apply(T t, U u);
        * */
        BinaryOperator<Long> addLongs = (x,y) -> x + y;

//        BinaryOperator addLongs = (x,y) -> x + y;
    }
}
