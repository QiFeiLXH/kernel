package com.bsoft.system.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.system.dto.TimeTaskGroupTreeDTO;
import com.bsoft.system.entity.primary.TimeTaskGroupTreeDO;
import com.bsoft.system.manager.TimeTaskGroupManager;
import com.bsoft.system.service.TimeTaskGroupService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-07-01 11:23
 * @Version 1.0
 * @Description
 */
@Service
public class TimeTaskGroupServiceImpl implements TimeTaskGroupService {
    private static final Logger logger = LoggerFactory.getLogger(TimeTaskGroupServiceImpl.class);
    @Autowired
    private TimeTaskGroupManager timeTaskGroupManager;
    @Autowired
    private GeneratorUtil generatorUtil;
    @Override
    public TimeTaskGroupTreeDTO save(TimeTaskGroupTreeDTO timeTaskGroup) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        TimeTaskGroupTreeDO timeTaskGroupTreeDO = generatorUtil.convert(timeTaskGroup,TimeTaskGroupTreeDO.class);
        timeTaskGroupTreeDO = timeTaskGroupManager.save(timeTaskGroupTreeDO);
        long times = timeConsumer.end();
        logger.info("保存定时任务分组成功耗时:{},key为:{},名称为:{}",times,timeTaskGroupTreeDO.getKey(),timeTaskGroupTreeDO.getTitle());
        return null;
    }

    @Override
    public void delete(Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        timeTaskGroupManager.delete(id);
        long times = timeConsumer.end();
        logger.info("删除定时任务分组成功耗时:{},key为:{}",times,id);
    }

    @Override
    public List<TimeTaskGroupTreeDTO> getGroupTree() {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<TimeTaskGroupTreeDO> timeTaskGroupTreeDOS = timeTaskGroupManager.getGroupTree();
        long times = timeConsumer.end();
        logger.info("获取定时任务分组树成功耗时:{}",times);
        return generatorUtil.convert(timeTaskGroupTreeDOS,TimeTaskGroupTreeDTO.class);
    }
}
