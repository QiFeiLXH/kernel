package com.bsoft.sales.dto;

import java.io.Serializable;

/**
 * @Author: xucl
 * @DateTime: 2020/9/29 14:26
 * @Description:
 */
public class CustomerContactViewDTO implements Serializable {
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

    public Integer getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(Integer payeeId) {
        this.payeeId = payeeId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
