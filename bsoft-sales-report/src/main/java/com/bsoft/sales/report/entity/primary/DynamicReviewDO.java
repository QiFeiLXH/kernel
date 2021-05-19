package com.bsoft.sales.report.entity.primary;

import com.bsoft.dictionary.annotation.contract.ContractSubjectDic;
import com.bsoft.dictionary.annotation.contract.ContractTypeDic;
import com.bsoft.dictionary.annotation.contract.OriginalStatusDic;
import com.bsoft.dictionary.annotation.customer.CustomerDic;
import com.bsoft.dictionary.annotation.dept.DeptAllDic;

import javax.persistence.*;

@Entity
@Table(name = "ker_sales_report_review")
public class DynamicReviewDO {
    private Integer id; //主键
    private Integer dynamicId; //销售动态ID
    private Integer reviewId; //合同评审ID
    @ContractSubjectDic
    private Integer subject; //合同标的
    @CustomerDic
    private String customerId; //客户编码
    @ContractTypeDic
    private Integer contractType; //合同分类
    @OriginalStatusDic
    private Integer originalStatus; //原件状态
    @DeptAllDic
    private String area; //所属区域
    private Double amount; //合同额

    @Id
    @SequenceGenerator(name="seq_ker_sales_report_review",allocationSize=1,sequenceName="seq_ker_sales_report_review")
    @GeneratedValue(generator="seq_ker_sales_report_review",strategy=GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(Integer dynamicId) {
        this.dynamicId = dynamicId;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getSubject() {
        return subject;
    }

    public void setSubject(Integer subject) {
        this.subject = subject;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Integer getContractType() {
        return contractType;
    }

    public void setContractType(Integer contractType) {
        this.contractType = contractType;
    }

    public Integer getOriginalStatus() {
        return originalStatus;
    }

    public void setOriginalStatus(Integer originalStatus) {
        this.originalStatus = originalStatus;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
