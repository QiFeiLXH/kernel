package com.bsoft.sales.report.entity.primary;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ker_sales_report_salesdynamic")
public class SalesDynamicDO {
    private Integer id; //主键
    private String personId; //工号
    private Integer salesClue; //销售线索
    private Integer tender; //投标
    private Integer contractReview; //合同评审
    private Integer contract; //合同
    private Double contractAmount; //合同金额
    private Date sendDate; //发送日期

    @Id
    @SequenceGenerator(name="seq_ker_sales_report_dynamic",allocationSize=1,sequenceName="seq_ker_sales_report_dynamic")
    @GeneratedValue(generator="seq_ker_sales_report_dynamic",strategy=GenerationType.SEQUENCE)
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
