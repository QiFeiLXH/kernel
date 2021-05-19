package com.bsoft.attendance.entity.primary;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PRO_WORKLOG_AUDIT")
public class ProjectLogAuditDetailDO {
    private Integer id;
    private Integer proWorkLogId;
    private String auditter;
    private Date auditDate;
    private Integer auditFlag;
    private String remark;
    private Integer flag; //操作来源 5.门户   12.app

    @Id
    @SequenceGenerator(name="seq_pro_worklog_audit",allocationSize=1,sequenceName="seq_pro_worklog_audit")
    @GeneratedValue(generator="seq_pro_worklog_audit",strategy=GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProWorkLogId() {
        return proWorkLogId;
    }

    public void setProWorkLogId(Integer proWorkLogId) {
        this.proWorkLogId = proWorkLogId;
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

    public Integer getAuditFlag() {
        return auditFlag;
    }

    public void setAuditFlag(Integer auditFlag) {
        this.auditFlag = auditFlag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
