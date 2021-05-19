package com.bsoft.clue.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 销售线索立项专用
 */
@Entity
@Table(name = "bsoftmis.xs_xmxs")
public class SalesCluesApprovalDO {
    @Id
    @Column(name="xsbh")
    private Integer id;

    @Column(name="lxbz")
    private Integer approvalFlag;

    private String processInstanceId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApprovalFlag() {
        return approvalFlag;
    }

    public void setApprovalFlag(Integer approvalFlag) {
        this.approvalFlag = approvalFlag;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }
}
