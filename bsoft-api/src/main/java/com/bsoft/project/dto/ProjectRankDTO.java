package com.bsoft.project.dto;

import java.io.Serializable;
import java.util.Date;

public class ProjectRankDTO implements Serializable {
    private String personId;
    private String projectName;
    private String area;
    private String projectManager;
    private String contractNo;
    private Date startDate;
    private Date actto;
    private Integer flag;
    private Double workLoad;
    private String projectId;
    private Integer status;


    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getActto() {
        return actto;
    }

    public void setActto(Date actto) {
        this.actto = actto;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Double getWorkLoad() {
        return workLoad;
    }

    public void setWorkLoad(Double workLoad) {
        this.workLoad = workLoad;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
