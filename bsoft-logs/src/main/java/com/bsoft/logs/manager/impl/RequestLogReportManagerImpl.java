package com.bsoft.logs.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.logs.condition.RequestLogReportQueryCnd;
import com.bsoft.logs.dao.primary.RequestLogMenuCountDao;
import com.bsoft.logs.dao.primary.RequestLogPathCountDao;
import com.bsoft.logs.entity.primary.RequestLogReportDO;
import com.bsoft.logs.manager.RequestLogReportManager;
import com.bsoft.logs.repository.primary.RequestLogReportRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zy
 * @date: 2020/10/27
 * @description
 */
@Component
public class RequestLogReportManagerImpl implements RequestLogReportManager {

    @Autowired
    private RequestLogReportRepository requestLogReportRepository;

    @Override
    public List<RequestLogReportDO> getMenuCount(RequestLogReportQueryCnd queryCnd) {
        List<RequestLogReportDO> result = requestLogReportRepository.getMenuCount(queryCnd.getMenuId(), queryCnd.getStartDate(), queryCnd.getEndDate());
        List<RequestLogReportDO> sortedResult = result.stream().sorted(Comparator.comparing(RequestLogReportDO::getCountDate)).collect(Collectors.toList());
        return sortedResult;
    }

    @Override
    public Result<RequestLogReportDO> getMenuCountWithPage(RequestLogReportQueryCnd queryCnd) {
        PageHelper.startPage(queryCnd.getPageNo(), queryCnd.getPageSize());
        List<RequestLogReportDO> list = requestLogReportRepository.getMenuCountTotal(queryCnd.getStartDate(), queryCnd.getEndDate());
        PageInfo<RequestLogReportDO> pageInfo = new PageInfo<>(list);
        return ResultUtils.parseResult(pageInfo);
    }

    @Override
    public List<RequestLogReportDO> getPathCount(RequestLogReportQueryCnd queryCnd) {
        List<RequestLogReportDO> result = requestLogReportRepository.getPathCount(queryCnd);
        List<RequestLogReportDO> sortedResult = result.stream().sorted(Comparator.comparing(RequestLogReportDO::getCountDate)).collect(Collectors.toList());
        return sortedResult;
    }

    @Override
    public Result<RequestLogReportDO> getPathCountWithPage(RequestLogReportQueryCnd queryCnd) {
        PageHelper.startPage(queryCnd.getPageNo(), queryCnd.getPageSize());
        List<RequestLogReportDO> list = requestLogReportRepository.getPathCountTotal(queryCnd);
        PageInfo<RequestLogReportDO> pageInfo = new PageInfo<>(list);
        return ResultUtils.parseResult(pageInfo);
    }
}
