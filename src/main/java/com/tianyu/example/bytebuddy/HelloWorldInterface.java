package com.tianyu.example.bytebuddy;

import com.tianyu.example.asm.TestJavaAgent;

/**
 * HelloWorld
 *
 * @Author yu.tian@mtime.com
 * @Date 17/11/14 14:19
 */
public interface HelloWorldInterface {
    @TestJavaAgent
    String hello();
    @TestJavaAgent
    public String world();
    @TestJavaAgent
    public String greet();

}
