package com.bsoft.sales.report.entity.primary;

import com.bsoft.dictionary.annotation.clue.ClueStageDic;
import com.bsoft.dictionary.annotation.customer.CustomerDic;
import com.bsoft.dictionary.annotation.dept.DeptAllDic;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ker_sales_report_clue_view")
public class DynamicClueViewDO {
    private Integer id; //主键
    private Integer dynamicId; //销售动态ID
    private Integer clueId; //线索ID
    private String customerId; //客户编码
    private String customerIdText; //客户名称
    private Integer stage; //目前阶段
    private String stageText; //目前阶段名称
    private Date signDate; //预计签约日期
    private String area; //所属区域
    private String areaText; //所属区域名称
    private String content; //产品内容
    private Double amount; //预计软件额

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

    public Integer getClueId() {
        return clueId;
    }

    public void setClueId(Integer clueId) {
        this.clueId = clueId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerIdText() {
        return customerIdText;
    }

    public void setCustomerIdText(String customerIdText) {
        this.customerIdText = customerIdText;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public String getStageText() {
        return stageText;
    }

    public void setStageText(String stageText) {
        this.stageText = stageText;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
