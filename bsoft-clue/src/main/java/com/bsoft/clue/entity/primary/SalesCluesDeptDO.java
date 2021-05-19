package com.bsoft.clue.entity.primary;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bsoftmis.xs_xsbm")
public class SalesCluesDeptDO {
    private Integer id;
    /**
     * 线索编号
     */
    private Integer clueId;
    /**
     * 归属部门
     */
    private String dept;
    /**
     * 立项标志
     */
    private Integer approvalFlag;
    /**
     * 备注
     */
    private String remark;
    /**
     * 项目ID
     */
    private String projectId;
    /**
     * 跟踪人员工号
     */
    private String trackPersonId;
    /**
     * 关闭标志
     */
    private Integer closeFlag;
    /**
     * 产品条线
     */
    private Integer productLine;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "xsbh")
    public Integer getClueId() {
        return clueId;
    }

    public void setClueId(Integer clueId) {
        this.clueId = clueId;
    }

    @Column(name = "sybdm")
    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Column(name = "lxbz")
    public Integer getApprovalFlag() {
        return approvalFlag;
    }

    public void setApprovalFlag(Integer approvalFlag) {
        this.approvalFlag = approvalFlag;
    }

    @Column(name = "bz")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Column(name = "gdry")
    public String getTrackPersonId() {
        return trackPersonId;
    }

    public void setTrackPersonId(String trackPersonId) {
        this.trackPersonId = trackPersonId;
    }

    @Column(name = "gbbz")
    public Integer getCloseFlag() {
        return closeFlag;
    }

    public void setCloseFlag(Integer closeFlag) {
        this.closeFlag = closeFlag;
    }

    @Column(name = "cptx")
    public Integer getProductLine() {
        return productLine;
    }

    public void setProductLine(Integer productLine) {
        this.productLine = productLine;
    }
}
