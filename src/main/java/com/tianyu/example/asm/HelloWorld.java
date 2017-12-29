package com.tianyu.example.asm;

/**
 * FirstByteBuddyHelloWorld
 *
 * @Author yu.tian@mtime.com
 * @Date 17/10/30 15:43
 */
public class HelloWorld {
    @TestJavaAgent(name = "1111")
    public HelloWorld sayHello() throws Exception {
////        try {
////            System.out.println("Hello world!");
////            long a = 10/0;
//////            throw new Exception("aa");
////        } catch (Exception e) {
////            System.out.println(e.getMessage());
////            throw e;
////        }
//        if (aa > 0) {
//            try {
//                try {
//                    System.out.println("Hello if!");
//                    long a = 10/0;
//                    return new FirstByteBuddyHelloWorld();
//                } catch (Exception e) {
//                    System.out.println("inject 1");
//                    throw e;
//                }
//            } catch (Exception e) {
//                System.out.println("in");
//                throw e;
//            }
//        } else {
//            try {
//                System.out.println("Hello else!");
//                return new FirstByteBuddyHelloWorld();
//            } catch (Exception e) {
//                System.out.println("jnject 2");
//                throw e;
//            }
//        }
        HelloWorld inject = new HelloWorld();
        int a =1;
        HelloWorld ret = new HelloWorld();
        inject.toString();
        return ret;
    }

    public static void main(String[] args) throws Exception {
        new HelloWorld().sayHello();
    }
}
