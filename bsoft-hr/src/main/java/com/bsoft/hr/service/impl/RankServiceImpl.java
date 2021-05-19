package com.bsoft.hr.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.key.KeyGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.hr.dto.PerformanceDTO;
import com.bsoft.hr.dto.RankBaseDTO;
import com.bsoft.hr.dto.RankDTO;
import com.bsoft.hr.entity.primary.RankDO;
import com.bsoft.hr.entity.primary.RankViewDO;
import com.bsoft.hr.manager.RankManager;
import com.bsoft.hr.service.RankService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.Date;

@Service
public class RankServiceImpl implements RankService {
    private final static Logger LOGGER = LoggerFactory.getLogger(RankServiceImpl.class);

    @Autowired
    private IGenerator generator;
    @Autowired
    private RankManager rankManager;
    @Autowired
    private KeyGenerator keyGenerator;
    @Override
    public Integer saveRankBase(RankBaseDTO rankBase) {
        RankDO rankDO = generator.convert(rankBase,RankDO.class);
        rankDO.setId(keyGenerator.increaseRank());
        return rankManager.saveRankAndOther(rankDO);
    }

    @Override
    public Result<RankDTO> getRankList(Integer year, String deptId, String inputContent, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<RankViewDO> pages = rankManager.getRankList(year, deptId, inputContent, pageNo, pageSize);
        long times = timeConsumer.end();
        LOGGER.info("年度:{},部门id:{},查询条件：{}，获取职级列表耗时:{}",year,deptId,inputContent,times);
        return ResultUtils.parseResult(pages, RankDTO.class);
    }

    @Override
    public Date getNewestRankDate(String personId) {
        return rankManager.getNewestRankDate(personId);
    }
}
