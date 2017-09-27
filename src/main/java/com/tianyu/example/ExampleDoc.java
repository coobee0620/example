package com.tianyu.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ExampleDoc
 *
 * @Author yu.tian@mtime.com
 * @Date 17/9/20 09:40
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PACKAGE)
public @interface ExampleDoc {
    String desc();
}
