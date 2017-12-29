package com.tianyu.example.bytebuddy;

import com.tianyu.example.asm.TestJavaAgent;

/**
 * HelloWorldImpl
 *
 * @Author yu.tian@mtime.com
 * @Date 17/11/15 16:13
 */
public class HelloWorldImpl implements HelloWorldInterface{
    @Override
    public String world() {
        return null;
    }

    @Override
    public String greet() {
        return null;
    }
//    @TestJavaAgent
    @Override
    public String hello() {
        System.out.println("hello in Impl");
        return "hello";
    }
}
