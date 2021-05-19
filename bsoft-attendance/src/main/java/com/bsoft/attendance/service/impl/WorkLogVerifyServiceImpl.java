package com.bsoft.attendance.service.impl;

import com.bsoft.attendance.dto.WorkLogVerifyDTO;
import com.bsoft.attendance.entity.primary.WorkLogVerifyDO;
import com.bsoft.attendance.manager.WorkLogVerifyManager;
import com.bsoft.attendance.service.WorkLogVerifyServcie;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

@Service
public class WorkLogVerifyServiceImpl implements WorkLogVerifyServcie {
    private static final Logger logger = LoggerFactory.getLogger(WorkLogVerifyServiceImpl.class);
    private static final Integer DEFAULT_PAGESIZE = 20;
    @Autowired
    private WorkLogVerifyManager workLogVerifyManager;
    @Autowired
    private IGenerator generator;

    @Override
    public Result<WorkLogVerifyDTO> getPendingWorkLog(String personId, String content, Integer page, Integer size) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<WorkLogVerifyDO> results = workLogVerifyManager.getPendingWorkLog(personId,content,page,size);
        long times = timeConsumer.end();
        logger.info("工号:{}获取待审核日志耗时:{}",personId,times);
        return ResultUtils.parseResult(results,WorkLogVerifyDTO.class);
    }

    @Override
    public Result<WorkLogVerifyDTO> getPendingWorkLog(String personId, String content, Integer page) {
        return getPendingWorkLog(personId,content,page,DEFAULT_PAGESIZE);
    }

    @Override
    public Boolean verifyWorkLog(WorkLogVerifyDTO workLogVerify) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        WorkLogVerifyDO workLogVerifyDO = generator.convert(workLogVerify,WorkLogVerifyDO.class);
        workLogVerifyManager.verifyWorkLog(workLogVerifyDO);
        long times = timeConsumer.end();
        logger.info("审核工号:{}-姓名:{}的日志耗时:",new Object[]{workLogVerify.getPersonId(),workLogVerify.getPersonName(),times});
        return true;
    }
}
