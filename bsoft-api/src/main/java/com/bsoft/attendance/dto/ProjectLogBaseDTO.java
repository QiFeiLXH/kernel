package com.bsoft.attendance.dto;

import java.io.Serializable;
import java.sql.Date;

/*
 * @author  hy
 * @date  2020/4/10 9:58
 * @description
 */
public class ProjectLogBaseDTO implements Serializable {
    private String contractNo;
    private Date attendanceDate;
    private String projectName;
    private Integer houseId;
    private Integer houseType;
    private Integer evection;

    public ProjectLogBaseDTO() {
    }

    public ProjectLogBaseDTO(String contractNo, Date attendanceDate, String projectName, Integer houseId, Integer houseType,Integer evection) {
        this.contractNo = contractNo;
        this.attendanceDate = attendanceDate;
        this.projectName = projectName;
        this.houseId = houseId;
        this.houseType = houseType;
        this.evection = evection;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getHouseType() {
        return houseType;
    }

    public void setHouseType(Integer houseType) {
        this.houseType = houseType;
    }

    public Integer getEvection() {
        return evection;
    }

    public void setEvection(Integer evection) {
        this.evection = evection;
    }
}
