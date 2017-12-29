package com.tianyu.example.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bind.MethodNameEqualityResolver;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;
import net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder;

import static net.bytebuddy.matcher.ElementMatchers.isDeclaredBy;
import static net.bytebuddy.matcher.ElementMatchers.not;

/**
 * Run
 *
 * @Author yu.tian@mtime.com
 * @Date 17/11/15 14:26
 */
public class Run {
//    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
//        Agenter interceptor = new Agenter();
//        HelloWorld greeter = new ByteBuddy().subclass(HelloWorld.class)
//                .method(not(isDeclaredBy(Object.class)))
//                .intercept(MethodDelegation.withEmptyConfiguration()
//                        .withBinders(TargetMethodAnnotationDrivenBinder.ParameterBinder.DEFAULTS)
//                        .withResolvers(MethodNameEqualityResolver.INSTANCE, BindingPriority.Resolver.INSTANCE)
//                        .filter(not(isDeclaredBy(Object.class)))
//                        .to(interceptor)
//                )
//                .make()
//                .load(Run.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
//                .getLoaded()
//                .newInstance();
//
//        String result = greeter.greet();
//        System.out.println(result);
//    }
}
