package com.bsoft.hr.dto;

import java.io.Serializable;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/24 16:42
 * @Description 绩效保存结果
 */
public class PerformanceSaveResultDTO implements Serializable {
    /** 成功数量 */
    private Integer successCount;
    /** 失败数量 */
    private Integer failCount;

    public Integer getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(Integer successCount) {
        this.successCount = successCount;
    }

    public Integer getFailCount() {
        return failCount;
    }

    public void setFailCount(Integer failCount) {
        this.failCount = failCount;
    }
}
