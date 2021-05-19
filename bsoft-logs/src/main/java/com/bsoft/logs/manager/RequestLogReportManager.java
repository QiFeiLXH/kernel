package com.bsoft.logs.manager;

import com.bsoft.common.result.Result;
import com.bsoft.logs.condition.RequestLogReportQueryCnd;
import com.bsoft.logs.entity.primary.RequestLogMenuCountDO;
import com.bsoft.logs.entity.primary.RequestLogPathCountDO;
import com.bsoft.logs.entity.primary.RequestLogReportDO;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/10/27
 * @description
 */
public interface RequestLogReportManager {
    List<RequestLogReportDO> getMenuCount(RequestLogReportQueryCnd queryCnd);
    Result<RequestLogReportDO> getMenuCountWithPage(RequestLogReportQueryCnd queryCnd);
    List<RequestLogReportDO> getPathCount(RequestLogReportQueryCnd queryCnd);
    Result<RequestLogReportDO> getPathCountWithPage(RequestLogReportQueryCnd queryCnd);
}
