package com.bsoft.clue.service.impl;

import com.bsoft.clue.dto.ClueViewDTO;
import com.bsoft.clue.dto.TrackLogCluesDTO;
import com.bsoft.clue.entity.primary.ClueViewDO;
import com.bsoft.clue.entity.primary.TrackLogCluesDO;
import com.bsoft.clue.manager.ClueManager;
import com.bsoft.clue.service.ClueService;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.dto.SystemDicDTO;
import com.bsoft.common.entity.primary.SystemDicDO;
import com.bsoft.common.manager.SystemDicManager;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

@Service
public class ClueServiceImpl implements ClueService {
    private static final Logger logger = LoggerFactory.getLogger(ClueServiceImpl.class);
    @Autowired
    private ClueManager clueManager;
    @Autowired
    private SystemDicManager systemDicManager;
    @Autowired
    private IGenerator generator;
    @Override
    public Result<TrackLogCluesDTO> searchTrackLogClues(String personId, String content, Integer page, Integer size) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<TrackLogCluesDO> trackLogCluesDOS = clueManager.searchTrackLogClues(personId,content,page,size);
        long times = timeConsumer.end();
        logger.info("查找工号:{}的销售线索耗时:{}",personId,times);
        return ResultUtils.parseResult(trackLogCluesDOS, TrackLogCluesDTO.class);
    }

    @Override
    public List<SystemDicDTO> getStageDic() {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<SystemDicDO> results = systemDicManager.getSystemDic(924);
        long times = timeConsumer.end();
        logger.info("获取目前阶段字典耗时:{}",times);
        return generator.convert(results,SystemDicDTO.class);
    }

    @Override
    public List<SystemDicDTO> getClueNatureDic() {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<SystemDicDO> results = systemDicManager.getSystemDic(946);
        long times = timeConsumer.end();
        logger.info("获取线索性质字典耗时:{}",times);
        return generator.convert(results,SystemDicDTO.class);
    }

    @Override
    public ClueViewDTO getClue(Integer id) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        ClueViewDO clue = clueManager.getClueView(id);
        long times = timeConsumer.end();
        logger.info("获取线索ID为{}的线索耗时:{}",id,times);
        return generator.convert(clue, ClueViewDTO.class);
    }
}
