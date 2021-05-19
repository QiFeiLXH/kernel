package com.bsoft.person.dto;

import java.io.Serializable;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/10 15:59
 * @Description
 */
public class PersonalTrainQueryCndDTO implements Serializable {
    /** 页码 */
    private Integer pageNo;
    /** 页量 */
    private Integer pageSize;
    /** 输入内容（姓名、拼音简码） */
    private String inputContent;
    /** 排序方式 1授课课时排序   2参训课时排序 */
    private Integer sortFlag;
    /** 年份 */
    private Integer year;
    /** 工号 */
    private String personId;
    /** 全部权限 */
    private Boolean allPermission;
    /** 部门id */
    private String deptId;

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

    public Integer getSortFlag() {
        return sortFlag;
    }

    public void setSortFlag(Integer sortFlag) {
        this.sortFlag = sortFlag;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
}
