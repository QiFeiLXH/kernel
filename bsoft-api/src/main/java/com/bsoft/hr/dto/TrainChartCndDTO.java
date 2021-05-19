package com.bsoft.hr.dto;

import java.io.Serializable;

/**
 * @author: zy
 * @date: 2020/8/14 15:28
 */
public class TrainChartCndDTO implements Serializable {

    private Integer trainYear;
    private Integer departmentType;
    private Integer trainType;
    private Integer pageNo;
    private Integer pageSize;

    public Integer getTrainYear() {
        return trainYear;
    }

    public void setTrainYear(Integer trainYear) {
        this.trainYear = trainYear;
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

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
