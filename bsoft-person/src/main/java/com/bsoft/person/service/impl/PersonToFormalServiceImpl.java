package com.bsoft.person.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.person.condition.PersonToFormalQueryCnd;
import com.bsoft.person.dto.PersonToFormalCountDTO;
import com.bsoft.person.dto.PersonToFormalDTO;
import com.bsoft.person.dto.PersonToFormalQueryCndDTO;
import com.bsoft.person.dto.PersonTurViewDTO;
import com.bsoft.person.entity.primary.PersonToFormalCountDO;
import com.bsoft.person.entity.primary.PersonToFormalDO;
import com.bsoft.person.entity.primary.PersonTurViewDO;
import com.bsoft.person.manager.PersonToFormalManager;
import com.bsoft.person.service.PersonToFormalService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/1/29 17:21
 * @Description:
 */
@Service
public class PersonToFormalServiceImpl implements PersonToFormalService {

    private static final Logger logger = LoggerFactory.getLogger(PersonToFormalServiceImpl.class);

    @Autowired
    private PersonToFormalManager personToFormalManager;
    @Autowired
    private GeneratorUtil generatorUtil;

    @Override
    public List<PersonToFormalCountDTO> getMonthCount(Integer year) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<PersonToFormalCountDO> countDOS = personToFormalManager.getMonthCount(year);
        List<PersonToFormalCountDTO> list = generatorUtil.convert(countDOS,PersonToFormalCountDTO.class);
        long times = timeConsumer.end();
        logger.info("获取[{}]年人员转正左侧月份统计列表耗时：{}",year,times);
        return list;
    }

    @Override
    public Result<PersonToFormalDTO> getMonthPersonToFormalList(PersonToFormalQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PersonToFormalQueryCnd cnd = generatorUtil.convert(cndDTO,PersonToFormalQueryCnd.class);
        Page<PersonToFormalDO> page = personToFormalManager.getMonthPersonToFormalList(cnd);
        Result<PersonToFormalDTO> result = ResultUtils.parseResult(page,PersonToFormalDTO.class);
        long times = timeConsumer.end();
        logger.info("获取[{}]月人员转正右侧列表耗时：{}",cndDTO.getMonth(),times);
        return result;
    }

    @Override
    public PersonTurViewDTO getPersonTur(Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PersonTurViewDO personTurViewDO = personToFormalManager.getPersonTur(id);
        PersonTurViewDTO personTurViewDTO = generatorUtil.convert(personTurViewDO,PersonTurViewDTO.class);
        long times = timeConsumer.end();
        logger.info("获取[{}]人员转正明细信息耗时：{}",id,times);
        return personTurViewDTO;
    }
}
