package com.bsoft.hr.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.hr.condition.LactationQueryCnd;
import com.bsoft.hr.dto.LactationDTO;
import com.bsoft.hr.dto.LactationQueryCndDTO;
import com.bsoft.hr.entity.primary.LactationDO;
import com.bsoft.hr.entity.primary.LactationViewDO;
import com.bsoft.hr.manager.LactationManager;
import com.bsoft.hr.service.LactationService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/5 10:16
 * @Description
 */
@Service
public class LactationServiceImpl implements LactationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LactationServiceImpl.class);

    @Autowired
    private LactationManager lactationManager;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<LactationDTO> getLactationList(LactationQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        LactationQueryCnd cnd = iGenerator.convert(cndDTO, LactationQueryCnd.class);
        Page<LactationViewDO> pages = lactationManager.getLactationList(cnd);
        long times = timeConsumer.end();
        LOGGER.info("查询哺乳期列表耗时：{}", times);
        return ResultUtils.parseResult(pages, LactationDTO.class);
    }

    @Override
    public Integer saveLactation(LactationDTO lactationDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        LactationDO lactationDO = iGenerator.convert(lactationDTO, LactationDO.class);
        Integer id = lactationDO.getId();
        if (id == null) {
            id = lactationManager.saveLactation(lactationDO);
        } else {
            lactationManager.updateLactation(lactationDO);
        }

        long times = timeConsumer.end();
        LOGGER.info("保存工号：{}，哺乳假耗时:{}", lactationDO.getPersonId(),times);
        return id;
    }
}
