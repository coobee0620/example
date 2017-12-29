package com.tianyu.example.bytebuddy;

import com.tianyu.example.asm.TestJavaAgent;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.ExceptionMethod;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * FirstByteBuddyHelloWorld
 *
 * @Author yu.tian@mtime.com
 * @Date 17/11/14 13:41
 */
public class FirstByteBuddyHelloWorld {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class<?> dynamicType = new ByteBuddy()
                .subclass(Object.class)
                .method(ElementMatchers.named("toString"))
                .intercept(FixedValue.value("Hello World!"))
                .name("com.mtime.aaa.Dy")
                .make()
                .load(FirstByteBuddyHelloWorld.class.getClassLoader())
                .getLoaded();

        Class<?> fromReflect = Class.forName("com.mtime.aaa.Dy");
        System.out.println(fromReflect.getName());
        System.out.println(fromReflect.newInstance().toString());
        System.out.println(fromReflect.hashCode());

        System.out.println(dynamicType.getName());
        System.out.println(dynamicType.newInstance().toString());
        System.out.println(dynamicType.hashCode());

    }
}
