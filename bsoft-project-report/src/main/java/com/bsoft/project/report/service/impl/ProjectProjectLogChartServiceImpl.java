package com.bsoft.project.report.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.project.report.condition.ProjectLogChartQueryCnd;
import com.bsoft.project.report.dto.ProjectLogChartDTO;
import com.bsoft.project.report.dto.ProjectLogChartMonthDTO;
import com.bsoft.project.report.dto.ProjectLogChartQueryCndDTO;
import com.bsoft.project.report.entity.primary.ProjectLogChartMonthViewDO;
import com.bsoft.project.report.entity.primary.ProjectLogChartViewDO;
import com.bsoft.project.report.manager.ProjectLogChartManager;
import com.bsoft.project.report.service.ProjectLogChartService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/8/7 8:56
 */

@Service
public class ProjectProjectLogChartServiceImpl implements ProjectLogChartService {
    private static final Logger logger = LoggerFactory.getLogger(ProjectProjectLogChartServiceImpl.class);

    @Autowired
    private IGenerator iGenerator;
    @Autowired
    private ProjectLogChartManager projectLogChartManager;

    @Override
    public Result<ProjectLogChartDTO> getLogChartList(ProjectLogChartQueryCndDTO cndDTO) {
        ProjectLogChartQueryCnd cnd = iGenerator.convert(cndDTO, ProjectLogChartQueryCnd.class);
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectLogChartViewDO> projectLogChartViewDOS = projectLogChartManager.getLogChartList(cnd);
        long times = timeConsumer.end();
        logger.info("获取结构化日志每日填写情况列表耗时:{}", times);
        List<ProjectLogChartDTO> projectLogChartDTOS = iGenerator.convert(projectLogChartViewDOS, ProjectLogChartDTO.class);
        return ResultUtils.parseResult(projectLogChartDTOS, projectLogChartDTOS.size());
    }

    @Override
    public Result<ProjectLogChartMonthDTO> getLogChartMonthList(ProjectLogChartQueryCndDTO cndDTO) {
        ProjectLogChartQueryCnd cnd = iGenerator.convert(cndDTO, ProjectLogChartQueryCnd.class);
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectLogChartMonthViewDO> logChartMonthList = projectLogChartManager.getLogChartMonthList(cnd);
        long times = timeConsumer.end();
        logger.info("获取结构化日志每月填写情况列表耗时:{}", times);
        List<ProjectLogChartMonthDTO> projectLogChartMonthDTOS = iGenerator.convert(logChartMonthList, ProjectLogChartMonthDTO.class);
        return ResultUtils.parseResult(projectLogChartMonthDTOS, projectLogChartMonthDTOS.size());
    }
}
