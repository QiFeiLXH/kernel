package com.bsoft.person.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.person.condition.PersonTransferQueryCnd;
import com.bsoft.person.dto.PersonTransferDTO;
import com.bsoft.person.dto.PersonTransferQueryCndDTO;
import com.bsoft.person.entity.primary.PersonTransferDO;
import com.bsoft.person.manager.PersonTransferManager;
import com.bsoft.person.service.PersonTransferService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/12/30 11:04
 * @Description:
 */
@Service
public class PersonTransferServiceImpl implements PersonTransferService {

    private static final Logger logger = LoggerFactory.getLogger(PersonTransferServiceImpl.class);

    @Autowired
    private PersonTransferManager personTransferManager;
    @Autowired
    private GeneratorUtil generatorUtil;
    @Override
    public Result<PersonTransferDTO> findPersonTransfer(PersonTransferQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PersonTransferQueryCnd cnd = generatorUtil.convert(cndDTO,PersonTransferQueryCnd.class);
        Page<PersonTransferDO> page = personTransferManager.findPersonTransfer(cnd);
        Result<PersonTransferDTO> result = ResultUtils.parseResult(page, PersonTransferDTO.class);
        long times = timeConsumer.end();
        logger.info("人员调用功能获取人员信息耗时:{}",times);
        return result;
    }

    @Override
    public void savePersonTransfer(List<PersonTransferDTO> personTransferDTOS, String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<PersonTransferDO> personTransferDOS = generatorUtil.convert(personTransferDTOS,PersonTransferDO.class);
        personTransferManager.savePersonTransfer(personTransferDOS,personId);//保存调动、驻地等信息
        long times = timeConsumer.end();
        logger.info("人员调用功能保存调动信息耗时:{}",times);
    }
}
