package com.bsoft.clue.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "bsoftmis.xs_xmxs")
public class ClueDO {
    private Integer id; //线索编号
    private String customerId;//客户编码
    private Integer tracker; //跟单人员
    private Integer stage; //目前阶段
    private Integer status; //线索状态
    private Date signDate; //预计签约时间
    private Date trackDate; //跟单日期
    private Integer projectFlag; //立项标志
    private Integer closed; //关闭标志
    private Double software;  //预计软件额
    private Double hardware; //预计硬件额
    private Double firstAmount; //预计首款金额
    private Double sysSoftware; //预计系统软件金额
    private Double signChance; //签约概率
    private String content; //最新跟踪情况
    private Date trackTime;//跟踪时间
    private Integer clueNature;//线索性质

    @Id
    @Column(name = "xsbh")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "khbm")
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Column(name = "gdry")
    public Integer getTracker() {
        return tracker;
    }

    public void setTracker(Integer tracker) {
        this.tracker = tracker;
    }

    @Column(name = "mqjd")
    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
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

    @Column(name = "gzsj")
    public Date getTrackDate() {
        return trackDate;
    }

    public void setTrackDate(Date trackDate) {
        this.trackDate = trackDate;
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

    @Column(name = "zxgzqk")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "gzrq")
    public Date getTrackTime() {
        return trackTime;
    }

    public void setTrackTime(Date trackTime) {
        this.trackTime = trackTime;
    }

    @Column(name = "xsxz")
    public Integer getClueNature() {
        return clueNature;
    }

    public void setClueNature(Integer clueNature) {
        this.clueNature = clueNature;
    }
}
