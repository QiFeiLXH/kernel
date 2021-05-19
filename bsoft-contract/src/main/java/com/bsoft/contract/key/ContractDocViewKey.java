package com.bsoft.contract.key;

import java.io.Serializable;

/**
 * @Author: xucl
 * @DateTime: 2020/12/24 11:27
 * @Description:
 */
public class ContractDocViewKey implements Serializable {
    private String htbh;
    private Integer wdid;

    public String getHtbh() {
        return htbh;
    }

    public void setHtbh(String htbh) {
        this.htbh = htbh;
    }

    public Integer getWdid() {
        return wdid;
    }

    public void setWdid(Integer wdid) {
        this.wdid = wdid;
    }
}
