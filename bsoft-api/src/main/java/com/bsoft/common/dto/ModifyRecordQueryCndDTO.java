package com.bsoft.common.dto;

import java.io.Serializable;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/10 16:46
 * @Description
 */
public class ModifyRecordQueryCndDTO implements Serializable {
    /** 页码 */
    private Integer pageNo;
    /** 页量 */
    private Integer pageSize;
    /** 修改人 */
    private String modifyPersonId;
    /** 主表id */
    private String mainId;
    /** 修改明细 */
    private Integer modifyDetail;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getModifyPersonId() {
        return modifyPersonId;
    }

    public void setModifyPersonId(String modifyPersonId) {
        this.modifyPersonId = modifyPersonId;
    }

    public String getMainId() {
        return mainId;
    }

    public void setMainId(String mainId) {
        this.mainId = mainId;
    }

    public Integer getModifyDetail() {
        return modifyDetail;
    }

    public void setModifyDetail(Integer modifyDetail) {
        this.modifyDetail = modifyDetail;
    }
}
