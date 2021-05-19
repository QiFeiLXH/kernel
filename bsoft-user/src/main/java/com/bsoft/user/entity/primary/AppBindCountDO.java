package com.bsoft.user.entity.primary;

import java.util.Date;

/**
 * @author: zy
 * @date: 2020/10/21
 * @description  APP用户绑定（解绑）情况统计
 */
public class AppBindCountDO {
    /* 日期 */
    private Date countDate;
    /* 绑定人数 */
    private Integer bindCount;
    /* 解绑人数 */
    private Integer unBindCount;
    /* 净增人数 */
    private Integer absoluteCount;

    public Date getCountDate() {
        return countDate;
    }

    public void setCountDate(Date countDate) {
        this.countDate = countDate;
    }

    public Integer getBindCount() {
        return bindCount;
    }

    public void setBindCount(Integer bindCount) {
        this.bindCount = bindCount;
    }

    public Integer getUnBindCount() {
        return unBindCount;
    }

    public void setUnBindCount(Integer unBindCount) {
        this.unBindCount = unBindCount;
    }

    public Integer getAbsoluteCount() {
        return absoluteCount;
    }

    public void setAbsoluteCount(Integer absoluteCount) {
        this.absoluteCount = absoluteCount;
    }
}
