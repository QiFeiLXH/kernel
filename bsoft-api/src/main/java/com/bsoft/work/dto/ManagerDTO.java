package com.bsoft.work.dto;

import java.io.Serializable;

/**
 * @Author ding cj
 * @Date 2021/5/14 9:36
 * @Description
 */
public class ManagerDTO implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 委员会id
     */
    private Integer councilId;

    /**
     * 工号
     */
    private Integer personId;

    /**
     * 姓名
     */
    private String personName;

    /**
     * 部门
     */
    private String dept;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCouncilId() {
        return councilId;
    }

    public void setCouncilId(Integer councilId) {
        this.councilId = councilId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
