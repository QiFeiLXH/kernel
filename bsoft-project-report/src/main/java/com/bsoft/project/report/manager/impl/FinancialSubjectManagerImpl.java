package com.bsoft.project.report.manager.impl;

import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.project.report.entity.primary.FinancialSubjectDO;
import com.bsoft.project.report.manager.FinancialSubjectManager;
import com.bsoft.project.report.repository.primary.FinancialSubjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.report.manager.impl
 * @Author: Xuhui Lin
 * @CreateTime: 2019-12-10 17:36
 * @Description:
 */
@Component
public class FinancialSubjectManagerImpl implements FinancialSubjectManager {
    private static final Logger logger = LoggerFactory.getLogger(FinancialSubjectManagerImpl.class);

    @Autowired
    private FinancialSubjectRepository financialSubjectRepository;

    public List<FinancialSubjectDO> findCostSubject(){
        List<FinancialSubjectDO> result = financialSubjectRepository.findCostSubject();
        return result;
    }
}
