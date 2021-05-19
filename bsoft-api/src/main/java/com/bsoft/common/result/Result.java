package com.bsoft.common.result;

import java.io.Serializable;
import java.util.*;

public class Result<T> implements Serializable {
    private Integer totalCount;
    private Integer totalPages;
    private Integer pageSize;
    private Integer pageNumber;
    private List<T> records;
    private Map<String,Object> properties;
    private static final String DEFAULT_MSG = "success";

    public Result(){
        this.pageSize = 0;
        this.pageNumber = 1;
        this.totalCount = 0;
        this.records = Collections.EMPTY_LIST;
        this.totalPages = 0;
    }

    public Result(Integer totalCount,Integer pageSize,Integer pageNumber,Integer totalPages,List<T> records){
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.records = records;
        this.totalPages = totalPages;
    }

    public Result(int code,String msg,T t){
        this.totalCount = 0;
        records = new ArrayList<T>();
        records.add(t);
        this.pageSize = 1;
        this.pageNumber = 1;
    }

    public Result(Result result,List records){
        this.totalCount = result.getTotalCount();
        this.pageSize = result.getPageSize();
        this.pageNumber = result.getPageNumber();
        this.totalPages = result.getTotalPages();
        this.records = records;
    }

    public static <T> Result<T> empty(){
        List<T> records = Collections.EMPTY_LIST;
        return new Result<T>(0,0,0,0,records);
    }

    public Result(T t){
        this.totalCount = 1;
        records = new ArrayList<T>();
        records.add(t);
        this.pageSize = 1;
        this.pageNumber = 1;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setItems(List<T> records){
        this.records= records;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getItems(){
        return this.records == null ? Collections.emptyList() : this.records;
    }

    public void setProperty(String key,String value){
        if(this.properties == null ){
            this.properties = new HashMap<String,Object>();
        }
        this.properties.put(key,value);
    }

    public Object getProperty(String key){
        return this.properties == null ? null : this.properties.get(key);
    }

    public Map<String,Object> getProperties(){
        return this.properties;
    }
}
