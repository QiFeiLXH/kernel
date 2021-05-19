package com.bsoft.sales.report.entity.primary;

import com.bsoft.dictionary.annotation.contract.ContractSubjectDic;
import com.bsoft.dictionary.annotation.contract.ContractTypeDic;
import com.bsoft.dictionary.annotation.contract.OriginalStatusDic;
import com.bsoft.dictionary.annotation.customer.CustomerDic;
import com.bsoft.dictionary.annotation.dept.DeptAllDic;

import javax.persistence.*;

@Entity
@Table(name = "ker_sales_report_review_view")
public class DynamicReviewViewDO {
    private Integer id; //主键
    private Integer dynamicId; //销售动态ID
    private Integer reviewId; //合同评审ID
    private Integer subject; //合同标的
    private String subjectText; //合同标的名称
    private String customerId; //客户编码
    private String customerIdText; //客户名称
    private Integer contractType; //合同分类
    private String contractTypeText; //合同分类名称
    private Integer originalStatus; //原件状态
    private String originalStatusText; //原件状态名称
    private String area; //所属区域
    private String areaText; //所属区域名称
    private Double amount; //合同额

    @Id
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

    public String getSubjectText() {
        return subjectText;
    }

    public void setSubjectText(String subjectText) {
        this.subjectText = subjectText;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerIdText() {
        return customerIdText;
    }

    public void setCustomerIdText(String customerIdText) {
        this.customerIdText = customerIdText;
    }

    public Integer getContractType() {
        return contractType;
    }

    public void setContractType(Integer contractType) {
        this.contractType = contractType;
    }

    public String getContractTypeText() {
        return contractTypeText;
    }

    public void setContractTypeText(String contractTypeText) {
        this.contractTypeText = contractTypeText;
    }

    public Integer getOriginalStatus() {
        return originalStatus;
    }

    public void setOriginalStatus(Integer originalStatus) {
        this.originalStatus = originalStatus;
    }

    public String getOriginalStatusText() {
        return originalStatusText;
    }

    public void setOriginalStatusText(String originalStatusText) {
        this.originalStatusText = originalStatusText;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAreaText() {
        return areaText;
    }

    public void setAreaText(String areaText) {
        this.areaText = areaText;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
