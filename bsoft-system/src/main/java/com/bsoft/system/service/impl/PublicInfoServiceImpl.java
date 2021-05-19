package com.bsoft.system.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.hr.dto.NewEntryPersonInfoDTO;
import com.bsoft.system.condition.PublicInfoQueryCnd;
import com.bsoft.system.dto.PublicInfoDTO;
import com.bsoft.system.dto.PublicInfoQueryCndDTO;
import com.bsoft.system.entity.primary.PublicInfoDO;
import com.bsoft.system.manager.PublicInfoManager;
import com.bsoft.system.service.PublicInfoService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

@Service
public class PublicInfoServiceImpl implements PublicInfoService {
    private static final Logger logger = LoggerFactory.getLogger(PublicInfoServiceImpl.class);
    @Autowired
    private PublicInfoManager publicInfoManager;
    @Autowired
    private GeneratorUtil generatorUtil;
    @Override
    public List<PublicInfoDTO> getNews(Long count) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<PublicInfoDO> publicInfoList =  publicInfoManager.getNews(count);
        long times = timeConsumer.end();
        logger.info("获取最新{}条的新闻耗时:{}",count,times);
        return generatorUtil.convert(publicInfoList,PublicInfoDTO.class);
    }

    @Override
    public List<PublicInfoDTO> getNotice(Long count) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<PublicInfoDO> publicInfoList =  publicInfoManager.getNotice(count);
        long times = timeConsumer.end();
        logger.info("获取最新{}条的通知耗时:{}",count,times);
        return generatorUtil.convert(publicInfoList,PublicInfoDTO.class);
    }

    @Override
    public List<PublicInfoDTO> getSystemNotice(Long count) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<PublicInfoDO> publicInfoList =  publicInfoManager.getSystemNotice(count);
        long times = timeConsumer.end();
        logger.info("获取最新{}条的系统公告耗时:{}",count,times);
        return generatorUtil.convert(publicInfoList,PublicInfoDTO.class);
    }

    @Override
    public Result<PublicInfoDTO> getNewsByCnd(PublicInfoQueryCndDTO queryCndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        PublicInfoQueryCnd cnd = generatorUtil.convert(queryCndDTO,PublicInfoQueryCnd.class);
        Page<PublicInfoDO> publicInfoDOS = publicInfoManager.getNewsByType(cnd);
        Result<PublicInfoDTO> result = ResultUtils.parseResult(publicInfoDOS, PublicInfoDTO.class);
        long times = timeConsumer.end();
        logger.info("按分类获取新闻耗时:{}",times);
        return result;
    }
}
