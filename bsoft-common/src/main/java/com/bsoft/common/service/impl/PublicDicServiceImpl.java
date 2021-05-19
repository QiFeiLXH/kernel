package com.bsoft.common.service.impl;

import com.bsoft.common.condition.PublicDicSelectQueryCnd;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.dto.PublicDicSelectQueryCndDTO;
import com.bsoft.common.entity.primary.PublicDicDO;
import com.bsoft.common.manager.PublicDicManager;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.service.PublicDicService;
import com.bsoft.common.utils.JSONUtils;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PublicDicServiceImpl implements PublicDicService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PublicDicServiceImpl.class);

    @Autowired
    private PublicDicManager publicDicManager;

    @Autowired
    private IGenerator iGenerator;


    @Override
    public List<PublicDicDTO> getPublicDic(Integer type) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<PublicDicDO> publicDic = publicDicManager.getPublicDic(type);
        long times = timeConsumer.end();
        LOGGER.info("获取公用字典type为{}耗时:{}",type,times);
        return iGenerator.convert(publicDic,PublicDicDTO.class);
    }

    @Override
    public List<PublicDicDTO> getPublicDicWithFlag(Integer type, Integer flag) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<PublicDicDO> publicDic = publicDicManager.getPublicDicWithFlag(type, flag);
        long times = timeConsumer.end();
        LOGGER.info("获取公用字典type为{},flag:{}耗时:{}",type,flag,times);
        return iGenerator.convert(publicDic,PublicDicDTO.class);
    }

    @Override
    public List<PublicDicDTO> getPublicDicSelectList(PublicDicSelectQueryCndDTO queryCndDTO) {
        PublicDicSelectQueryCnd queryCnd = iGenerator.convert(queryCndDTO, PublicDicSelectQueryCnd.class);
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<PublicDicDO> list = publicDicManager.getPublicDicSelectList(queryCnd);
        long times = timeConsumer.end();
        LOGGER.info("获取公用字典，参数：{}，耗时：{}", JSONUtils.toString(queryCndDTO),times);
        return iGenerator.convert(list, PublicDicDTO.class);
    }
}
