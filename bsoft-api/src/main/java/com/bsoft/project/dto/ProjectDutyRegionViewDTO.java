package com.bsoft.project.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/13 9:44
 * @Description
 */
public class ProjectDutyRegionViewDTO implements Serializable {
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
    private List<ProjectDutyMilepostViewDTO> mileposts;

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

    public List<ProjectDutyMilepostViewDTO> getMileposts() {
        return mileposts;
    }

    public void setMileposts(List<ProjectDutyMilepostViewDTO> mileposts) {
        this.mileposts = mileposts;
    }
}
