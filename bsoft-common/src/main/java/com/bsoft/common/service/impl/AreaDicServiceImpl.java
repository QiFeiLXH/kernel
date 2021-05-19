package com.bsoft.common.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.dto.AreaDicDTO;
import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.entity.primary.AreaDicDO;
import com.bsoft.common.entity.primary.PublicDicDO;
import com.bsoft.common.manager.AreaDicManager;
import com.bsoft.common.manager.PublicDicManager;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.service.AreaDicService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class AreaDicServiceImpl implements AreaDicService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AreaDicServiceImpl.class);

    @Autowired
    private AreaDicManager areaDicManager;

    @Autowired
    private IGenerator iGenerator;

    @Override
    public List<AreaDicDTO> getAreaDic(Integer level) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<AreaDicDO> areaDic = areaDicManager.getAreaDic(level);
        long times = timeConsumer.end();
        LOGGER.info("获取区域level为{}耗时:{}",level,times);
        return iGenerator.convert(areaDic,AreaDicDTO.class);
    }
}
