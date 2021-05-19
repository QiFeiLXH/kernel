package com.bsoft.hr.key;

import java.io.Serializable;

/**
 * @author: zy
 * @date: 2020/8/7 21:35
 */
public class TrainChartViewKey implements Serializable {

    private Integer trainYear;
    private String department;
    private Integer trainType;

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

    public Integer getTrainType() {
        return trainType;
    }

    public void setTrainType(Integer trainType) {
        this.trainType = trainType;
    }
}
