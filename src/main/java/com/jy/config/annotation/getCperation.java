package com.jy.config.annotation;

import java.lang.annotation.*;

/*
记录操作 注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface getCperation {
    public String value() default  "";
}
