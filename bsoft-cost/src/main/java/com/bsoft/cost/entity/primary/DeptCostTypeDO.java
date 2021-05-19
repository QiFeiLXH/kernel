package com.bsoft.cost.entity.primary;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2021/3/4 16:25
 * @Description:
 */
@Entity
@Table(name = "FIN_DEPT_COSTTYPE")
public class DeptCostTypeDO {
    private Integer id;
    private Integer year;
    private String dept;
    private Integer costType;
    private Integer flag;
    private String registrant;
    private Date registrantDate;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getCostType() {
        return costType;
    }

    public void setCostType(Integer costType) {
        this.costType = costType;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public Date getRegistrantDate() {
        return registrantDate;
    }

    public void setRegistrantDate(Date registrantDate) {
        this.registrantDate = registrantDate;
    }
}
