package com.bsoft.sales.report.entity.primary;

import com.bsoft.dictionary.annotation.clue.ClueStageDic;
import com.bsoft.dictionary.annotation.customer.CustomerDic;
import com.bsoft.dictionary.annotation.dept.DeptAllDic;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ker_sales_report_clue")
public class DynamicClueDO {
    private Integer id; //主键
    private Integer dynamicId; //销售动态ID
    private Integer clueId; //线索ID
    @CustomerDic
    private String customerId; //客户编码
    @ClueStageDic
    private Integer stage; //目前阶段
    private Date signDate; //预计签约日期
    @DeptAllDic
    private String area; //所属区域
    private String content; //产品内容
    private Double amount; //预计软件额

    @Id
    @SequenceGenerator(name="seq_ker_sales_report_clue",allocationSize=1,sequenceName="seq_ker_sales_report_clue")
    @GeneratedValue(generator="seq_ker_sales_report_clue",strategy=GenerationType.SEQUENCE)
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

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
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
