package com.bsoft.cost.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/9/28 14:01
 * @Description: 部门时间控制DO
 */
@Entity
@Table(name = "bsoftmis.BX_BMSJKZ")
public class DeptReimbDateControlDO {
    private Integer id;
    private Integer controlYear;
    private String deptId;
    private Date registDate;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "kznf")
    public Integer getControlYear() {
        return controlYear;
    }

    public void setControlYear(Integer controlYear) {
        this.controlYear = controlYear;
    }

    @Column(name = "bmdm")
    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    @Column(name = "djrq")
    public Date getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }
}
