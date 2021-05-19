package com.bsoft.common.utils;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Auther: hy
 * @Date: 2020/6/17
 * @Description:
 */

public class BeanCopyUtil extends BeanUtilsBean {

    /**
     * @param dest 目标对象
     * @param orig 源对象
     * @param ignoreNullFlag 是否忽略null值
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public void copyProperties(Object dest, Object orig, boolean ignoreNullFlag) throws IllegalAccessException, InvocationTargetException {

        if (dest == null) {
            throw new IllegalArgumentException("No destination bean specified");
        }
        if (orig == null) {
            throw new IllegalArgumentException("No origin bean specified");
        }


        if (orig instanceof DynaBean) {
            DynaProperty[] origDescriptors = ((DynaBean) orig).getDynaClass().getDynaProperties();
            for (DynaProperty origDescriptor : origDescriptors) {
                String name = origDescriptor.getName();
                if (getPropertyUtils().isReadable(orig, name) && getPropertyUtils().isWriteable(dest, name)) {
                    Object value = ((DynaBean) orig).get(name);
                    if (ignoreNullFlag) {
                        if (value != null) {
                            copyProperty(dest, name, value);
                        }
                    } else {
                        copyProperty(dest, name, value);
                    }
                }
            }
        } else if (orig instanceof Map) {
            Map<String, Object> propMap = (Map<String, Object>) orig;
            for (Map.Entry<String, Object> entry : propMap.entrySet()) {
                String name = entry.getKey();
                Object value = entry.getValue();
                if (getPropertyUtils().isWriteable(dest, name)) {
                    if (ignoreNullFlag) {
                        if (value != null) {
                            copyProperty(dest, name, value);
                        }
                    } else {
                        copyProperty(dest, name, value);
                    }
                }
            }
        } else  {
            PropertyDescriptor[] origDescriptors = getPropertyUtils().getPropertyDescriptors(orig);
            for (PropertyDescriptor origDescriptor : origDescriptors) {
                String name = origDescriptor.getName();
                if ("class".equals(name)) {
                    continue;
                }
                if (getPropertyUtils().isReadable(orig, name) && getPropertyUtils().isWriteable(dest, name)) {
                    try {
                        Object value = getPropertyUtils().getSimpleProperty(orig, name);
                        if (ignoreNullFlag) {
                            if (value != null) {
                                copyProperty(dest, name, value);
                            }
                        } else {
                            copyProperty(dest, name, value);
                        }
                    } catch (NoSuchMethodException ignored) {
                    }
                }
            }
        }
    }
}