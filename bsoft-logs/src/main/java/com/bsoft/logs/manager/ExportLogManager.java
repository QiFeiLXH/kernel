package com.bsoft.logs.manager;

import com.bsoft.logs.entity.primary.ExportLogDO;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.logs.manager
 * @Author: Xuhui Lin
 * @CreateTime: 2020-06-04 20:56
 * @Description:
 */
public interface ExportLogManager {

    void saveExportLog(ExportLogDO exportLogDO);
}
