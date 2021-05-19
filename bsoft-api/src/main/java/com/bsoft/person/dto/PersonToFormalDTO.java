package com.bsoft.person.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2021/2/1 8:30
 * @Description:
 */
public class PersonToFormalDTO implements Serializable {

    private String personId;
    private String personName;
    private String dept;
    private String deptName;
    private Integer probation;
    private Date probationEndDate;
    private Date toFormalDate;
    private Integer status;
    private String pym;
    private Integer turId;
    private String testMode;
    private Integer toformalType;
    private String toformalTypeText;

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

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getProbation() {
        return probation;
    }

    public void setProbation(Integer probation) {
        this.probation = probation;
    }

    public Date getProbationEndDate() {
        return probationEndDate;
    }

    public void setProbationEndDate(Date probationEndDate) {
        this.probationEndDate = probationEndDate;
    }

    public Date getToFormalDate() {
        return toFormalDate;
    }

    public void setToFormalDate(Date toFormalDate) {
        this.toFormalDate = toFormalDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPym() {
        return pym;
    }

    public void setPym(String pym) {
        this.pym = pym;
    }

    public Integer getTurId() {
        return turId;
    }

    public void setTurId(Integer turId) {
        this.turId = turId;
    }

    public String getTestMode() {
        return testMode;
    }

    public void setTestMode(String testMode) {
        this.testMode = testMode;
    }

    public Integer getToformalType() {
        return toformalType;
    }

    public void setToformalType(Integer toformalType) {
        this.toformalType = toformalType;
    }

    public String getToformalTypeText() {
        return toformalTypeText;
    }

    public void setToformalTypeText(String toformalTypeText) {
        this.toformalTypeText = toformalTypeText;
    }
}
