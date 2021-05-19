package com.bsoft.person.dto;

import java.io.Serializable;

public class WorkCertificateNumDTO implements Serializable {
    private String personId;
    /** 员工姓名 */
    private String personName;
    /** 拼音码 */
    private String simpleCode;
    /** 部门id */
    private String deptId;
    /** 部门名称 */
    private String deptName;
    /** 证书数量 */
    private Integer certificatesNum;

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

    public Integer getCertificatesNum() {
        return certificatesNum;
    }

    public void setCertificatesNum(Integer certificatesNum) {
        this.certificatesNum = certificatesNum;
    }

    public String getSimpleCode() {
        return simpleCode;
    }

    public void setSimpleCode(String simpleCode) {
        this.simpleCode = simpleCode;
    }
}
