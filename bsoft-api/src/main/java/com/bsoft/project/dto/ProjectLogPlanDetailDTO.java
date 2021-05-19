package com.bsoft.project.dto;

import java.io.Serializable;
import java.util.List;

public class ProjectLogPlanDetailDTO implements Serializable {
    private Integer id;
    private Integer parentId;
    private String milepostName;
    private Integer logoff;
    private Integer logNum;
    private Double workloadSum;
    private String contractNo;
    private String icon;
    private Integer range;
    private Integer milepostId;
    private Integer finishFlag;
    private List<ProjectLogPlanDetailDTO> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getMilepostName() {
        return milepostName;
    }

    public void setMilepostName(String milepostName) {
        this.milepostName = milepostName;
    }

    public Integer getLogoff() {
        return logoff;
    }

    public void setLogoff(Integer logoff) {
        this.logoff = logoff;
    }

    public Integer getLogNum() {
        return logNum;
    }

    public void setLogNum(Integer logNum) {
        this.logNum = logNum;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public List<ProjectLogPlanDetailDTO> getChildren() {
        return children;
    }

    public void setChildren(List<ProjectLogPlanDetailDTO> children) {
        this.children = children;
    }

    public Double getWorkloadSum() {
        return workloadSum;
    }

    public void setWorkloadSum(Double workloadSum) {
        this.workloadSum = workloadSum;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }


    public Integer getMilepostId() {
        return milepostId;
    }

    public void setMilepostId(Integer milepostId) {
        this.milepostId = milepostId;
    }

    public Integer getFinishFlag() {
        return finishFlag;
    }

    public void setFinishFlag(Integer finishFlag) {
        this.finishFlag = finishFlag;
    }
}
