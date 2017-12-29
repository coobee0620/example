package com.tianyu.example.javaagent;

import com.tianyu.example.asm.TestJavaAgent;
import com.tianyu.example.asm.TestJavaAgent2;
import com.tianyu.example.bytebuddy.intercetor.Agenter;
import com.tianyu.example.bytebuddy.intercetor.FindOneInterceptor;
import com.tianyu.example.bytebuddy.intercetor.Interceptor;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.utility.JavaModule;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

import static net.bytebuddy.matcher.ElementMatchers.*;

/**
 * Premain
 *
 * @Author yu.tian@mtime.com
 * @Date 17/11/2 17:26
 */
public class Premain {
    public static void premain(String agentArgs,Instrumentation inst)
            throws ClassNotFoundException,UnmodifiableClassException {
        new AgentBuilder.Default()
                //根据包名匹配
                .type(nameStartsWith("com.tianyu.example.bytebuddy"))
                //根据方法名上使用的注解匹配
                //.type(isAnnotatedWith(ToString.class))
                //根据类名包括关键字匹配
//                .type(nameContains("Hello"))
                .and(not(isInterface()))
                .and(not(isAbstract()))
                .transform((builder,typeDescription,classLoader,module) -> builder
                        //匹配哪些方法
                        .method(isAnnotatedWith(TestJavaAgent.class).or(isAnnotatedWith(TestJavaAgent2.class)))
                        //拦截过滤器设置
                        .intercept(MethodDelegation.to(Interceptor.class))
                ).with(new AgentBuilder.Listener(){
            @Override
            public void onDiscovery(String typeName, ClassLoader classLoader, JavaModule module, boolean loaded) {
            }

            @Override
            public void onTransformation(TypeDescription typeDescription, ClassLoader classLoader, JavaModule module, boolean loaded, DynamicType dynamicType) {
            }

            @Override
            public void onIgnored(TypeDescription typeDescription, ClassLoader classLoader, JavaModule module, boolean loaded) {
            }

            @Override
            public void onError(String typeName, ClassLoader classLoader, JavaModule module, boolean loaded, Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onComplete(String typeName, ClassLoader classLoader, JavaModule module, boolean loaded) {
            }

//            @Override
//            public void onTransformation(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule,
//                                         DynamicType dynamicType) {
//
//            }
//
//            @Override
//            public void onIgnored(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule) {
//
//            }
//
//            @Override
//            public void onError(String s, ClassLoader classLoader, JavaModule javaModule, Throwable throwable) {
//                throwable.printStackTrace();
//            }
//
//            @Override
//            public void onComplete(String s, ClassLoader classLoader, JavaModule javaModule) {
//
//            }
        }).installOn(inst);
    }
}
