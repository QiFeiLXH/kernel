package com.bsoft.logs.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.logs.condition.UsageLogCountQueryCnd;
import com.bsoft.logs.dto.UsageLogCountDTO;
import com.bsoft.logs.dto.UsageLogCountQueryCndDTO;
import com.bsoft.logs.dto.UsageLogCountWithDateDTO;
import com.bsoft.logs.dto.UsageLogReportDTO;
import com.bsoft.logs.entity.primary.UsageLogCountDO;
import com.bsoft.logs.entity.primary.UsageLogCountWithDateDO;
import com.bsoft.logs.manager.UsageLogReportManager;
import com.bsoft.logs.service.UsageLogReportService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Service
public class UsageLogReportServiceImpl implements UsageLogReportService {
    private static final Logger logger = LoggerFactory.getLogger(UsageLogReportServiceImpl.class);
    @Autowired
    UsageLogReportManager usageLogReportManager;

    @Override
    public List<UsageLogReportDTO> countUsageLog(Date startDate, Date endDate) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<UsageLogReportDTO> usageLogReportDTOS = usageLogReportManager.countUsageLog(startDate, endDate);
        long times = timeConsumer.end();
        logger.info("获取使用日志报表信息耗时:{}",times);
        return usageLogReportDTOS;
    }

    @Override
    public List<UsageLogCountDTO> countUsageLogs(UsageLogCountQueryCndDTO countQueryCndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        UsageLogCountQueryCnd countQueryCnd = GeneratorUtil.instance().convert(countQueryCndDTO,UsageLogCountQueryCnd.class);
        List<UsageLogCountDO> list= usageLogReportManager.countUsageLogs(countQueryCnd);
        long times = timeConsumer.end();
        logger.info("获取使用日志报表信息耗时:{}",times);
        return GeneratorUtil.instance().convert(list,UsageLogCountDTO.class);
    }

    @Override
    public List<UsageLogCountWithDateDTO> countUsageLogGroup(Date startDate, Date endDate) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<UsageLogCountWithDateDO> list= usageLogReportManager.countUsageLogGroup(startDate,endDate);
        long times = timeConsumer.end();
        logger.info("获取使用日志报表信息耗时:{}",times);
        return GeneratorUtil.instance().convert(list,UsageLogCountWithDateDTO.class);
    }
}
