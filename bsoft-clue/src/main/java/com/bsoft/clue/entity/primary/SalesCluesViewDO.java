package com.bsoft.clue.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "bsoftmis.sales_index_view")
public class SalesCluesViewDO {
    /**
     * 是否需更新
     */
    @Column(name="xslb_15")
    private Integer updateFlag;

    /**
     * 线索编号
     */
    @Id
    @Column(name="xslb_01")
    private Integer id;

    /**
     * 客户名称
     */
    @Column(name="xslb_17")
    private String customerName;

    /**
     * 产品内容
     */
    @Column(name="xslb_05")
    private String productContent;

    /**
     * 新老客户
     */
    @Column(name="xslb_28")
    private String newFlag;

    /**
     * 类别
     */
    @Column(name="xslb_23")
    private String type;

    /**
     * 预计软件额
     */
    @Column(name="xslb_06")
    private Double softwareAmount;

    /**
     * 预计硬件额
     */
    @Column(name="xslb_07")
    private Double hardwareAmount;

    /**
     * 提交日期
     */
    @Column(name="xslb_12")
    private String submitDate;

    /**
     * 预计签单月份
     */
    @Column(name="xslb_44")
    private String signMonth;

    /**
     * 签单概率
     */
    @Column(name="xslb_39")
    private Integer signProbability;

    /**
     * 登记日期
     */
    @Column(name="xslb_52")
    private String registerDate;

    /**
     * 立项日期
     */
    @Column(name="xslb_45")
    private String approvalDate;

    /**
     * 跟踪日期
     */
    @Column(name="xslb_11")
    private String trackDate;

    /**
     * 提交标志
     */
    @Column(name="xslb_50")
    private Integer submitFlag;

    /**
     * 销售区域
     */
    @Column(name="xslb_21")
    private String salesArea;

    /**
     * 客户状态
     */
    @Column(name="xslb_22")
    private String customerStatus;

    /**
     * 省份
     */
    @Column(name="xslb_24")
    private String province;

    /**
     * 客户等级
     */
    @Column(name="xslb_25")
    private String customerLevel;

    /**
     * 医院等级
     */
    @Column(name="xslb_26")
    private String hospitalLevel;

    /**
     * 基本信息
     */
    @Column(name="xslb_27")
    private String baseInfo;

    /**
     * 大客户 标志 0:否 1:是
     */
    @Column(name="xslb_18")
    private String bigCustomer;

    /**
     * 线索性质  字典"portal.main.dic.cluesNature"
     */
    @Column(name="xslb_53")
    private String cluesNature;

    /**
     * 切入阶段 字典 "portal.main.dic.salesStage"
     */
    @Column(name="xslb_54")
    private String entryStage;

    /**
     * 跟单人
     */
    @Column(name="xslb_30")
    private String trackPerson;

    /**
     * 跟单部门
     */
    @Column(name="xslb_56")
    private String trackDept;

    /**
     * 跟单部门代码
     */
    @Column(name="XSLB_31")
    private String trackDeptNo;

    /**
     * 线索来源  字典"portal.main.dic.cluesSource"
     */
    @Column(name="xslb_55")
    private String cluesSource;

    /**
     * 销售总监工号
     */
    @Column(name="xslb_33")
    private String salesDirector;

    /**
     * 区域负责工号
     */
    @Column(name="xslb_34")
    private String regionalHead;

    /**
     * 支持领导
     */
    @Column(name="xslb_35")
    private String supportLeader;

    /**
     * 竞争对手
     */
    @Column(name="xslb_36")
    private String competitor;

    /**
     * 预计首款
     */
    @Column(name="xslb_37")
    private Double firstAmount;

    /**
     * 预计系统软件额
     */
    @Column(name="xslb_08")
    private Double systemSoftwareAmount;

    /**
     * 预计签约时间
     */
    @Column(name="xslb_38")
    private String signTime;

    /**
     * 目前阶段id
     */
    @Column(name="xslb_09")
    private String currentStageId;

    /**
     * 目前阶段
     */
    @Column(name="xslb_19")
    private String currentStage;

    /**
     * 销售阶段
     */
    @Column(name="xslb_40")
    private String salesStage;

    /**
     * 招投标
     */
    @Column(name="xslb_41")
    private Integer biddingFlag;

    /**
     * 投标日期
     */
    @Column(name="xslb_42")
    private String biddingDate;

    /**
     * 最新跟踪情况
     */
    @Column(name="xslb_10")
    private String trackInfo;

    /**
     * 立项标志
     */
    @Column(name="xslb_46")
    private Integer approvalFlag;

    /**
     * 销售总监姓名
     */
    @Column(name="xslb_47")
    private String salesDirectorName;

    /**
     * 区域负责姓名
     */
    @Column(name="xslb_48")
    private String regionalHeadName;

    /**
     * 支持领导姓名
     */
    @Column(name="xslb_49")
    private String supportLeaderName;

    /**
     * 备注信息、切入说明
     */
    @Column(name="xslb_51")
    private String remarkInfo;

    /**
     * 客户id
     */
    @Column(name="xslb_03")
    private String customerId;

    /**
     * 大客户 标志 0 1
     */
    @Column(name="xslb_04")
    private Integer bigCustomerFlag;

    /**
     * 项目ID
     */
    @Column(name="xslb_57")
    private String projectId;

    /**
     * 跟单人员工号
     */
    @Column(name="xslb_58")
    private String trackPersonId;

    /**
     * 跟单人员 人员表id
     */
    @Column(name="xslb_16")
    private String trackUserId;

    /**
     * 销售区域编码
     */
    @Column(name="xslb_59")
    private String salesAreaNo;

    /**
     * 预计签约时间
     */
    @Column(name="xslb_61")
    private Date signDate;

    /**
     * 业务归属
     */
    @Column(name="xslb_62")
    private String businessBelong;

    /**
     * 预计净销售额软件  预计净软件额
     */
    @Column(name="xslb_63")
    private Double estimateNetSales;


    public Integer getUpdateFlag() {
        return updateFlag;
    }

    public void setUpdateFlag(Integer updateFlag) {
        this.updateFlag = updateFlag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductContent() {
        return productContent;
    }

    public void setProductContent(String productContent) {
        this.productContent = productContent;
    }

    public String getNewFlag() {
        return newFlag;
    }

    public void setNewFlag(String newFlag) {
        this.newFlag = newFlag;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getSoftwareAmount() {
        return softwareAmount;
    }

    public void setSoftwareAmount(Double softwareAmount) {
        this.softwareAmount = softwareAmount;
    }

    public Double getHardwareAmount() {
        return hardwareAmount;
    }

    public void setHardwareAmount(Double hardwareAmount) {
        this.hardwareAmount = hardwareAmount;
    }

    public String getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(String submitDate) {
        this.submitDate = submitDate;
    }

    public String getSignMonth() {
        return signMonth;
    }

    public void setSignMonth(String signMonth) {
        this.signMonth = signMonth;
    }

    public Integer getSignProbability() {
        return signProbability;
    }

    public void setSignProbability(Integer signProbability) {
        this.signProbability = signProbability;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getTrackDate() {
        return trackDate;
    }

    public void setTrackDate(String trackDate) {
        this.trackDate = trackDate;
    }

    public Integer getSubmitFlag() {
        return submitFlag;
    }

    public void setSubmitFlag(Integer submitFlag) {
        this.submitFlag = submitFlag;
    }

    public String getSalesArea() {
        return salesArea;
    }

    public void setSalesArea(String salesArea) {
        this.salesArea = salesArea;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(String customerLevel) {
        this.customerLevel = customerLevel;
    }

    public String getHospitalLevel() {
        return hospitalLevel;
    }

    public void setHospitalLevel(String hospitalLevel) {
        this.hospitalLevel = hospitalLevel;
    }

    public String getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(String baseInfo) {
        this.baseInfo = baseInfo;
    }

    public String getBigCustomer() {
        return bigCustomer;
    }

    public void setBigCustomer(String bigCustomer) {
        this.bigCustomer = bigCustomer;
    }

    public String getCluesNature() {
        return cluesNature;
    }

    public void setCluesNature(String cluesNature) {
        this.cluesNature = cluesNature;
    }

    public String getEntryStage() {
        return entryStage;
    }

    public void setEntryStage(String entryStage) {
        this.entryStage = entryStage;
    }

    public String getTrackPerson() {
        return trackPerson;
    }

    public void setTrackPerson(String trackPerson) {
        this.trackPerson = trackPerson;
    }

    public String getTrackDept() {
        return trackDept;
    }

    public void setTrackDept(String trackDept) {
        this.trackDept = trackDept;
    }

    public String getTrackDeptNo() {
        return trackDeptNo;
    }

    public void setTrackDeptNo(String trackDeptNo) {
        this.trackDeptNo = trackDeptNo;
    }

    public String getCluesSource() {
        return cluesSource;
    }

    public void setCluesSource(String cluesSource) {
        this.cluesSource = cluesSource;
    }

    public String getSalesDirector() {
        return salesDirector;
    }

    public void setSalesDirector(String salesDirector) {
        this.salesDirector = salesDirector;
    }

    public String getRegionalHead() {
        return regionalHead;
    }

    public void setRegionalHead(String regionalHead) {
        this.regionalHead = regionalHead;
    }

    public String getSupportLeader() {
        return supportLeader;
    }

    public void setSupportLeader(String supportLeader) {
        this.supportLeader = supportLeader;
    }

    public String getCompetitor() {
        return competitor;
    }

    public void setCompetitor(String competitor) {
        this.competitor = competitor;
    }

    public Double getFirstAmount() {
        return firstAmount;
    }

    public void setFirstAmount(Double firstAmount) {
        this.firstAmount = firstAmount;
    }

    public Double getSystemSoftwareAmount() {
        return systemSoftwareAmount;
    }

    public void setSystemSoftwareAmount(Double systemSoftwareAmount) {
        this.systemSoftwareAmount = systemSoftwareAmount;
    }

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
    }

    public String getCurrentStageId() {
        return currentStageId;
    }

    public void setCurrentStageId(String currentStageId) {
        this.currentStageId = currentStageId;
    }

    public String getCurrentStage() {
        return currentStage;
    }

    public void setCurrentStage(String currentStage) {
        this.currentStage = currentStage;
    }

    public String getSalesStage() {
        return salesStage;
    }

    public void setSalesStage(String salesStage) {
        this.salesStage = salesStage;
    }

    public Integer getBiddingFlag() {
        return biddingFlag;
    }

    public void setBiddingFlag(Integer biddingFlag) {
        this.biddingFlag = biddingFlag;
    }

    public String getBiddingDate() {
        return biddingDate;
    }

    public void setBiddingDate(String biddingDate) {
        this.biddingDate = biddingDate;
    }

    public String getTrackInfo() {
        return trackInfo;
    }

    public void setTrackInfo(String trackInfo) {
        this.trackInfo = trackInfo;
    }

    public Integer getApprovalFlag() {
        return approvalFlag;
    }

    public void setApprovalFlag(Integer approvalFlag) {
        this.approvalFlag = approvalFlag;
    }

    public String getSalesDirectorName() {
        return salesDirectorName;
    }

    public void setSalesDirectorName(String salesDirectorName) {
        this.salesDirectorName = salesDirectorName;
    }

    public String getRegionalHeadName() {
        return regionalHeadName;
    }

    public void setRegionalHeadName(String regionalHeadName) {
        this.regionalHeadName = regionalHeadName;
    }

    public String getSupportLeaderName() {
        return supportLeaderName;
    }

    public void setSupportLeaderName(String supportLeaderName) {
        this.supportLeaderName = supportLeaderName;
    }

    public String getRemarkInfo() {
        return remarkInfo;
    }

    public void setRemarkInfo(String remarkInfo) {
        this.remarkInfo = remarkInfo;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Integer getBigCustomerFlag() {
        return bigCustomerFlag;
    }

    public void setBigCustomerFlag(Integer bigCustomerFlag) {
        this.bigCustomerFlag = bigCustomerFlag;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getTrackPersonId() {
        return trackPersonId;
    }

    public void setTrackPersonId(String trackPersonId) {
        this.trackPersonId = trackPersonId;
    }

    public String getSalesAreaNo() {
        return salesAreaNo;
    }

    public void setSalesAreaNo(String salesAreaNo) {
        this.salesAreaNo = salesAreaNo;
    }

    public String getTrackUserId() {
        return trackUserId;
    }

    public void setTrackUserId(String trackUserId) {
        this.trackUserId = trackUserId;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public String getBusinessBelong() {
        return businessBelong;
    }

    public void setBusinessBelong(String businessBelong) {
        this.businessBelong = businessBelong;
    }

    public Double getEstimateNetSales() {
        return estimateNetSales;
    }

    public void setEstimateNetSales(Double estimateNetSales) {
        this.estimateNetSales = estimateNetSales;
    }
}
