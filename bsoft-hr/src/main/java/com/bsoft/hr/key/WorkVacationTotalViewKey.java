package com.bsoft.hr.key;

import java.io.Serializable;

/**
 * @author: zy
 * @date: 2020/8/21
 * @description 员工加班调休假（总览）视图主键
 */
public class WorkVacationTotalViewKey implements Serializable {
    private String year;
    private String personId;
    private String deptId;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
}
