package com.bsoft.project.report.entity.primary;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Auther: hy
 * @Date: 2019/12/10
 * @Description:
 */
@Entity
@Table(name = "ker_project_report_t_view")
public class ManpowerCostTViewDO {

    @Id
    private String vid;

    private String contractNo;

    private String projectId;

    private Date month;

    private Integer depType;

    private String tGrade;
    private Double workload;
    private Double amount;

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public Integer getDepType() {
        return depType;
    }

    public void setDepType(Integer depType) {
        this.depType = depType;
    }

    public String gettGrade() {
        return tGrade;
    }

    public void settGrade(String tGrade) {
        this.tGrade = tGrade;
    }

    public Double getWorkload() {
        return workload;
    }

    public void setWorkload(Double workload) {
        this.workload = workload;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
