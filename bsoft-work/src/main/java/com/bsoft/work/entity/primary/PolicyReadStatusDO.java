package com.bsoft.work.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @author Huang GH
 * @date 2021/5/11 16:23
 */
@Entity
@Table(name = "POL_POLICY")
public class PolicyReadStatusDO {
    /**
     * 主键
     */
    @Id
    private Integer Id;
    /**
     * 标题
     */
    private String title;
    /**
     *所属委员会ID
     */
    private  Integer councilId;
    /**
     * 委员会名称
     */
    private String councilName;
    /**
     * 阅读截止日期
     */
    private Date deadLineDate;
    /**
     *发布日期
     */
    private Date publishDate;
    /**
     * 已阅
     */
    @Transient
    private Integer isRead;
    /**
     * 未阅读
     */
    @Transient
    private Integer noRead;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCouncilId() {
        return councilId;
    }

    public void setCouncilId(Integer councilId) {
        this.councilId = councilId;
    }

    public String getCouncilName() {
        return councilName;
    }

    public void setCouncilName(String councilName) {
        this.councilName = councilName;
    }

    public Date getDeadLineDate() {
        return deadLineDate;
    }

    public void setDeadLineDate(Date deadLineDate) {
        this.deadLineDate = deadLineDate;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    public Integer getNoRead() {
        return noRead;
    }

    public void setNoRead(Integer noRead) {
        this.noRead = noRead;
    }
}
