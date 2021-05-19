package com.bsoft.logs.service;

import com.bsoft.common.result.Result;
import com.bsoft.logs.dto.*;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/10/27
 * @description
 */
public interface RequestLogReportService {
    List<RequestLogReportDTO> getMenuCount(String userId, RequestLogReportQueryCndDTO queryCndDTO);
    Result<RequestLogReportDTO> getMenuCountWithPage(String userId, RequestLogReportQueryCndDTO queryCndDTO);
    List<RequestLogReportDTO> getPathCount(String userId, RequestLogReportQueryCndDTO queryCndDTO);
    Result<RequestLogReportDTO> getPathCountWithPage(String userId, RequestLogReportQueryCndDTO queryCndDTO);

    Result<OperLogDTO> getRequestLogList(String userId, OperLogQueryCndDTO cndDTO);
}
