package com.bsoft.attendance.entity.primary;

/**
 * @Author zhanglf
 * @Date 2020-04-01 16:45
 * @Version 1.0
 * @Description
 */
public class ProjectLogNeedDealCountDO {
    private Integer needAudit;
    private Integer needEdit;
    private Integer supportNeedEdit;

    public Integer getNeedAudit() {
        return needAudit;
    }

    public void setNeedAudit(Integer needAudit) {
        this.needAudit = needAudit;
    }

    public Integer getNeedEdit() {
        return needEdit;
    }

    public void setNeedEdit(Integer needEdit) {
        this.needEdit = needEdit;
    }

    public Integer getSupportNeedEdit() {
        return supportNeedEdit;
    }

    public void setSupportNeedEdit(Integer supportNeedEdit) {
        this.supportNeedEdit = supportNeedEdit;
    }
}
