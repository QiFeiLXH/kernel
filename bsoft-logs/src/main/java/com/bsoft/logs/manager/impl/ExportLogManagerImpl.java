package com.bsoft.logs.manager.impl;

import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.logs.dao.primary.ExportLogDao;
import com.bsoft.logs.entity.primary.ExportLogDO;
import com.bsoft.logs.manager.ExportLogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.logs.manager.impl
 * @Author: Xuhui Lin
 * @CreateTime: 2020-06-04 20:57
 * @Description:
 */
@Service
public class ExportLogManagerImpl implements ExportLogManager {
    @Autowired
    private ExportLogDao exportLogDao;
    @Autowired
    private ServerDateManager serverDateManager;
    @Override
    @Transactional
    public void saveExportLog(ExportLogDO exportLogDO) {
        Date serverDateTime = serverDateManager.getServerDateTime();
        exportLogDO.setExportDate(serverDateTime);
        exportLogDao.save(exportLogDO);
    }
}
