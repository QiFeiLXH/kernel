package com.bsoft.hr.manager;

import com.bsoft.hr.entity.primary.PerformanceDO;
import com.bsoft.hr.entity.primary.PerformanceSaveResultDO;
import com.bsoft.hr.entity.primary.PerformanceViewDO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/17 15:21
 * @Description
 */
public interface PerformanceManager {
    Page<PerformanceViewDO> getPerformanceList(Integer year, String deptId, String inputContent, Integer pageNo, Integer pageSize);

    PerformanceSaveResultDO savePerformance(String personId, List<PerformanceViewDO> performanceViewDOS, List<PerformanceViewDO> errorPerformanceViewDOS);

    void deletePerformances(List<PerformanceDO> performanceDOS);

    List<PerformanceViewDO> getErrorPerformanceList(String personId);
}
