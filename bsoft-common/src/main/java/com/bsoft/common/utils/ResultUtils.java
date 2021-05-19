package com.bsoft.common.utils;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.result.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class ResultUtils {

    public static <T> Result<T> parseResult(Page<T> page){
        if (page.isEmpty()) return emptyResult();
        int totalCount = Math.toIntExact(page.getTotalElements());
        int pageNumber = page.getPageable().getPageNumber();
        int pageSize = page.getPageable().getPageSize();
        List<T> records = page.getContent();
        int totalPages = page.getTotalPages();

        return new Result<T>(totalCount,pageSize,pageNumber,totalPages,records);
    }

    public static <T,S> Result<S> parseResult(PageInfo<T> page,List<S> records){
        int totalCount = Math.toIntExact(page.getTotal());
        int pageNumber = 0;
        int pageSize = 0;
        int totalPages = 0;
        if (totalCount >0){
            pageNumber = page.getPageNum();
            pageSize = page.getPageSize();
            totalPages = page.getPages();
        }

        return new Result<S>(totalCount,pageSize,pageNumber,totalPages,records);
    }

    public static <T,S> Result<S> parseResult(Page<T> page,List<S> records){
        if (page.isEmpty()) return emptyResult();
        int totalCount = (int) page.getTotalElements();
        int pageNumber = page.getPageable().getPageNumber();
        int pageSize = page.getPageable().getPageSize();
        int totalPages = page.getTotalPages();

        return new Result<S>(totalCount,pageSize,pageNumber,totalPages,records);
    }

    public static <T> Result<T> parseResult(List<T> list,Integer count){
        if(list.size() == 0) return emptyResult();
        int totalCount = count;
        int pageNumber = 1;
        int pageSize = 25;
        int totalPages = 1;
        return new Result<T>(totalCount,pageSize,pageNumber,totalPages,list);
    }

    public static <T> Result<T> parseResult(List<T> list,Integer count,Integer pageNumber,Integer pageSize,Integer totalPages){
        if(list.size() == 0) return emptyResult();
        return new Result<T>(count,pageSize,pageNumber,totalPages,list);
    }

    public static <T> Result<T> parseResult(T t){
        return t==null ? emptyResult() : new Result<T>(t);
    }

    public static <S> Result<S> parseResult(Result result,List record){
        return new Result<S>(result,record);
    }

    private static <T> Result<T> emptyResult(){
        return Result.empty();
    }


    public static <T,S> Result<S> parseResult(Page<T> page,Class clazz){
        List<S> list = GeneratorUtil.instance().convert(page.getContent(),clazz);
        return parseResult(page,list);
    }

    public static <T,S> Result<S> parseResult(PageInfo<T> page,Class clazz){
        List<S> list = GeneratorUtil.instance().convert(page.getList(),clazz);
        return parseResult(page,list);
    }

    public static <T> Result<T> parseResult(PageInfo<T> page){
        List<T> list = page.getList();
        return parseResult(page,list);
    }
}
