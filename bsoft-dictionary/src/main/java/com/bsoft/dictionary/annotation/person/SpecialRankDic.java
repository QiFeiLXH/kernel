package com.bsoft.dictionary.annotation.person;

import com.bsoft.dictionary.annotation.Dictionary;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Dictionary(value = "PublicDic",type = 3002)
public @interface SpecialRankDic {

}
