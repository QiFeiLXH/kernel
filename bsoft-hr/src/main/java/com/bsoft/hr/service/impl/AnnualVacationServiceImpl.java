package com.bsoft.hr.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.manager.PrimaryKeyManager;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.hr.condition.WorkVacationQueryCnd;
import com.bsoft.hr.dto.AnnualVacationInfoDTO;
import com.bsoft.hr.dto.WorkVacationDTO;
import com.bsoft.hr.dto.WorkVacationQueryCndDTO;
import com.bsoft.hr.entity.primary.AnnualVacationInfoDO;
import com.bsoft.hr.entity.primary.WorkVacationDO;
import com.bsoft.hr.entity.primary.WorkVacationDetailDO;
import com.bsoft.hr.manager.AnnualVacationManager;
import com.bsoft.hr.service.AnnualVacationService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zy
 * @date: 2020/8/26
 * @description
 */
@Service
public class AnnualVacationServiceImpl implements AnnualVacationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AnnualVacationServiceImpl.class);
    @Autowired
    private AnnualVacationManager annualVacationManager;
    @Autowired
    private IGenerator iGenerator;
    @Autowired
    private PrimaryKeyManager primaryKeyManager;

    @Override
    public Result<AnnualVacationInfoDTO> getAnnualVacationInfo(String userId, WorkVacationQueryCndDTO cndDTO){
        TimeConsumer timeConsumer = TimeConsumer.start();
        WorkVacationQueryCnd cnd = iGenerator.convert(cndDTO, WorkVacationQueryCnd.class);
        Page<AnnualVacationInfoDO> page = annualVacationManager.getAnnualVacationInfo(cnd);
        long times = timeConsumer.end();
        LOGGER.info("工号[{}]获取年假信息耗时:{}", userId, times);
        return ResultUtils.parseResult(page, AnnualVacationInfoDTO.class);
    }

    @Override
    public void addAnnualVacation(String userId, WorkVacationDTO workVacationDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        WorkVacationDO workVacationDO = iGenerator.convert(workVacationDTO, WorkVacationDO.class);
        workVacationDO = annualVacationManager.processWorkVacationForSave(workVacationDO);
        annualVacationManager.saveFromHr(workVacationDO);
        long times = timeConsumer.end();
        LOGGER.info("工号[{}]新增年假信息耗时:{}", userId,  times);
    }

    @Override
    public void updateAnnualVacation(String userId, WorkVacationDTO workVacationDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        WorkVacationDO workVacationDO = iGenerator.convert(workVacationDTO, WorkVacationDO.class);
        List<WorkVacationDO> workVacationDOList = new ArrayList<>();
        workVacationDOList.add(workVacationDO);
        List<WorkVacationDetailDO> deleteList = annualVacationManager.getWorkVacationDetailsNeedDelete(workVacationDOList);
        workVacationDO = annualVacationManager.processWorkVacationForUpdate(workVacationDO);
        annualVacationManager.updateFromHr(workVacationDO, deleteList);
        long times = timeConsumer.end();
        LOGGER.info("工号[{}]修改年假信息耗时:{}", userId, times);
    }

}
