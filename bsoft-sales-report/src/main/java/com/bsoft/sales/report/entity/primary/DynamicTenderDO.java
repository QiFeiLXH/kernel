package com.bsoft.sales.report.entity.primary;

import com.bsoft.dictionary.annotation.customer.CustomerDic;
import com.bsoft.dictionary.annotation.dept.DeptAllDic;

import javax.persistence.*;

@Entity
@Table(name = "ker_sales_report_tender")
public class DynamicTenderDO {
    private Integer id; //主键
    private Integer dynamicId; //销售动态ID
    private Integer tenderId; //投标ID
    @CustomerDic
    private String customerId; //客户编码
    @DeptAllDic
    private String area; //所属区域
    private String projectName; //项目名称
    private String tenderAgency; //招标机构
    private String tenderNumber; //招标编号
    private Double tenderAmount; //中标金额

    @Id
    @SequenceGenerator(name="seq_ker_sales_report_tender",allocationSize=1,sequenceName="seq_ker_sales_report_tender")
    @GeneratedValue(generator="seq_ker_sales_report_tender",strategy=GenerationType.SEQUENCE)
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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
