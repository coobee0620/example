package com.tianyu.example.asm;

/**
 * HelloWorldASM
 *
 * @Author yu.tian@mtime.com
 * @Date 17/11/6 10:20
 */
public class HelloWorldASM {
    public void sayHello(){
        System.out.println("helloWorld....");
    }

    public static void main(String[]args) throws Exception {
        AsmAopGenerator aag = new AsmAopGenerator();
        HelloWorld hw = (HelloWorld) aag.proxy(HelloWorld.class, "sayHello", "it's begin", "it's end");
        hw.sayHello();
    }
}
