package com.bsoft.system.processor;

import com.bsoft.common.result.Result;
import com.bsoft.common.spring.SpringContextUtil;
import com.bsoft.dictionary.annotation.Dictionary;
import com.bsoft.dictionary.manager.DictionaryLoader;
import com.bsoft.system.utils.DictionaryProxyUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class DictionaryProcessor {
    public static Object process(Object value){
        if(value instanceof Result || value instanceof List){
            List list = null;
            if(value instanceof Result){
                Result result = (Result)value;
                list = result.getItems();
            }else{
                list = (List) value;
            }
            return DictionaryProxyUtils.processList(list);

        } else{
            if(value instanceof Object){
                return DictionaryProxyUtils.processObject(value);
            }
        }
        return value;
    }

}
