package com.bsoft.work.condition;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/12/2
 * @description 行政用品名称查询参数
 */
public class ApplianceNameQueryCnd {
    /** 注销标志列表*/
    private List<Integer> logoutList;
    /** 物品类别*/
    private Integer applianceType;
    /** 输入内容*/
    private String inputContent;
    /** 页码*/
    private Integer pageNo;
    /** 每页条数*/
    private Integer pageSize;

    public List<Integer> getLogoutList() {
        return logoutList;
    }

    public void setLogoutList(List<Integer> logoutList) {
        this.logoutList = logoutList;
    }

    public Integer getApplianceType() {
        return applianceType;
    }

    public void setApplianceType(Integer applianceType) {
        this.applianceType = applianceType;
    }

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
