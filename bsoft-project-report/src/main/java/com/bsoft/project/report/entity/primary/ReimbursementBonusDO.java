package com.bsoft.project.report.entity.primary;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

/**
 * @Auther: hy
 * @Date: 2019/12/10
 * @Description: 报销费用和项目奖金
 */
@Entity
@Table(name = "ker_project_report_cost")
public class ReimbursementBonusDO {

    private Integer id;
    private String contractNo;
    private String projectId;
    private LocalDate month;
    private Integer depType;
    private Integer costSubject;
    private Double amount;

    @Id
    @SequenceGenerator(name="seq_ker_project_report_cost",allocationSize=1,sequenceName="seq_ker_project_report_cost")
    @GeneratedValue(generator="seq_ker_project_report_cost",strategy=GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDate getMonth() {
        return month;
    }

    public void setMonth(LocalDate month) {
        this.month = month;
    }

    public Integer getDepType() {
        return depType;
    }

    public void setDepType(Integer depType) {
        this.depType = depType;
    }

    public Integer getCostSubject() {
        return costSubject;
    }

    public void setCostSubject(Integer costSubject) {
        this.costSubject = costSubject;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
