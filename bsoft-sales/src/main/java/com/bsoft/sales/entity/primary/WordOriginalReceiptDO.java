package com.bsoft.sales.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/7/30 10:07
 * @Description: 合同原件接收信息
 */
@Entity
@Table(name = "bsoftmis.wd_wdxx_yjjs")
public class WordOriginalReceiptDO {
    private Integer id;
    private Integer recoreId;
    private Integer receivingFlag;
    private String receiver;
    private Date receivingDate;
    private String remarks;
    private Integer count;
    private Integer status;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "JLID")
    public Integer getRecoreId() {
        return recoreId;
    }

    public void setRecoreId(Integer recoreId) {
        this.recoreId = recoreId;
    }

    @Column(name = "YJJS")
    public Integer getReceivingFlag() {
        return receivingFlag;
    }

    public void setReceivingFlag(Integer receivingFlag) {
        this.receivingFlag = receivingFlag;
    }

    @Column(name = "YJJSRY")
    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @Column(name = "YJJSSJ")
    public Date getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(Date receivingDate) {
        this.receivingDate = receivingDate;
    }

    @Column(name = "BZ")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Column(name = "SL")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Column(name = "STATUS")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
