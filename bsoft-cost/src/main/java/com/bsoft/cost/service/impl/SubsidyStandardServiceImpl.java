package com.bsoft.cost.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.json.FastJsonUtils;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.cost.condition.SubsidyStandardQueryCnd;
import com.bsoft.cost.dto.SubsidyStandardQueryCndDTO;
import com.bsoft.cost.dto.SubsidyStandardViewDTO;
import com.bsoft.cost.entity.primary.SubsidyStandardDO;
import com.bsoft.cost.entity.primary.SubsidyStandardViewDO;
import com.bsoft.cost.manager.SubsidyStandardManager;
import com.bsoft.cost.service.SubsidyStandardService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

/**
 * @Author: xucl
 * @DateTime: 2020/11/23 11:58
 * @Description:
 */
@Service
public class SubsidyStandardServiceImpl implements SubsidyStandardService {

    private static final Logger logger = LoggerFactory.getLogger(SubsidyStandardServiceImpl.class);

    @Autowired
    private SubsidyStandardManager subsidyStandardManager;
    @Autowired
    private GeneratorUtil generatorUtil;

    @Override
    public Result<SubsidyStandardViewDTO> findSubsidyStandard(SubsidyStandardQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        SubsidyStandardQueryCnd cnd = generatorUtil.convert(cndDTO,SubsidyStandardQueryCnd.class);
        Page<SubsidyStandardViewDO> page = subsidyStandardManager.findSubsidyStandardList(cnd);
        Result<SubsidyStandardViewDTO> result = ResultUtils.parseResult(page,SubsidyStandardViewDTO.class);
        long times = timeConsumer.end();
        logger.info("查询特殊津贴列表耗时:{}",times);
        return result;
    }

    @Override
    public void saveSubsidyStandard(SubsidyStandardViewDTO standardViewDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        SubsidyStandardDO standardDO = generatorUtil.convert(standardViewDTO,SubsidyStandardDO.class);
        subsidyStandardManager.saveSubsidyStandard(standardDO);
        long times = timeConsumer.end();
        logger.info("保存、更新津贴信息[{}]耗时:[{}]", FastJsonUtils.getBeanToJson(standardViewDTO), times);
    }
}
