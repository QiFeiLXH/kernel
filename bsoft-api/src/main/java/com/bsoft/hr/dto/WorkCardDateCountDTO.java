package com.bsoft.hr.dto;


import java.io.Serializable;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/15 17:26
 * @Description
 */
public class WorkCardDateCountDTO implements Serializable {
    private String dateStr;
    private Integer count;

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
