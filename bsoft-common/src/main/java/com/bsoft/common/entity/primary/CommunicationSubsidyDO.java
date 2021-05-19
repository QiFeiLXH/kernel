package com.bsoft.common.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: xucl
 * @DateTime: 2020/12/30 15:18
 * @Description:
 */
@Entity
@Table(name = "bsoftmis.financial_phonesubsidy")
public class CommunicationSubsidyDO {

    @Id
    @Column(name="levelid")
    private Integer id;
    @Column(name="levelname")
    private String name;
    private Double amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
