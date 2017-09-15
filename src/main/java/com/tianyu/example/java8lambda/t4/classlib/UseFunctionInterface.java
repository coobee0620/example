package com.tianyu.example.java8lambda.t4.classlib;


import com.tianyu.example.java8lambda.t4.Fi;

public class UseFunctionInterface {
    public static void main(String[] args) {
        Fi<String,String> fi = (a) -> a;

        String bbbb = fi.apply("aaaa");
        System.out.println(bbbb);
    }
}
