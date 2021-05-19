package com.bsoft.dictionary.annotation.dept;

import com.bsoft.dictionary.annotation.Dictionary;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Dictionary("DeptAllDic")
public @interface DeptAllDic {

}
