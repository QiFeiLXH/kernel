package com.bsoft.person.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.dto.ImportResultDTO;
import com.bsoft.common.entity.primary.ImportResultDO;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.person.condition.PersonalTrainQueryCnd;
import com.bsoft.person.condition.TrainKnowledgeQueryCnd;
import com.bsoft.person.dto.*;
import com.bsoft.person.entity.primary.PersonalTrainViewDO;
import com.bsoft.person.entity.primary.TrainDO;
import com.bsoft.person.entity.primary.TrainLearnViewDO;
import com.bsoft.person.entity.primary.TrainShareViewDO;
import com.bsoft.person.manager.TrainManager;
import com.bsoft.person.service.TrainService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

@Service
public class TrainServiceImpl implements TrainService {
    private static final Logger logger = LoggerFactory.getLogger(TrainServiceImpl.class);
    @Autowired
    private TrainManager trainManager;
    @Autowired
    private IGenerator generator;
    @Override
    public List<TrainDTO> getTrainWithPersonId(String personId) {
        List<TrainDO> result = trainManager.getTrainWithPersonId(personId);
        return generator.convert(result,TrainDTO.class);
    }

    @Override
    public Result<TrainLearnDTO> getKnowledgeLearnList(TrainQueryCndDTO trainQueryCndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        TrainKnowledgeQueryCnd cnd = generator.convert(trainQueryCndDTO, TrainKnowledgeQueryCnd.class);
        Page<TrainLearnViewDO> pages = trainManager.getKnowledgeLearnList(cnd);
        long times = timeConsumer.end();
        logger.info("部门id:{},查询条件：{}，获取知识学习列表耗时:{}", trainQueryCndDTO.getDeptId(), trainQueryCndDTO.getInputContent(),times);
        return ResultUtils.parseResult(pages, TrainLearnDTO.class);
    }

    @Override
    public ImportResultDTO saveKnowledgeLearn(String personId, List<TrainLearnDTO> trainLearnDTOS, List<TrainLearnDTO> errorLearnDTOS) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<TrainLearnViewDO> saveData = generator.convert(trainLearnDTOS, TrainLearnViewDO.class);
        List<TrainLearnViewDO> errorData = generator.convert(errorLearnDTOS, TrainLearnViewDO.class);
        ImportResultDO result = trainManager.saveKnowledgeLearn(personId, saveData, errorData);
        long times = timeConsumer.end();
        logger.info("保存知识学习列表耗时:{}",times);
        return generator.convert(result, ImportResultDTO.class);
    }

    @Override
    public Result<TrainShareDTO> getKnowledgeShareList(TrainQueryCndDTO trainQueryCndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        TrainKnowledgeQueryCnd cnd = generator.convert(trainQueryCndDTO, TrainKnowledgeQueryCnd.class);
        Page<TrainShareViewDO> pages = trainManager.getKnowledgeShareList(cnd);
        long times = timeConsumer.end();
        logger.info("部门id:{},查询条件：{}，获取知识分享列表耗时:{}", trainQueryCndDTO.getDeptId(), trainQueryCndDTO.getInputContent(),times);
        return ResultUtils.parseResult(pages, TrainShareDTO.class);
    }

    @Override
    public ImportResultDTO saveKnowledgeShare(String personId, List<TrainShareDTO> trainShareDTOS, List<TrainShareDTO> errorShareDTOS) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<TrainShareViewDO> saveData = generator.convert(trainShareDTOS, TrainShareViewDO.class);
        List<TrainShareViewDO> errorData = generator.convert(errorShareDTOS, TrainShareViewDO.class);
        ImportResultDO result = trainManager.saveKnowledgeShare(personId, saveData, errorData);
        long times = timeConsumer.end();
        logger.info("保存知识分享数据耗时:{}",times);
        return generator.convert(result, ImportResultDTO.class);
    }

    @Override
    public List<TrainLearnDTO> getImportLearnErrorList(String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<TrainLearnViewDO> list = trainManager.getImportLearnErrorRecords(personId);
        long times = timeConsumer.end();
        logger.info("工号:{}，获取导入知识学习错误列表耗时:{}", personId,times);
        return generator.convert(list, TrainLearnDTO.class);
    }

    @Override
    public List<TrainShareDTO> getImportShareErrorList(String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<TrainShareViewDO> list = trainManager.getImportShareErrorRecords(personId);
        long times = timeConsumer.end();
        logger.info("工号:{}，获取导入知识分享错误列表耗时:{}", personId,times);
        return generator.convert(list, TrainShareDTO.class);
    }

    @Override
    public void deleteBatchLearnList(List<Integer> deletes) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        trainManager.deleteBatchLearnList(deletes);
        long times = timeConsumer.end();
        logger.info("删除知识学习耗时:{}", times);
    }

    @Override
    public void deleteBatchShareList(List<Integer> deletes) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        trainManager.deleteBatchShareList(deletes);
        long times = timeConsumer.end();
        logger.info("删除知识分享耗时:{}", times);
    }

    @Override
    public Result<PersonalTrainDTO> getPersonalTrainList(PersonalTrainQueryCndDTO cndDTO) {
        PersonalTrainQueryCnd cnd = generator.convert(cndDTO, PersonalTrainQueryCnd.class);
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<PersonalTrainViewDO> pages = trainManager.getPersonalTrainList(cnd);
        long times = timeConsumer.end();
        logger.info("查询条件：{}，年份：{}，排序方式：{}，工号：{}，全部权限：{}，获取个人培训列表耗时:{}", cndDTO.getInputContent(),cndDTO.getYear(),cndDTO.getSortFlag(),cndDTO.getPersonId() ,cndDTO.getAllPermission(),times);
        return ResultUtils.parseResult(pages, PersonalTrainDTO.class);
    }
}
