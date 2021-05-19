package com.bsoft.sales.dto;

import java.io.Serializable;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/24 15:27
 * @Description
 */
public class CustomerContactsDTO implements Serializable {
    private Integer id;
    private String customerName;
    private String simpleCode;
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
