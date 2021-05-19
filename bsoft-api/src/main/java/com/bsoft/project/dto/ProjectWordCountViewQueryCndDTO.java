package com.bsoft.project.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author: zy
 * @date: 2021/4/26
 * @description 仅用于项目文档上传情况统计页面模糊查询
 */
public class ProjectWordCountViewQueryCndDTO implements Serializable {
    /** 签订日期开始*/
    private Date signDateStart;
    /** 签订日期结束*/
    private Date signDateEnd;
    /** 部门*/
    private String dept;
    /** 文本搜索*/
    private String inputContent;
    /** 合同号列表（根据进度经理筛选得来）*/
    private List<String> contractNoList;
    /** 页码*/
    private Integer pageNo;
    /** 条目*/
    private Integer pageSize;
    /** 文件筛选*/
    private List<String> requireList;

    public Date getSignDateStart() {
        return signDateStart;
    }

    public void setSignDateStart(Date signDateStart) {
        this.signDateStart = signDateStart;
    }

    public Date getSignDateEnd() {
        return signDateEnd;
    }

    public void setSignDateEnd(Date signDateEnd) {
        this.signDateEnd = signDateEnd;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }

    public List<String> getContractNoList() {
        return contractNoList;
    }

    public void setContractNoList(List<String> contractNoList) {
        this.contractNoList = contractNoList;
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

    public List<String> getRequireList() {
        return requireList;
    }

    public void setRequireList(List<String> requireList) {
        this.requireList = requireList;
    }
}
