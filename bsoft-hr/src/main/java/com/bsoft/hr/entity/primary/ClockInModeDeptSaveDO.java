package com.bsoft.hr.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: zy
 * @date: 2020/8/30
 * @description 部门打卡方式
 */
@Entity
@Table(name = "bsoftmis.t_dep")
public class ClockInModeDeptSaveDO {
    // 部门
    @Id
    @Column(name = "bmdm")
    private String dept;

    // 考勤方式
    @Column(name = "attendflag")
    private Integer attendFlagDept;

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getAttendFlagDept() {
        return attendFlagDept;
    }

    public void setAttendFlagDept(Integer attendFlagDept) {
        this.attendFlagDept = attendFlagDept;
    }
}
