package com.tianyu.example.bytebuddy;

/**
 * Main
 *
 * @Author yu.tian@mtime.com
 * @Date 17/11/15 14:36
 */
public class Main {
    public static void main(String[] args) throws Exception {
        HelloWorld hw  = new HelloWorld();
        System.out.println(hw.hello());
        System.out.println(hw.world());
    }
}
