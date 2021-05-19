package com.bsoft.person.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2021/2/3 15:24
 * @Description
 */
@Entity
@Table(name="BSOFT_PORTAL.WORK_PUB_CARD_VIEW")
public class BusinessCardViewDO {
    @Id
    private Integer id;
    /** 工号 */
    private String userId;
    private String userName;
    /** 简拼 */
    private String simpleCode;
    /** 部门 */
    private String dept;
    private String deptName;
    /** 申请日期 */
    private Date applyDate;
    /** 岗位 */
    private String postName;
    /** 邮箱 */
    private String email;
    /** 传真 */
    private String fax;
    /** 电话 */
    private String telephone;
    /** 移动电话 */
    private String mobilePhone;
    /** 地址 */
    private String address;
    /** 状态 */
    private Integer status;
    private String statusText;
    /** 申请支付日期 */
    private Date applyPayDate;
    /** 项目id */
    private String projectId;
    private String projectName;
    /** 费用类别 */
    private Integer costType;
    private String costTypeText;
    /** 核算口径 */
    private Integer accountCaliber;
    private String accountCaliberText;
    /** 金额 */
    private Double amount;
    /** 流水号 */
    private String lshid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSimpleCode() {
        return simpleCode;
    }

    public void setSimpleCode(String simpleCode) {
        this.simpleCode = simpleCode;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public Date getApplyPayDate() {
        return applyPayDate;
    }

    public void setApplyPayDate(Date applyPayDate) {
        this.applyPayDate = applyPayDate;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getCostType() {
        return costType;
    }

    public void setCostType(Integer costType) {
        this.costType = costType;
    }

    public String getCostTypeText() {
        return costTypeText;
    }

    public void setCostTypeText(String costTypeText) {
        this.costTypeText = costTypeText;
    }

    public Integer getAccountCaliber() {
        return accountCaliber;
    }

    public void setAccountCaliber(Integer accountCaliber) {
        this.accountCaliber = accountCaliber;
    }

    public String getAccountCaliberText() {
        return accountCaliberText;
    }

    public void setAccountCaliberText(String accountCaliberText) {
        this.accountCaliberText = accountCaliberText;
    }

    public String getLshid() {
        return lshid;
    }

    public void setLshid(String lshid) {
        this.lshid = lshid;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}
