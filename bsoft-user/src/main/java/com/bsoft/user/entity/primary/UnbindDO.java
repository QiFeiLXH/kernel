package com.bsoft.user.entity.primary;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ker_user_unbind")
public class UnbindDO {
    private Integer id;
    private String personId;
    private String reason;
    private Integer auditflag;
    private String auditter;
    private Date auditDate;
    private Date applyDate;
    private String appDevice;
    private String phoneModel;
    private Date appbindDate;
    @Id
    @SequenceGenerator(name="seq_ker_user_unbind",allocationSize=1,sequenceName="seq_ker_user_unbind")
    @GeneratedValue(generator="seq_ker_user_unbind",strategy=GenerationType.SEQUENCE)
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
