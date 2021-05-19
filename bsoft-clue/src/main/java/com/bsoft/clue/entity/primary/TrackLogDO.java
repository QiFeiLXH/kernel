package com.bsoft.clue.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "bsoftmis.xs_xsgz")
public class TrackLogDO {
    private Integer trackId;
    private Integer clueId;
    private Date submitDate;
    private Integer tracker;
    private Integer stage;
    private String content;
    private java.sql.Date signDate;
    private String submitter;
    private Date trackDate;
    private Double software;
    private Double hardware;
    private Double firstAmount;
    private Double sysSoftware;
    private Double signChance;
    private Date startDate;
    private Date endDate;
    private Integer workLogId;
    private Integer clueNature;
    private String address;
    private String target;
    private Date trackStartDate;

    @Id
    @Column(name = "gzid")
    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    @Column(name = "xsbh")
    public Integer getClueId() {
        return clueId;
    }

    public void setClueId(Integer clueId) {
        this.clueId = clueId;
    }

    @Column(name = "djrq")
    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
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

    @Column(name = "gzqk")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "yjqysj")
    public java.sql.Date getSignDate() {
        return signDate;
    }

    public void setSignDate(java.sql.Date signDate) {
        this.signDate = signDate;
    }

    @Column(name = "djry")
    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    @Column(name = "gzrq")
    public Date getTrackDate() {
        return trackDate;
    }

    public void setTrackDate(Date trackDate) {
        this.trackDate = trackDate;
    }

    @Column(name = "yjrje")
    public Double getSoftware() {
        return software;
    }

    public void setSoftware(Double software) {
        this.software = software;
    }

    @Column(name = "yjskje")
    public Double getFirstAmount() {
        return firstAmount;
    }

    public void setFirstAmount(Double firstAmount) {
        this.firstAmount = firstAmount;
    }

    @Column(name = "yjyje")
    public Double getHardware() {
        return hardware;
    }

    public void setHardware(Double hardware) {
        this.hardware = hardware;
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

    @Column(name = "bfkssj")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name = "bfjssj")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Column(name = "rzid")
    public Integer getWorkLogId() {
        return workLogId;
    }

    public void setWorkLogId(Integer workLogId) {
        this.workLogId = workLogId;
    }

    @Column(name = "xsxz")
    public Integer getClueNature() {
        return clueNature;
    }

    public void setClueNature(Integer clueNature) {
        this.clueNature = clueNature;
    }
    @Column(name = "bfdd")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Column(name = "bfrw")
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Column(name = "gzkssj")
    public Date getTrackStartDate() {
        return trackStartDate;
    }

    public void setTrackStartDate(Date trackStartDate) {
        this.trackStartDate = trackStartDate;
    }
}
