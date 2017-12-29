package com.tianyu.example.bytebuddy.intercetor;

import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/**
 * Date:2017/11/5
 * Name:chao.cheng
 **/
public class FindOneInterceptor {

    public static String intercept(@SuperCall Callable<?> call, @Origin Method method, @AllArguments Object[] arguments) {
        long startTime = System.currentTimeMillis();
        String rtnCtx = "";
        if(arguments.length > 0) {
            return "参数大于0个,并且打印第一个参数" + arguments[0];
        } else {
            try {
                //方法拦截后,调用call方法,程序继续执行
                call.call();
                Thread.sleep(1000);
                long endTime = System.currentTimeMillis();
                System.out.println("方法:"+method.getName()+"的执行时间是:"+(endTime-startTime));
                rtnCtx = "方法:"+method.getName()+"的执行时间是:"+(endTime-startTime);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return rtnCtx;
        }
    }
}
