package com.bsoft.common.validate;

import com.bsoft.exception.ServiceException;
import org.hibernate.validator.internal.engine.path.PathImpl;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;

public class ValidateUtil {
    /**
     * 校验实体类
     *
     * @param t
     * @return
     */
    public static <T> List<Map> validate(T t) {
        //定义返回错误List
        List<Map> errList = new ArrayList<>();
        Map<String, String> errorMap;

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> errorSet = validator.validate(t);

        for (ConstraintViolation<T> c : errorSet) {
            errorMap = new HashMap<>();
            errorMap.put("field", c.getPropertyPath().toString()); //获取发生错误的字段
            errorMap.put("msg", c.getMessage()); //获取校验信息
            errList.add(errorMap);
        }

        return errList;
    }

    /**
     * 校验实体类
     *
     * @param t
     * @return
     */
    public static <T> void check(T t) {
        //定义返回错误List
        List<Map> errList = new ArrayList<>();
        Map<String, String> errorMap;

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> errorSet = validator.validate(t);
        StringBuilder builder = new StringBuilder("");
        for (ConstraintViolation<T> c : errorSet) {
            builder.append(c.getMessage());
        }
        if(errorSet.size() > 0){
            throw new ServiceException(builder.toString());
        }
        return;
    }

    /**
     * 使用 ValidList 校验List, 返回对应索引和错误消息
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> List<Map> validateList(T t) {
        //定义返回错误List
        List<Map> errList = new ArrayList<>();
        Map<String, Object> errorMap;

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> errorSet = validator.validate(t);

        for (ConstraintViolation<T> c : errorSet) {
            errorMap = new HashMap<>();
            int index = ((PathImpl) c.getPropertyPath()).getLeafNode().getIndex();
            errorMap.put("index", index); // 当前索引
            errorMap.put("field", c.getPropertyPath().toString()); //获取发生错误的字段
            errorMap.put("msg", c.getMessage()); //获取校验信息
            errList.add(errorMap);
        }

        return errList;
    }
}
