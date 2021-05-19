package com.bsoft.common.dto;

import java.io.Serializable;

/**
 * @BelongsProject: bsoft-office-server
 * @BelongsPackage: com.bsoft.office.common.exportExcel
 * @Author: Qi fei
 * @CreateTime: 2020-07-26 10:43
 * @Description: 导入结果
 */
public class ImportResultDTO implements Serializable {
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
