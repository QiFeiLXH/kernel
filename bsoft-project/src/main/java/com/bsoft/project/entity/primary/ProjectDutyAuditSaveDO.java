package com.bsoft.project.entity.primary;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author zhanglf
 * @Date 2020/5/21 9:17
 * @Description 项目责任书审核用do
 */
@Table(name="BSOFT_PORTAL.PRO_DUTY")
@Entity
public class ProjectDutyAuditSaveDO {
    /** 主键 */
    private Integer id;
    /** 审核人 */
    private String auditter;
    /** 审核日期 */
    private Date auditDate;
    /** 审核标志 */
    private Integer auditFlag;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
