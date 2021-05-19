package com.bsoft.clue.entity.primary;

import com.bsoft.dictionary.annotation.clue.ClueNatureDic;
import com.bsoft.dictionary.annotation.clue.ClueStageDic;
import com.bsoft.dictionary.annotation.clue.ClueStatusDic;
import com.bsoft.dictionary.annotation.dept.DeptAllDic;
import com.bsoft.dictionary.annotation.person.PersonDic;
import org.checkerframework.checker.units.qual.C;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "KER_CLUE_CLUELIST_VIEW")
public class ClueViewDO {
    private Integer clueId; //线索编号
    private String customerId; //客户编码
//    @DeptAllDic
    private String area; //市场区域
//    @ClueStageDic
    private Integer stage; //目前阶段
//    @PersonDic
    private String tracker; //跟单人员
//    @ClueStatusDic
    private Integer status; //线索状态
    private Date signDate; //预计签约时间
    private Date trackDate; //跟踪日期
    private Date submitDate;//提交日期
    private Integer projectFlag; //立项标志
    private Integer closed; //关闭标志
    private String customerName;//客户名称
    private String productContent; //产品内容
    private Integer flag;//需更新日志标志
    private Integer trackerId; //跟单人员ID
    private Double software;  //预计软件额
    private Double hardware; //预计硬件额
    private Double firstAmount; //预计首款金额
    private Double sysSoftware; //预计系统软件金额
    private Double signChance; //签约概率
//    @ClueNatureDic
    private Integer clueNature;//线索性质
    private String group;//归属群

    @Id
    @Column(name = "xsbh")
    public Integer getClueId() {
        return clueId;
    }

    public void setClueId(Integer clueId) {
        this.clueId = clueId;
    }

    @Column(name = "khbm")
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Column(name = "scqy")
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Column(name = "mqjd")
    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    @Column(name = "gdry")
    public String getTracker() {
        return tracker;
    }

    public void setTracker(String tracker) {
        this.tracker = tracker;
    }

    @Column(name = "xszt")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "yjqysj")
    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    @Column(name = "gzrq")
    public Date getTrackDate() {
        return trackDate;
    }

    public void setTrackDate(Date trackDate) {
        this.trackDate = trackDate;
    }

    @Column(name = "tjrq")
    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    @Column(name = "lxbz")
    public Integer getProjectFlag() {
        return projectFlag;
    }

    public void setProjectFlag(Integer projectFlag) {
        this.projectFlag = projectFlag;
    }

    @Column(name = "gbbz")
    public Integer getClosed() {
        return closed;
    }

    public void setClosed(Integer closed) {
        this.closed = closed;
    }

    @Column(name = "khmc")
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Column(name = "cpnr")
    public String getProductContent() {
        return productContent;
    }

    public void setProductContent(String productContent) {
        this.productContent = productContent;
    }

    @Column(name = "flag")
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Column(name = "gdryid")
    public Integer getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(Integer trackerId) {
        this.trackerId = trackerId;
    }

    @Column(name = "yjrje")
    public Double getSoftware() {
        return software;
    }

    public void setSoftware(Double software) {
        this.software = software;
    }

    @Column(name = "yjyje")
    public Double getHardware() {
        return hardware;
    }

    public void setHardware(Double hardware) {
        this.hardware = hardware;
    }

    @Column(name = "yjskje")
    public Double getFirstAmount() {
        return firstAmount;
    }

    public void setFirstAmount(Double firstAmount) {
        this.firstAmount = firstAmount;
    }

    @Column(name = "yjxtrje")
    public Double getSysSoftware() {
        return sysSoftware;
    }

    public void setSysSoftware(Double sysSoftware) {
        this.sysSoftware = sysSoftware;
    }

    @Column(name = "qygl")
    public Double getSignChance() {
        return signChance;
    }

    public void setSignChance(Double signChance) {
        this.signChance = signChance;
    }

    @Column(name = "xsxz")
    public Integer getClueNature() {
        return clueNature;
    }

    public void setClueNature(Integer clueNature) {
        this.clueNature = clueNature;
    }

    @Column(name = "gssyq")
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
