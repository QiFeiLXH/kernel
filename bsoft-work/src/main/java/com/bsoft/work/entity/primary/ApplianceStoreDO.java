package com.bsoft.work.entity.primary;

import javax.persistence.*;
import java.util.Date;

/**
 * @version 1.0
 * @author: zy
 * @date: 2020/12/17
 * @description 物品库存
 */
@Entity
@Table(name = "adm_appliance_store")
public class ApplianceStoreDO {
    @Id
    @SequenceGenerator(name="seq_adm_appliance_store",allocationSize=1,sequenceName="seq_adm_appliance_store")
    @GeneratedValue(generator="seq_adm_appliance_store",strategy= GenerationType.SEQUENCE)
    private Integer id;
    /**物品类别*/
    private Integer type;
    /**物品名称*/
    private Integer name;
    /**规格*/
    private String standards;
    /**单价*/
    private Double unitPrice;
    /**剩余数量*/
    private Integer surplusQuantity;

    /**类型名称*/
    @Transient
    private String typeName;
    /**物品名称*/
    @Transient
    private String nameName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public String getStandards() {
        return standards;
    }

    public void setStandards(String standards) {
        this.standards = standards;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getSurplusQuantity() {
        return surplusQuantity;
    }

    public void setSurplusQuantity(Integer surplusQuantity) {
        this.surplusQuantity = surplusQuantity;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getNameName() {
        return nameName;
    }

    public void setNameName(String nameName) {
        this.nameName = nameName;
    }
}
