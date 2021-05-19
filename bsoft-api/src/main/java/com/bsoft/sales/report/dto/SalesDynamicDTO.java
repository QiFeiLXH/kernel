package com.bsoft.sales.report.dto;

import java.io.Serializable;
import java.util.Date;

public class SalesDynamicDTO implements Serializable {
    private Integer id; //主键
    private String personId; //工号
    private Integer salesClue; //销售线索
    private Integer tender; //投标
    private Integer contractReview; //合同评审
    private Integer contract; //合同
    private Double contractAmount; //合同金额
    private Date sendDate; //发送日期

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Integer getSalesClue() {
        return salesClue;
    }

    public void setSalesClue(Integer salesClue) {
        this.salesClue = salesClue;
    }

    public Integer getTender() {
        return tender;
    }

    public void setTender(Integer tender) {
        this.tender = tender;
    }

    public Integer getContractReview() {
        return contractReview;
    }

    public void setContractReview(Integer contractReview) {
        this.contractReview = contractReview;
    }

    public Integer getContract() {
        return contract;
    }

    public void setContract(Integer contract) {
        this.contract = contract;
    }

    public Double getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(Double contractAmount) {
        this.contractAmount = contractAmount;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }
}
