package com.bsoft.clue.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.clue.condition.SalesCluesTaskQueryCnd;
import com.bsoft.clue.dto.SalesCluesTaskDTO;
import com.bsoft.clue.dto.SalesCluesTaskQueryCndDTO;
import com.bsoft.clue.dto.SalesCluesViewDTO;
import com.bsoft.clue.entity.primary.SalesCluesTaskDO;
import com.bsoft.clue.entity.primary.SalesCluesViewDO;
import com.bsoft.clue.manager.SalesCluesManager;
import com.bsoft.clue.service.SalesCluesService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@Service
public class SalesCluesServiceImpl implements SalesCluesService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SalesCluesServiceImpl.class);

    @Autowired
    private SalesCluesManager salesCluesManager;

    @Override
    public void submit(String personId,Integer clueId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        salesCluesManager.submit(clueId);
        long times = timeConsumer.end();
        LOGGER.info("工号：{}提交销售线索立项流程，耗时：{}",new Object[]{personId,times});

    }

    @Override
    public void successApply(String personId,String taskId,String opinion,Integer system,Integer clueId,String processInstanceId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        salesCluesManager.successApply(personId,taskId,opinion,system,clueId,processInstanceId);
        long times = timeConsumer.end();
        LOGGER.info("工号：{}同意审核，耗时：{}",new Object[]{personId,times});
    }

    @Override
    public void failApply(String personId,String taskId,String opinion,Integer system) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        salesCluesManager.failApply(personId,taskId,opinion,system);
        long times = timeConsumer.end();
        LOGGER.info("工号：{}不同意审核，耗时：{}",new Object[]{personId,times});
    }

    @Override
    public void apply(String personId,String taskId,Map<String, Object> map) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        salesCluesManager.apply(taskId, map);
        long times = timeConsumer.end();
        LOGGER.info("工号：{}操作流程，耗时：{}",new Object[]{personId,times});
    }

    @Override
    public SalesCluesViewDTO getClue(String personId,Integer clueId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        SalesCluesViewDO salesCluesViewDO  = salesCluesManager.getByClueId(clueId);
        long times = timeConsumer.end();
        LOGGER.info("工号：{} 获取线索编号为：{}的销售线索，耗时：{}",new Object[]{personId,clueId,times});
        return GeneratorUtil.instance().convert(salesCluesViewDO,SalesCluesViewDTO.class);
    }

    @Override
    public Result<SalesCluesTaskDTO> getTaskList(String personId,SalesCluesTaskQueryCndDTO data) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        SalesCluesTaskQueryCnd queryCnd = GeneratorUtil.instance().convert(data, SalesCluesTaskQueryCnd.class);
        Result<SalesCluesTaskDO> result = salesCluesManager.getTaskList(queryCnd);
        long times = timeConsumer.end();
        LOGGER.info("工号：{}，获取流程待办信息，耗时：{}",new Object[]{personId,times});
        return GeneratorUtil.instance().convert(result, SalesCluesTaskDTO.class);
    }
}
