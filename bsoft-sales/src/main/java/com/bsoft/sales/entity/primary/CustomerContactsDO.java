package com.bsoft.sales.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/24 15:27
 * @Description
 */
@Entity
@Table(name="BSOFTMIS.WH_KHWL")
public class CustomerContactsDO {
    @Id
    private Integer id;
    @Column(name="khmc")
    private String customerName;
    @Column(name="pydm")
    private String simpleCode;
    @Column(name="hdbz")
    private Integer flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSimpleCode() {
        return simpleCode;
    }

    public void setSimpleCode(String simpleCode) {
        this.simpleCode = simpleCode;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
