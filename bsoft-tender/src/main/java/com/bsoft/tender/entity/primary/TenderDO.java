package com.bsoft.tender.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "bsoftmis.t_tbjl")
public class TenderDO {
    private Integer id; //主键
    private String customerId; //客户编码
    private String area; //所属区域
    private String projectName; //项目名称
    private Date startDate;//开标时间
    private Integer tenderFlag;//应标标志
    private Date submitDate; //登记时间
    private String submitter; //登记人员
    private String tenderAgency;//招标机构
    private String tenderNumber;//招标编号
    private Double tenderAmount;//中标金额

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "khbm")
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Column(name = "ssqy")
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Column(name = "projectname")
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Column(name = "kbsj")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name = "ybbz")
    public Integer getTenderFlag() {
        return tenderFlag;
    }

    public void setTenderFlag(Integer tenderFlag) {
        this.tenderFlag = tenderFlag;
    }

    @Column(name = "djrq")
    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    @Column(name = "djry")
    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    @Column(name = "zbjg")
    public String getTenderAgency() {
        return tenderAgency;
    }

    public void setTenderAgency(String tenderAgency) {
        this.tenderAgency = tenderAgency;
    }

    @Column(name = "zbbh")
    public String getTenderNumber() {
        return tenderNumber;
    }

    public void setTenderNumber(String tenderNumber) {
        this.tenderNumber = tenderNumber;
    }

    @Column(name = "zbje")
    public Double getTenderAmount() {
        return tenderAmount;
    }

    public void setTenderAmount(Double tenderAmount) {
        this.tenderAmount = tenderAmount;
    }
}
