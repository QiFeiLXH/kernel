package com.bsoft.person.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Auther: hy
 * @Date: 2020/6/3
 * @Description:
 */
@Entity
@Table(name="bsoftmis.T_CLASS")
public class PersonTClassDO {

    @Id
    private String classNo;

    private Double cost;

    private Integer zxbz;

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getZxbz() {
        return zxbz;
    }

    public void setZxbz(Integer zxbz) {
        this.zxbz = zxbz;
    }
}
