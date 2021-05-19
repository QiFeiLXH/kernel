package com.bsoft.common.service.impl;

import com.bsoft.common.condition.SystemDicSelectQueryCnd;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.dto.SystemDicDTO;
import com.bsoft.common.dto.SystemDicSelectQueryCndDTO;
import com.bsoft.common.entity.primary.SystemDicDO;
import com.bsoft.common.manager.SystemDicManager;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.service.SystemDicService;
import com.bsoft.common.utils.JSONUtils;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/25 13:02
 * @Description
 */
@Service
public class SystemDicServiceImpl implements SystemDicService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SystemDicServiceImpl.class);

    @Autowired
    private SystemDicManager systemDicManager;
    @Autowired
    private IGenerator iGenerator;


    @Override
    public List<SystemDicDTO> getSystemDic(Integer type) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<SystemDicDO> systemDic = systemDicManager.getSystemDic(type);
        long times = timeConsumer.end();
        LOGGER.info("获取系统字典type为{}耗时:{}",type,times);
        return iGenerator.convert(systemDic, SystemDicDTO.class);
    }

    @Override
    public List<SystemDicDTO> getSystemDicSelectList(SystemDicSelectQueryCndDTO queryCndDTO) {
        SystemDicSelectQueryCnd queryCnd = iGenerator.convert(queryCndDTO, SystemDicSelectQueryCnd.class);
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<SystemDicDO> list = systemDicManager.getSystemDicSelectList(queryCnd);
        long times = timeConsumer.end();
        LOGGER.info("获取系统字典，参数：{}，耗时：{}", JSONUtils.toString(queryCndDTO), times);
        return iGenerator.convert(list, SystemDicDTO.class);
    }
}
