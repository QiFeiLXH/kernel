package com.bsoft.user.dto;

import java.io.Serializable;
import java.util.Date;

public class UnbindDTO implements Serializable {
    private Integer id;
    private String personId;
    private String personName;
    private String reason;
    private Integer auditflag; //0未审核，1同意，2不同意
    private String auditflagText;
    private String auditter;
    private String auditterText;
    private Date auditDate;
    private Date applyDate;
    private String appDevice; //设备号
    private String phoneModel;
    private Date appbindDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getAuditflag() {
        return auditflag;
    }

    public void setAuditflag(Integer auditflag) {
        this.auditflag = auditflag;
    }

    public String getAuditter() {
        return auditter;
    }

    public void setAuditter(String auditter) {
        this.auditter = auditter;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getAuditflagText() {
        return auditflagText;
    }

    public void setAuditflagText(String auditflagText) {
        this.auditflagText = auditflagText;
    }

    public String getAuditterText() {
        return auditterText;
    }

    public void setAuditterText(String auditterText) {
        this.auditterText = auditterText;
    }

    public String getAppDevice() {
        return appDevice;
    }

    public void setAppDevice(String appDevice) {
        this.appDevice = appDevice;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public Date getAppbindDate() {
        return appbindDate;
    }

    public void setAppbindDate(Date appbindDate) {
        this.appbindDate = appbindDate;
    }
}
