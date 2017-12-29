package com.tianyu.example.asm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TestJavaAgent
 *
 * @Author yu.tian@mtime.com
 * @Date 17/10/30 16:59
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestJavaAgent {
    String name() default "";
}
