package com.bsoft.sales.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: xucl
 * @DateTime: 2020/9/29 14:23
 * @Description:
 */
@Entity
@Table(name = "ker_CustomerContacts_view")
public class CustomerContactViewDO {
    private Integer id;
    private String customerName;
    private String simpleCode;
    private Integer flag;
    private Integer payeeId;
    private String unitName;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name="khmc")
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    @Column(name="pydm")
    public String getSimpleCode() {
        return simpleCode;
    }

    public void setSimpleCode(String simpleCode) {
        this.simpleCode = simpleCode;
    }
    @Column(name="hdbz")
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
    @Id
    public Integer getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(Integer payeeId) {
        this.payeeId = payeeId;
    }
    @Column(name = "dwmc")
    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
