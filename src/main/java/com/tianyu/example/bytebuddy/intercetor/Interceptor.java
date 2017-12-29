package com.tianyu.example.bytebuddy.intercetor;

import com.tianyu.example.asm.TestJavaAgent;
import com.tianyu.example.asm.TestJavaAgent2;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/**
 * Date:2017/11/2
 * Name:chao.cheng
 **/
//@SuppressWarnings("rawtypes")
public class Interceptor {
    @RuntimeType
    public static Object intercept(@SuperCall Callable<?> callable, @Origin Method method,@AllArguments Object[] allArguments) throws Exception {
        long startTime = System.currentTimeMillis();
        TestJavaAgent javaAgent = method.getAnnotation(TestJavaAgent.class);
        System.out.println(javaAgent == null ? "javaAgent anno is null" : "javaAgent anno is" + javaAgent.name());
        TestJavaAgent2 javaAgent2 = method.getAnnotation(TestJavaAgent2.class);
        System.out.println(javaAgent2 == null ? "javaAgent2 anno is null" : "javaAgent2 anno is" + javaAgent2.name());
        Object response = null;
        try{
            System.out.println("aaaaa");
            response = callable.call();
        }
        catch(Exception e) {
            System.out.println("Exception occurred in method call: " +  (System.currentTimeMillis() - startTime) + " Exception = " + e);
            throw e;
        }
        finally{
            System.out.println("Method " + (System.currentTimeMillis() - startTime) + " completed in " + (System.currentTimeMillis() - startTime) + " miliseconds");
        }
        return response;
    }

}
