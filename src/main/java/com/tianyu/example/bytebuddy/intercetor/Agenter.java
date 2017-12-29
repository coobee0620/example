package com.tianyu.example.bytebuddy.intercetor;

import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/**
 * Agenter
 *
 * @Author yu.tian@mtime.com
 * @Date 17/11/15 10:54
 */
public class Agenter {
//    @RuntimeType
//    public static Object _default(@SuperCall Callable<?> zuper, @Origin Method method, @AllArguments Object[] arguments) throws Exception {
//        System.out.println("Agenter#_default");
//        return zuper.call();
//    }

//    @RuntimeType
//    public String hello(@SuperCall Callable<String> zuper) throws Exception {
//        return zuper.call().toUpperCase();
//    }

//    @RuntimeType
//    public String world(@SuperCall Callable<String> zuper) throws Exception {
//        return zuper.call().toUpperCase();
//    }

    @RuntimeType
    public static Object profile(@Origin Method m, @SuperCall Callable<?> c) throws Exception {
        Annotation[] as = m.getAnnotations();
        for (Annotation a : as) {
            System.out.println(a.toString());
        }
        System.out.println("Agenter#profile");
        long start = System.nanoTime();
        try {
            return c.call();
        } finally {
            long end = System.nanoTime();
            System.out.println("Call to " + m + " took " + (end - start) +" ns");
        }
    }

}
