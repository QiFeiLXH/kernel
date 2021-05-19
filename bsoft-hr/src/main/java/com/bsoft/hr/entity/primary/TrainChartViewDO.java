package com.bsoft.hr.entity.primary;

import com.bsoft.hr.key.TrainChartViewKey;

import javax.persistence.*;

/**
 * @author: zy
 * @date: 2020/8/5 13:32
 */

@Entity
@Table(name = "hr_trainreport_view")
@IdClass(TrainChartViewKey.class)
public class TrainChartViewDO {

    // 培训年份
    @Id
    @Column(name = "tyear")
    private Integer trainYear;

    // 一级部门名称
    @Id
    @Column(name = "depname")
    private String department;

    // 一级部门类别
    @Column(name = "deptype")
    private Integer departmentType;

    // 培训类型
    @Id
    @Column(name = "tType")
    private Integer trainType;

    // 培训数量
    @Column(name = "tcount")
    private Integer attendCount;

    public Integer getAttendCount() {
        return attendCount;
    }

    public void setAttendCount(Integer attendCount) {
        this.attendCount = attendCount;
    }

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