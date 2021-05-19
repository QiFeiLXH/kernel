package com.bsoft.common.service.impl;

import com.bsoft.common.condition.HumanDicSelectQueryCnd;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.dto.HumanDicSelectQueryCndDTO;
import com.bsoft.common.entity.primary.HumanDicDO;
import com.bsoft.common.manager.HumanDicManager;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.service.HumanDicService;
import com.bsoft.common.utils.JSONUtils;
import com.bsoft.person.dto.HumanDicDTO;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class HumanDicServiceImpl implements HumanDicService {
    private static final Logger LOGGER = LoggerFactory.getLogger(HumanDicServiceImpl.class);

    @Autowired
    private HumanDicManager humanDicManager;
    @Autowired
    private IGenerator iGenerator;
    @Override
    public List<HumanDicDTO> getHumanDic(Integer type) {
        List<HumanDicDO> result = humanDicManager.getTypePersonDic(type);
        return iGenerator.convert(result,HumanDicDTO.class);
    }

    @Override
    public List<HumanDicDTO> getHumanDicSelectList(HumanDicSelectQueryCndDTO queryCndDTO) {
        HumanDicSelectQueryCnd queryCnd = iGenerator.convert(queryCndDTO, HumanDicSelectQueryCnd.class);
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<HumanDicDO> list = humanDicManager.getHumanDicSelectList(queryCnd);
        long times = timeConsumer.end();
        LOGGER.info("获取认识字典，参数：{}，耗时：{}", JSONUtils.toString(queryCndDTO),times);
        return iGenerator.convert(list, HumanDicDTO.class);
    }
}
