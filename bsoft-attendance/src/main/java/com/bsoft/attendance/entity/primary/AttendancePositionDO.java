package com.bsoft.attendance.entity.primary;

import javax.persistence.Id;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2021/1/19 15:26
 * @Description: 考勤统计使用的调动情况
 */
public class AttendancePositionDO {
    private Integer id;
    /** 员工工号*/
    private String personId;
    /** 调动日期*/
    private Date TransferDate;
    //调后部门
    private String departmentAfter;
    private String departmentNameAfter;
    //调前部门
    private String departmentDefore;
    private String departmentNameDefore;

    public String getDepartmentNameAfter() {
        return departmentNameAfter;
    }

    public void setDepartmentNameAfter(String departmentNameAfter) {
        this.departmentNameAfter = departmentNameAfter;
    }

    public String getDepartmentNameDefore() {
        return departmentNameDefore;
    }

    public void setDepartmentNameDefore(String departmentNameDefore) {
        this.departmentNameDefore = departmentNameDefore;
    }

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Date getTransferDate() {
        return TransferDate;
    }

    public void setTransferDate(Date transferDate) {
        TransferDate = transferDate;
    }

    public String getDepartmentAfter() {
        return departmentAfter;
    }

    public void setDepartmentAfter(String departmentAfter) {
        this.departmentAfter = departmentAfter;
    }

    public String getDepartmentDefore() {
        return departmentDefore;
    }

    public void setDepartmentDefore(String departmentDefore) {
        this.departmentDefore = departmentDefore;
    }
}
