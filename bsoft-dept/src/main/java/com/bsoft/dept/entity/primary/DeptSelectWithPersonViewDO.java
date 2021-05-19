package com.bsoft.dept.entity.primary;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/1/25 15:47
 * @Description:
 */
public class DeptSelectWithPersonViewDO {
    private String value;
    private String title;
    private String parentId;
    private Integer logout;
    private Integer deptType;
    private String simpleCode;
    private Integer sortBy;
    private Integer personNum;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getLogout() {
        return logout;
    }

    public void setLogout(Integer logout) {
        this.logout = logout;
    }

    public Integer getDeptType() {
        return deptType;
    }

    public void setDeptType(Integer deptType) {
        this.deptType = deptType;
    }

    public String getSimpleCode() {
        return simpleCode;
    }

    public void setSimpleCode(String simpleCode) {
        this.simpleCode = simpleCode;
    }

    public Integer getSortBy() {
        return sortBy;
    }

    public void setSortBy(Integer sortBy) {
        this.sortBy = sortBy;
    }

    public Integer getPersonNum() {
        return personNum;
    }

    public void setPersonNum(Integer personNum) {
        this.personNum = personNum;
    }
}
