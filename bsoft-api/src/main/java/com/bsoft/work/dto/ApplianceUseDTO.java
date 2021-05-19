package com.bsoft.work.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: zy
 * @date: 2020/11/5
 * @description
 */
public class ApplianceUseDTO implements Serializable {
    /**主键*/
    private Integer id;
    /**物品类别id*/
    private Integer type;
    /**物品名称id*/
    private String name;
    /**规格*/
    private String standards;
    /**数量*/
    private Integer quantity;
    /**单价*/
    private Double unitPrice;
    /**金额*/
    private Double money;
    /**领用人id*/
    private String userId;
    /**领用部门id*/
    private String useDept;
    /**归属项目id*/
    private String projectId;
    /**领用日期*/
    private Date useDate;
    /**流水号*/
    private String lshid;

    /**类别*/
    private String typeName;
    /**名称*/
    private String nameName;
    /**领用人*/
    private String userName;
    /**部门*/
    private String useDeptName;
    /**项目*/
    private String projectName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStandards() {
        return standards;
    }

    public void setStandards(String standards) {
        this.standards = standards;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUseDept() {
        return useDept;
    }

    public void setUseDept(String useDept) {
        this.useDept = useDept;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Date getUseDate() {
        return useDate;
    }

    public void setUseDate(Date useDate) {
        this.useDate = useDate;
    }

    public String getLshid() {
        return lshid;
    }

    public void setLshid(String lshid) {
        this.lshid = lshid;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getNameName() {
        return nameName;
    }

    public void setNameName(String nameName) {
        this.nameName = nameName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUseDeptName() {
        return useDeptName;
    }

    public void setUseDeptName(String useDeptName) {
        this.useDeptName = useDeptName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
