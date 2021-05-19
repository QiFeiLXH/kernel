package com.bsoft.project.report.entity.primary;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

/**
 * @Auther: hy
 * @Date: 2019/12/10
 * @Description: 人力成本P等级
 */
@Entity
@Table(name = "ker_project_report_plaborcost")
public class ManpowerCostPDO {
    private Integer id;
    private String contractNo;
    private String projectId;
    private LocalDate month;
    private Integer depType;
    private Integer pGrade;
    private Double workload;
    private Double amount;

    @Id
    @SequenceGenerator(name="seq_ker_report_plaborcost",allocationSize=1,sequenceName="seq_ker_report_plaborcost")
    @GeneratedValue(generator="seq_ker_report_plaborcost",strategy=GenerationType.SEQUENCE)
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

    public Integer getpGrade() {
        return pGrade;
    }

    public void setpGrade(Integer pGrade) {
        this.pGrade = pGrade;
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
