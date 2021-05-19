package com.bsoft.project.report.service;

import com.bsoft.common.result.Result;
import com.bsoft.project.report.dto.*;

import java.util.List;
import java.util.Map;

/**
 * @Author zhanglf
 * @Date 2020-01-03 13:25
 * @Version 1.0
 * @Description
 */
public interface ProjectLevelWorkloadService {
    /**
     * @Description: 获取报表人力成本-工作量-项目级-全部-小计
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @param pageNo 页数，
     * @param pageSize 每页数量，
     * @return Result<Map<String,String>> 人力成本-工作量-项目级-全部-小计-列表
     * @author zhanglf
     * @Time 2020年01月03日 下午1:28:24
     */
    Result<ProjectLevelworkloadAllDTO> findAllSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     * 导出时  获取报表人力成本-工作量-项目级-全部-小计列表
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @return
     */
    List<ProjectLevelworkloadAllDTO> findAllSubTotalList(Integer startYear, Integer endYear);

    /**
     * @Description: 获取报表人力成本-工作量-项目级-全部-年度
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @param pageNo 页数，
     * @param pageSize 每页数量，
     * @return Result<Map<String,String>> 人力成本-工作量-项目级-全部-年度-列表
     * @author zhanglf
     * @Time 2020年01月03日 下午1:28:24
     */
    Result<ProjectLevelworkloadAllByYearDTO> findAllGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     * @Description:导出时 获取报表人力成本-工作量-项目级-全部-年度列表
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     */
    List<ProjectLevelworkloadAllByYearDTO> findAllGroupByYearList(Integer startYear, Integer endYear);

    /**
     * @Description: 获取报表人力成本-工作量-项目级-全部-月度
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @param pageNo 页数，
     * @param pageSize 每页数量，
     * @return Result<Map<String,String>> 人力成本-工作量-项目级-全部-月度-列表
     * @author zhanglf
     * @Time 2020年01月03日 下午1:28:24
     */
    Result<ProjectLevelworkloadAllByMonthDTO> findAllGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);


    /**
     *
     * @Description:导出时 获取报表人力成本-工作量-项目级-全部-月度列表
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @return
     */
    List<ProjectLevelworkloadAllByMonthDTO> findAllGroupByMonthList(Integer startYear, Integer endYear);

    /**
     * @Description: 获取报表人力成本-工作量-项目级-按产生部门类型-小计
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @param pageNo 页数，
     * @param pageSize 每页数量，
     * @return Result<Map<String,String>> 人力成本-工作量-项目级-按产生部门类型-小计-列表
     * @author zhanglf
     * @Time 2020年01月03日 下午1:28:24
     */
    Result<ProjectLevelworkloadAllByDepDTO> findDepTypeSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     * @Description: 获取报表人力成本-工作量-项目级-按产生部门类型-小计 列表
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     */
    List<ProjectLevelworkloadAllByDepDTO> findDepTypeSubTotalList(Integer startYear, Integer endYear);

    /**
     * @Description: 获取报表人力成本-工作量-项目级-按产生部门类型-年度
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @param pageNo 页数，
     * @param pageSize 每页数量，
     * @return Result<Map<String,String>> 人力成本-工作量-项目级-按产生部门类型-年度-列表
     * @author zhanglf
     * @Time 2020年01月03日 下午1:28:24
     */
    Result<ProjectLevelworkloadAllByDepByYearDTO> findDepTypeGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     * @Description: 获取报表人力成本-工作量-项目级-按产生部门类型-年度  列表
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     */
    List<ProjectLevelworkloadAllByDepByYearDTO> findDepTypeGroupByYearList(Integer startYear, Integer endYear);

    /**
     * @Description: 获取报表人力成本-工作量-项目级-按产生部门类型-月度
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @param pageNo 页数，
     * @param pageSize 每页数量，
     * @return Result<Map<String,String>> 人力成本-工作量-项目级-按产生部门类型-月度-列表
     * @author zhanglf
     * @Time 2020年01月03日 下午1:28:24
     */
    Result<ProjectLevelworkloadAllByDepByMonthDTO> findDepTypeGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     * @Description: 获取报表人力成本-工作量-项目级-按产生部门类型-月度 列表
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     */
    List<ProjectLevelworkloadAllByDepByMonthDTO> findDepTypeGroupByMonthList(Integer startYear, Integer endYear);
}
