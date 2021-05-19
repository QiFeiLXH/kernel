package com.bsoft.common.entity.primary;

/**
 * @BelongsProject: bsoft-office-server
 * @BelongsPackage: com.bsoft.office.common.exportExcel
 * @Author: Qi fei
 * @CreateTime: 2020-07-26 10:43
 * @Description: 导入结果
 */
public class ImportResultDO {
    /** 成功数量 */
    private Integer successCount;
    /** 失败数量 */
    private Integer failCount;

    public ImportResultDO() {}

    public ImportResultDO(Integer successCount, Integer failCount) {
        this.successCount = successCount;
        this.failCount = failCount;
    }

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
