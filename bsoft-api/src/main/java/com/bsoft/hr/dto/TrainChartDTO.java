package com.bsoft.hr.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: zy
 * @date: 2020/8/5 13:28
 */
public class TrainChartDTO implements Serializable {

    // 培训年份
    private Integer trainYear;
    // 一级部门名称
    private String department;
    // 一级部门类别
    private Integer departmentType;
    //  培训类型
    private Integer trainType;
    // 培训数量
    private Integer attendCount;

    public Integer getTrainYear() {
        return trainYear;
    }

    public void setTrainYear(Integer trainYear) {
        this.trainYear = trainYear;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(Integer departmentType) {
        this.departmentType = departmentType;
    }

    public Integer getTrainType() {
        return trainType;
    }

    public void setTrainType(Integer trainType) {
        this.trainType = trainType;
    }

    public Integer getAttendCount() {
        return attendCount;
    }

    public void setAttendCount(Integer attendCount) {
        this.attendCount = attendCount;
    }
}