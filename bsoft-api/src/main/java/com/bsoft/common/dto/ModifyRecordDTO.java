package com.bsoft.common.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/10
 * @Description
 */
public class ModifyRecordDTO implements Serializable {
    private Integer id;
    private Integer modifyDetail;
    private String modifyType;
    private String mainId;
    private String modifyContent;
    private String modifyPersonId;
    private String modifyPersonName;
    private Date modifyDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getModifyDetail() {
        return modifyDetail;
    }

    public void setModifyDetail(Integer modifyDetail) {
        this.modifyDetail = modifyDetail;
    }

    public String getModifyType() {
        return modifyType;
    }

    public void setModifyType(String modifyType) {
        this.modifyType = modifyType;
    }

    public String getMainId() {
        return mainId;
    }

    public void setMainId(String mainId) {
        this.mainId = mainId;
    }

    public String getModifyContent() {
        return modifyContent;
    }

    public void setModifyContent(String modifyContent) {
        this.modifyContent = modifyContent;
    }

    public String getModifyPersonId() {
        return modifyPersonId;
    }

    public void setModifyPersonId(String modifyPersonId) {
        this.modifyPersonId = modifyPersonId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyPersonName() {
        return modifyPersonName;
    }

    public void setModifyPersonName(String modifyPersonName) {
        this.modifyPersonName = modifyPersonName;
    }
}
