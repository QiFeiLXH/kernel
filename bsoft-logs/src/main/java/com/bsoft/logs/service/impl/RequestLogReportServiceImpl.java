package com.bsoft.logs.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.logs.condition.OperLogQueryCnd;
import com.bsoft.logs.condition.RequestLogReportQueryCnd;
import com.bsoft.logs.dto.*;
import com.bsoft.logs.entity.primary.OperLogDO;
import com.bsoft.logs.entity.primary.RequestLogDO;
import com.bsoft.logs.entity.primary.RequestLogReportDO;
import com.bsoft.logs.manager.OperLogManager;
import com.bsoft.logs.manager.RequestLogReportManager;
import com.bsoft.logs.service.RequestLogReportService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/10/27
 * @description
 */
@Service
public class RequestLogReportServiceImpl implements RequestLogReportService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestLogReportServiceImpl.class);

    @Autowired
    private RequestLogReportManager requestLogReportManager;
    @Autowired
    private OperLogManager operLogManager;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public List<RequestLogReportDTO> getMenuCount(String userId, RequestLogReportQueryCndDTO queryCndDTO) {
        RequestLogReportQueryCnd queryCnd = iGenerator.convert(queryCndDTO, RequestLogReportQueryCnd.class);
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<RequestLogReportDO> resultDO = requestLogReportManager.getMenuCount(queryCnd);
        Long times = timeConsumer.end();
        LOGGER.info("工号[{}]获取请求菜单统计耗时[{}]", userId, times);
        return iGenerator.convert(resultDO, RequestLogReportDTO.class);
    }

    @Override
    public Result<RequestLogReportDTO> getMenuCountWithPage(String userId, RequestLogReportQueryCndDTO queryCndDTO) {
        RequestLogReportQueryCnd queryCnd = iGenerator.convert(queryCndDTO, RequestLogReportQueryCnd.class);
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<RequestLogReportDO> resultDO = requestLogReportManager.getMenuCountWithPage(queryCnd);
        Long times = timeConsumer.end();
        LOGGER.info("工号[{}]获取请求菜单统计耗时(分页)[{}]", userId, times);
        return iGenerator.convert(resultDO, RequestLogReportDTO.class);
    }

    @Override
    public List<RequestLogReportDTO> getPathCount(String userId, RequestLogReportQueryCndDTO queryCndDTO) {
        RequestLogReportQueryCnd queryCnd = iGenerator.convert(queryCndDTO, RequestLogReportQueryCnd.class);
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<RequestLogReportDO> resultDO = requestLogReportManager.getPathCount(queryCnd);
        Long times = timeConsumer.end();
        LOGGER.info("工号[{}]获取请求路径统计耗时[{}]", userId, times);
        return iGenerator.convert(resultDO, RequestLogReportDTO.class);
    }

    @Override
    public Result<RequestLogReportDTO> getPathCountWithPage(String userId, RequestLogReportQueryCndDTO queryCndDTO) {
        RequestLogReportQueryCnd queryCnd = iGenerator.convert(queryCndDTO, RequestLogReportQueryCnd.class);
        TimeConsumer timeConsumer = TimeConsumer.start();
        Result<RequestLogReportDO> resultDO = requestLogReportManager.getPathCountWithPage(queryCnd);
        Long times = timeConsumer.end();
        LOGGER.info("工号[{}]获取请求路径统计耗时(分页)[{}]", userId, times);
        return iGenerator.convert(resultDO, RequestLogReportDTO.class);
    }

    @Override
    public Result<OperLogDTO> getRequestLogList(String userId, OperLogQueryCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        OperLogQueryCnd cnd = iGenerator.convert(cndDTO, OperLogQueryCnd.class);
        Result<OperLogDO> doResult = operLogManager.getLogList(cnd);
        Long times = timeConsumer.end();
        LOGGER.info("工号[{}]获取员工操作记录耗时(分页)[{}]", userId, times);
        return iGenerator.convert(doResult, OperLogDTO.class);
    }
}
