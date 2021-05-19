package com.bsoft.person.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.person.dto.KnowledgeDTO;
import com.bsoft.person.dto.KnowledgeNumDTO;
import com.bsoft.person.dto.WorkCertificateDTO;
import com.bsoft.person.dto.WorkCertificateNumDTO;
import com.bsoft.person.entity.primary.KnowledgeDO;
import com.bsoft.person.entity.primary.KnowledgeNumViewDO;
import com.bsoft.person.entity.primary.WorkCertificateDO;
import com.bsoft.person.manager.KnowledgeManager;
import com.bsoft.person.service.KnowledgeService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

@Service
public class KnowledgeServiceImpl implements KnowledgeService {
    private final static Logger LOGGER = LoggerFactory.getLogger(KnowledgeServiceImpl.class);
    @Autowired
    private KnowledgeManager knowledgeManager;
    @Autowired
    private IGenerator generator;
    @Override
    public List<KnowledgeDTO> getKnowledges(String personId) {
        List<KnowledgeDO> result = knowledgeManager.getKnowledges(personId);
        return generator.convert(result,KnowledgeDTO.class);
    }

    @Override
    public Result<KnowledgeNumDTO> getKnowledgeNumList(String deptId, String inputContent, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<KnowledgeNumViewDO> pages = knowledgeManager.getKnowledgeNumList(deptId, inputContent, pageNo, pageSize);
        long times = timeConsumer.end();
        LOGGER.info("部门id:{},查询条件：{}，获取知识贡献数量列表耗时:{}", deptId, inputContent,times);
        return ResultUtils.parseResult(pages, KnowledgeNumDTO.class);
    }

    @Override
    public Result<KnowledgeDTO> getPersonalKnowledgeList(String personId, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<KnowledgeDO> pages = knowledgeManager.getPersonalKnowledgeList(personId, pageNo, pageSize);
        long times = timeConsumer.end();
        LOGGER.info("工号:{},获取个人知识贡献列表耗时:{}", personId, times);
        return ResultUtils.parseResult(pages, KnowledgeDTO.class);
    }
}
