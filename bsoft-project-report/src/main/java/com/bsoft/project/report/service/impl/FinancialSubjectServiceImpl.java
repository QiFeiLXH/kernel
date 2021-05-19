package com.bsoft.project.report.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.project.report.dto.FinancialSubjectDTO;
import com.bsoft.project.report.entity.primary.FinancialSubjectDO;
import com.bsoft.project.report.manager.FinancialSubjectManager;
import com.bsoft.project.report.service.FinancialSubjectService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.report.service.impl
 * @Author: Xuhui Lin
 * @CreateTime: 2019-12-10 17:39
 * @Description:
 */
@Service
public class FinancialSubjectServiceImpl implements FinancialSubjectService {
    private static final Logger logger = LoggerFactory.getLogger(FinancialSubjectServiceImpl.class);
    @Autowired
    private FinancialSubjectManager financialSubjectManager;
    @Autowired
    private IGenerator generator;

    @Override
    public List<FinancialSubjectDTO> findCostSubject(){
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<FinancialSubjectDO> financialSubjectDOList = financialSubjectManager.findCostSubject();
        long times = timeConsumer.end();
        logger.info("获取报销费用-费用科目列表耗时:{}",times);
        List<FinancialSubjectDTO> financialSubjectDTOList = generator.convert(financialSubjectDOList,FinancialSubjectDTO.class);
        return financialSubjectDTOList;
    }
}
