package com.bsoft.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
 * @author  hy
 * @date  2020/4/15 17:23
 * @description 公用事务
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.PARAMETER})
public @interface ManyTransaction {
    String[] value() default {};
}
