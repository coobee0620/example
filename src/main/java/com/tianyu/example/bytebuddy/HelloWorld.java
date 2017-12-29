package com.tianyu.example.bytebuddy;

import com.tianyu.example.asm.TestJavaAgent;
import com.tianyu.example.asm.TestJavaAgent2;

/**
 * HelloWorld
 *
 * @Author yu.tian@mtime.com
 * @Date 17/11/14 14:19
 */
public class HelloWorld {
    @TestJavaAgent
    @TestJavaAgent2
    public String hello() {
        return "hello";
    }
    @TestJavaAgent2
    public String world() {
        return "world";
    }
    @TestJavaAgent
    public String greet() {
        return hello() + " " + world();
    }

}
