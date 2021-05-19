package com.bsoft.system.processor;

import com.bsoft.common.result.Result;
import com.bsoft.common.spring.SpringContextUtil;
import com.bsoft.dictionary.annotation.Dictionary;
import com.bsoft.dictionary.manager.DictionaryLoader;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class DictionaryProcessorOld {
    private static final Logger logger = LoggerFactory.getLogger(DictionaryProcessorOld.class);
    public static void process(Object value){
        if(value instanceof Result || value instanceof List){
            List list = null;
            if(value instanceof Result){
                Result result = (Result)value;
                list = result.getItems();
            }else{
                list = (List) value;
            }

            if(list.size() > 0){
                Object object = list.get(0);
                String className = object.getClass().getSimpleName();
                String packageName = object.getClass().getPackageName();
                if(packageName.startsWith("com.bsoft")){
                    String doName = convertPackage(packageName) + "." + convertDO(className);
                    Class clazz = null;
                    try {
                        clazz = Class.forName(doName);



                        Field[] dtoFields = object.getClass().getDeclaredFields();
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
                                String dicName = dictionary.value();
                                Integer type = dictionary.type();
                                Object manager = SpringContextUtil.getBean(dicName);
                                if(manager instanceof DictionaryLoader){
                                    DictionaryLoader dictionaryManager = (DictionaryLoader)manager;
                                    Map<String,String> map = null;
                                    String fieldName = field.getName();
                                    for(Object o : list){
                                        try {
                                            Field field1 = object.getClass().getDeclaredField(fieldName);
                                            field1.setAccessible(true);
                                            Object oVal = field1.get(o);
                                            String v = null;
                                            if(oVal != null){
                                                String key = String.valueOf(oVal);
                                                if(type == 0){
                                                    v = dictionaryManager.getValue(key);
                                                }else{
                                                    v = dictionaryManager.getValue(type,key);
                                                }
                                            }
                                            Field field2 = object.getClass().getDeclaredField(fieldName + "Text");
                                            field2.setAccessible(true);
                                            field2.set(o,v);
                                        } catch (IllegalAccessException e) {
                                            e.printStackTrace();
                                        } catch (NoSuchFieldException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                    } catch (ClassNotFoundException e) {
                        logger.warn("找不到DO类，跳过字典处理");
                    }
                }

            }

        } else{
            if(value instanceof Object){
                Class object = value.getClass();
                String className = value.getClass().getSimpleName();
                String packageName = value.getClass().getPackageName();
                if(packageName.startsWith("com.bsoft")){
                    String doName = convertPackage(packageName) + "." + convertDO(className);
                    Class clazz = null;
                    try {
                        clazz = Class.forName(doName);
                        Field[] dtoFields = object.getClass().getDeclaredFields();
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
                                String dicName = dictionary.value();
                                Integer type = dictionary.type();
                                Object manager = SpringContextUtil.getBean(dicName);
                                if(manager instanceof DictionaryLoader){
                                    DictionaryLoader dictionaryManager = (DictionaryLoader)manager;
                                    Map<String,String> map = null;
                                    String fieldName = field.getName();
                                    try {
                                        Field field1 = object.getDeclaredField(fieldName);
                                        field1.setAccessible(true);
                                        Object oVal = field1.get(value);
                                        String v = null;
                                        if(oVal != null){
                                            String key = String.valueOf(oVal);
                                            if(type == 0){
                                                v = dictionaryManager.getValue(key);
                                            }else{
                                                v = dictionaryManager.getValue(type,key);
                                            }
                                        }

                                        Field field2 = object.getDeclaredField(fieldName + "Text");
                                        field2.setAccessible(true);
                                        field2.set(value,v);
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    } catch (NoSuchFieldException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    } catch (ClassNotFoundException e) {
                        logger.warn("找不到DO类，跳过字典处理");
                    }
                }

            }
        }
    }

    public static String convertDO(String name){
        return name.replace("DTO","DO");
    }
    public static String convertPackage(String name){
        return name.replace("dto","entity");
    }
}
