package com.bsoft.work.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/27 14:07
 * @Description
 */
@Entity
@Table(name="BSOFT_PORTAL.WORK_PRINTING_DETAIL")
public class PrintingDetailDO {
    @Id
    private Integer id;
    /** 文印主表id */
    private Integer printingId;
    /** 文印类别 */
    private Integer printType;
    /** 文印内容 */
    private String context;
    /** 数量 */
    private Integer printNum;
    /** 单价 */
    private Double unitPrice;
    /** 金额 */
    private Double amount;
    /** 备注 */
    private String remark;
    /** 流水号id */
    private String lshid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrintingId() {
        return printingId;
    }

    public void setPrintingId(Integer printingId) {
        this.printingId = printingId;
    }

    public Integer getPrintType() {
        return printType;
    }

    public void setPrintType(Integer printType) {
        this.printType = printType;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Integer getPrintNum() {
        return printNum;
    }

    public void setPrintNum(Integer printNum) {
        this.printNum = printNum;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLshid() {
        return lshid;
    }

    public void setLshid(String lshid) {
        this.lshid = lshid;
    }
}
