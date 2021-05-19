package com.bsoft.project.entity.primary;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/13 9:44
 * @Description 项目责任书-项目范围视图
 */
@Entity
@Table(name="BSOFT_PORTAL.PRO_DUTY_REGION_VIEW")
public class ProjectDutyRegionViewDO {
    @Id
    private Integer id;
    /** 责任书id */
    private Integer dutyId;
    /** 合同编号 */
    private String contractNo;
    /** 合同号 */
    private String contractCode;
    /** 合同名称 */
    private String contractName;
    /** 权重 */
    private Double weight;
    /* 里程碑 */
    @Transient
    private List<ProjectDutyMilepostViewDO> mileposts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDutyId() {
        return dutyId;
    }

    public void setDutyId(Integer dutyId) {
        this.dutyId = dutyId;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public List<ProjectDutyMilepostViewDO> getMileposts() {
        return mileposts;
    }

    public void setMileposts(List<ProjectDutyMilepostViewDO> mileposts) {
        this.mileposts = mileposts;
    }
}
