package com.bsoft.project.report.service;

import com.bsoft.common.result.Result;
import com.bsoft.project.report.dto.ProjectLogChartDTO;
import com.bsoft.project.report.dto.ProjectLogChartMonthDTO;
import com.bsoft.project.report.dto.ProjectLogChartQueryCndDTO;

/**
 * @author: zy
 * @date: 2020/8/7 8:55
 */
public interface ProjectLogChartService {
    /**
     * 获取结构化日志每日填写情况图标数据
     * @param cndDTO
     * @return
     */
    Result<ProjectLogChartDTO> getLogChartList(ProjectLogChartQueryCndDTO cndDTO);

    /**
     * 获取结构化日志每月平均填写情况图标数据
     * @param cndDTO
     * @return
     */
    Result<ProjectLogChartMonthDTO> getLogChartMonthList(ProjectLogChartQueryCndDTO cndDTO);
}
