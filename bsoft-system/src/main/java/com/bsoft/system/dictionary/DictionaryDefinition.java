package com.bsoft.system.dictionary;

import com.bsoft.common.spring.SpringContextUtil;
import com.bsoft.dictionary.annotation.Dictionary;
import com.bsoft.dictionary.manager.DictionaryLoader;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class DictionaryDefinition {
    private Map<String, Dictionary> dicMap;
    private Map<String,Class> propertyMap;
    private Map<String,Map<String,String>> dicValueMap;

    private DictionaryDefinition(Map<String,Dictionary> dicMap,Map<String,Class> propertyMap,Map<String,Map<String,String>> dicValueMap){
        this.dicMap = dicMap;
        this.propertyMap = propertyMap;
        this.dicValueMap = dicValueMap;
    }

    public static DictionaryDefinition instance(Object o) throws IllegalAccessException {
        Map<String, Dictionary> dicMap = resovleDic(o);
        Map<String,Class> propertyMap = getPropertyMap(dicMap);
        Map<String,Map<String,String>> dicValueMap = resovleDicValue(dicMap);
        return new DictionaryDefinition(dicMap,propertyMap,dicValueMap);
    }

    private static Map<String, Dictionary> resovleDic(Object o) throws IllegalAccessException {
        Map<String,Dictionary> map = new HashMap<>();
        Class clazz = getDoClass(o);
        Field[] doFields = clazz.getDeclaredFields();
        for(Field field : doFields){
            Dictionary dictionary = null;
            if(field.isAnnotationPresent(Dictionary.class)){
                dictionary = field.getAnnotation(Dictionary.class);
            }else{
                Annotation[] annotations = field.getAnnotations();
                for(Annotation annotation : annotations){
                    if(annotation.annotationType().isAnnotationPresent(Dictionary.class)){
                        dictionary = annotation.annotationType().getAnnotation(Dictionary.class);
                    }
                }
            }
            if(dictionary != null){
                String fieldName = field.getName();
                map.put(fieldName,dictionary);
            }
        }
        return map;
    }

    private static Map<String,Map<String,String>> resovleDicValue(Map<String,Dictionary> map){
        Map<String,Map<String,String>> dicValueMap = new HashMap<>();
        for (Map.Entry<String, Dictionary> entry : map.entrySet()) {
            String name = entry.getKey() + "Text";
            Dictionary dictionary = entry.getValue();
            String dicName = dictionary.value();
            Integer type = dictionary.type();
            Object manager = SpringContextUtil.getBean(dicName);
            if(manager instanceof DictionaryLoader){
                DictionaryLoader dictionaryManager = (DictionaryLoader)manager;
                Map<String,String> dicMap = null;
//                if(type == 0){
//                    dicMap = dictionaryManager.getDictionary();
//                }else{
//                    dicMap = dictionaryManager.getDictionary(type);
//                }

                dicValueMap.put(name,dicMap);
            }
        }
        return dicValueMap;
    }

    private static Class getDoClass(Object o) throws IllegalAccessException {
        String className = o.getClass().getSimpleName();
        String packageName = o.getClass().getPackageName();
        if(!isBsoftClass(packageName)){
            throw new IllegalAccessException("不是bsoft类，不处理该字典");
        }
        String doName = convertPackage(packageName) + "." + convertDO(className);
        Class clazz = null;
        try {
            clazz = Class.forName(doName);
        } catch (ClassNotFoundException e) {
            throw new IllegalAccessException("无法找到DO类，不处理该DTO字典");
        }
        return clazz;
    }

    private static Map<String,Class> getPropertyMap(Map<String,Dictionary> map){
        Map<String,Class> propertyMap = new HashMap<>();
        for (Map.Entry<String, Dictionary> entry : map.entrySet()) {
            String name = entry.getKey() + "Text";
            Dictionary dictionary = entry.getValue();
            propertyMap.put(name,String.class);
        }
        return propertyMap;
    }

    private static Boolean isBsoftClass(String packageName){
        return packageName.startsWith("com.bsoft");
    }

    private static String convertDO(String name){
        return name.replace("DTO","DO");
    }
    private static String convertPackage(String name){
        return name.replace("dto","entity");
    }

    public Map<String, Dictionary> getDicMap() {
        return dicMap;
    }


    public Map<String, Class> getPropertyMap() {
        return propertyMap;
    }

    public Map<String, Map<String, String>> getDicValueMap() {
        return dicValueMap;
    }
}
