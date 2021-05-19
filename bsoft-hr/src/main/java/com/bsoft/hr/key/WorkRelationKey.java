package com.bsoft.hr.key;

import java.io.Serializable;

/**
 * @Author zhanglf
 * @Date 2020/8/18 18:14
 * @Description 假期 加班关联表联合主键
 */

public class WorkRelationKey implements Serializable {
    /** 员工工号 */
    private Integer detailId;
    private Integer workId;

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }
}
