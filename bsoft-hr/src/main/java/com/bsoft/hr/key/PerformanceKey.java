package com.bsoft.hr.key;

import java.io.Serializable;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/17 14:39
 * @Description 年度绩效联合主键
 */

public class PerformanceKey implements Serializable {
    /** 员工工号 */
    private String personId;
    private Integer year;


    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
