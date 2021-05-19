package com.bsoft.sales.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/4/19 13:07
 * @Description
 */
public class SalesContractCheckQueryCndDTO implements Serializable {
    /** 页码 */
    private Integer pageNo;
    /** 页量 */
    private Integer pageSize;
    /** 输入内容 */
    private String inputContent;
    /** 核对 */
    private List<Integer> checkedFlag;
    /** 工号 */
    private String personId;
    /** 全部权限 */
    private Boolean allPermission;

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

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }

    public List<Integer> getCheckedFlag() {
        return checkedFlag;
    }

    public void setCheckedFlag(List<Integer> checkedFlag) {
        this.checkedFlag = checkedFlag;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Boolean getAllPermission() {
        return allPermission;
    }

    public void setAllPermission(Boolean allPermission) {
        this.allPermission = allPermission;
    }
}
