package com.bsoft.sales.report.entity.primary;

import com.bsoft.dictionary.annotation.customer.CustomerDic;
import com.bsoft.dictionary.annotation.dept.DeptAllDic;

import javax.persistence.*;

@Entity
@Table(name = "ker_sales_report_tender_view")
public class DynamicTenderViewDO {
    private Integer id; //主键
    private Integer dynamicId; //销售动态ID
    private Integer tenderId; //投标ID
    private String customerId; //客户编码
    private String customerIdText; //客户编码
    private String area; //所属区域
    private String areaText; //所属区域
    private String projectName; //项目名称
    private String tenderAgency; //招标机构
    private String tenderNumber; //招标编号
    private Double tenderAmount; //中标金额

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

    public Integer getTenderId() {
        return tenderId;
    }

    public void setTenderId(Integer tenderId) {
        this.tenderId = tenderId;
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTenderAgency() {
        return tenderAgency;
    }

    public void setTenderAgency(String tenderAgency) {
        this.tenderAgency = tenderAgency;
    }

    public String getTenderNumber() {
        return tenderNumber;
    }

    public void setTenderNumber(String tenderNumber) {
        this.tenderNumber = tenderNumber;
    }

    public Double getTenderAmount() {
        return tenderAmount;
    }

    public void setTenderAmount(Double tenderAmount) {
        this.tenderAmount = tenderAmount;
    }
}
