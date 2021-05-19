package com.bsoft.hr.service;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.PerformanceDTO;
import com.bsoft.hr.dto.PerformanceSaveResultDTO;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/17 15:22
 * @Description
 */
public interface PerformanceService {
    /** 年度绩效-绩效查询列表
     * @Param: year 年份
     * @Param: deptId 部门代码
     * @Param: inputContent 查询条件
     * @Param: pageNo 页码
     * @Param: pageSize 页量
     * @return com.bsoft.common.result.Result<PerformanceDTO>
     * @author Xuhui Lin
     */
    Result<PerformanceDTO> getPerformanceList(Integer year, String deptId, String inputContent, Integer pageNo, Integer pageSize);

    /** 年度绩效-保存绩效
     * @Param: personId 工号
     * @Param: savePerformanceDTOS 需要保存的绩效数据
     * @Param: errorPerformanceDTOS 转换失败数据
     * @return
     * @author Xuhui Lin
     */
    PerformanceSaveResultDTO savePerformance(String personId, List<PerformanceDTO> savePerformanceDTOS, List<PerformanceDTO> errorPerformanceDTOS);

    /** 年度绩效-批量删除绩效
     * @Param: performanceDTOList 绩效数据
     * @return
     * @author Xuhui Lin
     */
    void deletePerformances(List<PerformanceDTO> performanceDTOS);

    /** 年度绩效-导出错误数据
     * @Param: personId 工号
     * @return
     * @author Xuhui Lin
     */
    List<PerformanceDTO> getErrorPerformanceList(String personId);
}
