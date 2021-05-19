package com.bsoft.project.report.manager;

import com.bsoft.project.report.entity.primary.FinancialSubjectDO;

import java.util.List;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.report.manager
 * @Author: Xuhui Lin
 * @CreateTime: 2019-12-10 17:36
 * @Description:
 */
public interface FinancialSubjectManager {
    public List<FinancialSubjectDO> findCostSubject();
}
