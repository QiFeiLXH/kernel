package com.bsoft.person.dto;

import java.io.Serializable;

public class KnowledgeNumDTO implements Serializable {
    private String personId;
    /** 员工姓名 */
    private String personName;
    /** 拼音码 */
    private String simpleCode;
    /** 部门id */
    private String deptId;
    /** 部门名称 */
    private String deptName;
    /** 知识数量 */
    private Integer knowledgeNumber;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getSimpleCode() {
        return simpleCode;
    }

    public void setSimpleCode(String simpleCode) {
        this.simpleCode = simpleCode;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getKnowledgeNumber() {
        return knowledgeNumber;
    }

    public void setKnowledgeNumber(Integer knowledgeNumber) {
        this.knowledgeNumber = knowledgeNumber;
    }
}
