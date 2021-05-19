package com.bsoft.system.utils;

import com.bsoft.common.proxy.CglibBean;
import com.bsoft.common.spring.SpringContextUtil;
import com.bsoft.dictionary.annotation.Dictionary;
import com.bsoft.dictionary.manager.DictionaryLoader;
import com.bsoft.system.dictionary.DictionaryDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DictionaryProxyUtils {
    private static final Logger logger = LoggerFactory.getLogger(DictionaryProxyUtils.class);

    public static List<Object> processList(List list){
        List<Object> objectList = new ArrayList<>();
        if(list.size() > 0){
            Object object = list.get(0);
            try {
                DictionaryDefinition dictionaryDefinition = DictionaryDefinition.instance(object);

                for(int i=0;i<list.size();i++){
                    Object o = list.get(i);
                    Object proxyObject = createProxy(o,dictionaryDefinition);
                    objectList.add(proxyObject);
                }
            } catch (IllegalAccessException e) {
                logger.info(e.getMessage());
            }


        }

        return objectList;
    }

    public static Object processObject(Object object){

        if(object != null){
            try {
                DictionaryDefinition dictionaryDefinition = DictionaryDefinition.instance(object);
                object = createProxy(object,dictionaryDefinition);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return object;
    }

    private static Object createProxy(Object o,DictionaryDefinition dictionaryDefinition) throws IllegalAccessException {
        Map<String,Dictionary> map = dictionaryDefinition.getDicMap();
        Map<String,Class> propertyMap = dictionaryDefinition.getPropertyMap();
        Map<String,Map<String,String>> dicValueMap = dictionaryDefinition.getDicValueMap();
        CglibBean bean = new CglibBean(o.getClass(),propertyMap);
        Map<String,String> propertyValueMap = getPropertyValueMap(map,o,dicValueMap);
        for(Map.Entry<String,String> entry : propertyValueMap.entrySet()){
            String name = entry.getKey();
            String value = entry.getValue();
            bean.setValue(name,value);
        }

        Object object = bean.getObject();
        BeanUtils.copyProperties(o,object);
        return object;
    }


    private static Map<String,String> getPropertyValueMap(Map<String,Dictionary> map,Object o,Map<String,Map<String,String>> dicValueMap){
        Map<String,String> propertyValueMap = new HashMap<>();
        for (Map.Entry<String, Dictionary> entry : map.entrySet()) {
            String name = entry.getKey() + "Text";
            Map<String,String> valueMap = dicValueMap.get(name);
            String fieldValue = getFieldValue(o,entry.getKey());
            String value = valueMap.get(fieldValue);
            propertyValueMap.put(name,value);
        }
        return propertyValueMap;
    }

    private static String getFieldValue(Object o,String fieldName){
        String value = null;
        try {
            Field field = o.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            value = String.valueOf(field.get(o));
        } catch (NoSuchFieldException e) {
            logger.info("找不到字段，不处理字典");
        } catch (IllegalAccessException e) {
            logger.info("找不到字段值，不处理字典");
        }
        return value;
    }
}
