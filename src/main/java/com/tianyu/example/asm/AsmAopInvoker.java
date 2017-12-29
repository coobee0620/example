package com.tianyu.example.asm;

/**
 * AsmAopInvoker
 *
 * @Author yu.tian@mtime.com
 * @Date 17/11/6 10:20
 */
public class AsmAopInvoker {
    public static void methodEnd(String evtID){
        System.out.println(evtID);
    }

    public static void methodStart(String evtID){
        System.out.println(evtID);
    }
}
