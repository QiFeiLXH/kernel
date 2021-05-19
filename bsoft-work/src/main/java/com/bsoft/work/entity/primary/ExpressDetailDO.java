package com.bsoft.work.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/20 14:12
 * @Description
 */
@Entity
@Table(name="WORK_EXPRESS_DETAIL")
public class ExpressDetailDO {
    private Integer id;
    /** 快递主表id */
    private Integer expressId;
    /** 快递内容 */
    private String context;
    /** 收件人 */
    private String recipient;
    /** 收件地区 */
    private String area;
    /** 收件地址 */
    private String address;
    /** 重量 */
    private String weight;
    /** 金额 */
    private Double amount;
    /** 核准金额 */
    private Double approval;
    /** 快递单号 */
    private String expressNo;
    /** 流水号id */
    private String lshid;
    /** 状态 */
    private Integer status;
    /** 寄件日期 */
    private Date shipmentDate;
    /** 申请支付日期 */
    private Date applyPayDate;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExpressId() {
        return expressId;
    }

    public void setExpressId(Integer expressId) {
        this.expressId = expressId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getApproval() {
        return approval;
    }

    public void setApproval(Double approval) {
        this.approval = approval;
    }

    public String getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo;
    }

    public String getLshid() {
        return lshid;
    }

    public void setLshid(String lshid) {
        this.lshid = lshid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(Date shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public Date getApplyPayDate() {
        return applyPayDate;
    }

    public void setApplyPayDate(Date applyPayDate) {
        this.applyPayDate = applyPayDate;
    }
}
