package com.bsoft.common.dozer;

import com.bsoft.common.result.Result;
import com.bsoft.common.spring.SpringContextUtil;
import com.bsoft.file.document.common.result.FileResult;
import com.bsoft.workflow.common.result.WFResult;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.*;

@Component
public class GeneratorUtil implements IGenerator {
    @Autowired
    protected Mapper dozerMapper;

    public <T, S> T convert(S s, Class<T> clz) {
        if (s == null) {
            return null;
        }
        return this.dozerMapper.map(s, clz);
    }

    public <T,S> void convert(S s,T t){
        if (s == null) {
            return;
        }
        this.dozerMapper.map(s, t);
    }

    public <T, S> List<T> convert(List<S> s, Class<T> clz) {
        if (s == null) {
            return null;
        }
        List<T> list = new ArrayList<T>();
        for (S vs : s) {
            list.add(this.dozerMapper.map(vs, clz));
        }
        return list;
    }

    public <T, S,W> Map<S,T> convert(Map<S,W> s, Class<T> clz) {
        if (s == null) {
            return null;
        }
        Map<S,T> map = new HashMap<>();
        for(Map.Entry<S,W> entry : s.entrySet()){
            S key = entry.getKey();
            W value = entry.getValue();
            T tValue = this.dozerMapper.map(value, clz);
            map.put(key,tValue);
        }
        return map;
    }

    public <T, S> Set<T> convert(Set<S> s, Class<T> clz) {
        if (s == null) {
            return null;
        }
        Set<T> set = new HashSet<T>();
        for (S vs : s) {
            set.add(this.dozerMapper.map(vs, clz));
        }
        return set;
    }

    public <T, S> T[] convert(S[] s, Class<T> clz) {
        if (s == null) {
            return null;
        }
        @SuppressWarnings("unchecked")
        T[] arr = (T[]) Array.newInstance(clz, s.length);
        for (int i = 0; i < s.length; i++) {
            arr[i] = this.dozerMapper.map(s[i], clz);
        }
        return arr;
    }

    @Override
    public <T, S> Result<T> convert(Result<S> s, Class<T> clz) {
        if (s == null) {
            return null;
        }
        List<T> list = new ArrayList<T>();
        Result<T> result = new Result<T>();
        List<S> l = s.getItems();
        for (S vs : l) {
            list.add(this.dozerMapper.map(vs, clz));
        }
        result.setItems(list);
        result.setTotalPages(s.getTotalPages());
        result.setTotalCount(s.getTotalCount());
        result.setPageSize(s.getPageSize());
        result.setPageNumber(s.getPageNumber());
        return result;
    }

    public <T, S> Result<T> convert(WFResult<S> s, Class<T> clz) {
        if (s == null) {
            return null;
        }
        List<T> list = new ArrayList<T>();
        Result<T> result = new Result<T>();
        List<S> l = s.getItems();
        for (S vs : l) {
            list.add(this.dozerMapper.map(vs, clz));
        }
        result.setItems(list);
        result.setTotalPages(s.getTotalPages());
        result.setTotalCount(s.getTotalCount());
        result.setPageSize(s.getPageSize());
        result.setPageNumber(s.getPageNumber());
        return result;
    }

    public <T, S> Result<T> convert(FileResult<S> s, Class<T> clz) {
        if (s == null) {
            return null;
        }
        List<T> list = new ArrayList<T>();
        Result<T> result = new Result<T>();
        List<S> l = s.getItems();
        for (S vs : l) {
            list.add(this.dozerMapper.map(vs, clz));
        }
        result.setItems(list);
        result.setTotalPages(s.getTotalPages());
        result.setTotalCount(s.getTotalCount());
        result.setPageSize(s.getPageSize());
        result.setPageNumber(s.getPageNumber());
        return result;
    }

    public static GeneratorUtil instance(){
        return SpringContextUtil.getBean(GeneratorUtil.class);
    }
}
