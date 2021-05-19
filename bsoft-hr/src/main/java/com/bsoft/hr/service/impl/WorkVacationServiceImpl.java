package com.bsoft.hr.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.hr.condition.WorkVacationQueryCnd;
import com.bsoft.hr.dto.WorkVacationDTO;
import com.bsoft.hr.dto.WorkVacationQueryCndDTO;
import com.bsoft.hr.dto.WorkVacationTotalViewDTO;
import com.bsoft.hr.entity.primary.WorkVacationDO;
import com.bsoft.hr.entity.primary.WorkVacationTotalViewDO;
import com.bsoft.hr.manager.WorkVacationManager;
import com.bsoft.hr.service.WorkVacationService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

/**
 * @author: zy
 * @date: 2020/8/20
 * @description 员工加班调休假ServiceImpl
 */
@Service
public class WorkVacationServiceImpl implements WorkVacationService {

    private static final Logger logger = LoggerFactory.getLogger(WorkVacationServiceImpl.class);
    @Autowired
    private WorkVacationManager workVacationManager;
    @Autowired
    private IGenerator iGenerator;

    /**
     * 获取加班调休假（总览）
     */
    @Override
    public Result<WorkVacationTotalViewDTO> getWorkVacationTotal(WorkVacationQueryCndDTO cndDTO) {
        WorkVacationQueryCnd cnd = iGenerator.convert(cndDTO, WorkVacationQueryCnd.class);
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<WorkVacationTotalViewDO> page = workVacationManager.getWorkVacationTotal(cnd);
        long times = timeConsumer.end();
        logger.info("取加班调休假（总览）耗时:{}", times);
        return ResultUtils.parseResult(page, WorkVacationTotalViewDTO.class);
    }

    /**
     * 获取加班调休假（个人）
     */
    @Override
    public Result<WorkVacationDTO> getWorkVacationPersonal(WorkVacationQueryCndDTO cndDTO) {
        WorkVacationQueryCnd cnd = iGenerator.convert(cndDTO, WorkVacationQueryCnd.class);
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<WorkVacationDO> page = workVacationManager.getWorkVacationPersonal(cnd);
        long times = timeConsumer.end();
        logger.info("获取加班调休假（个人）耗时:{}", times);
        return ResultUtils.parseResult(page, WorkVacationDTO.class);
    }
}
