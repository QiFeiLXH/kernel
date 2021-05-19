package com.bsoft.project.report.manager;

import com.bsoft.project.report.condition.ProjectLogChartQueryCnd;
import com.bsoft.project.report.entity.primary.ProjectLogChartMonthViewDO;
import com.bsoft.project.report.entity.primary.ProjectLogChartViewDO;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/8/7 9:01
 */
public interface ProjectLogChartManager {
    List<ProjectLogChartViewDO> getLogChartList(ProjectLogChartQueryCnd cnd);
    List<ProjectLogChartMonthViewDO> getLogChartMonthList(ProjectLogChartQueryCnd cnd);
}
