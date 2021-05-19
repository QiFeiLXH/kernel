package com.bsoft.project.report.service;

import com.bsoft.common.result.Result;
import com.bsoft.project.report.dto.ProjectAllByMonthDTO;
import com.bsoft.project.report.dto.ProjectAllSubTotalDTO;
import com.bsoft.project.report.dto.ProjectDepTypeByMonthDTO;
import com.bsoft.project.report.dto.ProjectDepTypeByYearDTO;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2019-12-19 16:12
 * @Version 1.0
 * @Description
 */
public interface ProjectLevelService {
    /**
     * @Description: 获取报表-项目级-全部-小计
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @param pageNo 页数，
     * @param pageSize 每页数量，
     * @return Result<ProjectAllSubTotalDTO> 项目级-全部-小计-列表（按年份统计）
     * @author zhanglf
     * @Time 2019年12月12日 下午5:40:24
     */
    Result<ProjectAllSubTotalDTO> findAllSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     * @Description: 获取报表-项目级-全部-小计
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @return List<ProjectAllSubTotalDTO> 项目级-全部-小计-列表（按年份统计）
     * @author zhanglf
     * @Time 2019年12月12日 下午5:40:24
     */
    List<ProjectAllSubTotalDTO> findAllSubTotal(Integer startYear, Integer endYear);

    /**
     * @Description: 获取报表-项目级-全部-年度
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @param pageNo 页数，
     * @param pageSize 每页数量，
     * @return List<ProjectAllSubTotalDTO> 项目级-全部-小计-列表（按年份统计）
     * @author zhanglf
     * @Time 2019年12月12日 下午5:40:24
     */
    Result<ProjectAllSubTotalDTO> findAllGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     * @Description: 获取报表-项目级-全部-年度
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @return Result<ProjectAllSubTotalDTO> 项目级-全部-小计-列表（按年份统计）
     * @author zhanglf
     * @Time 2019年12月12日 下午5:40:24
     */
    List<ProjectAllSubTotalDTO> findAllGroupByYear(Integer startYear, Integer endYear);

    /**
     * @Description: 获取报表-项目级-全部-月度
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @param pageNo 页数，
     * @param pageSize 每页数量，
     * @return Result<ProjectAllByMonthDTO> 项目级-全部-月度-列表
     * @author zhanglf
     * @Time 2019年12月12日 下午5:40:24
     */
    Result<ProjectAllByMonthDTO> findAllGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     * @Description: 获取报表-项目级-全部-月度
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @return List<ProjectAllByMonthDTO> 项目级-全部-月度-列表
     * @author zhanglf
     * @Time 2019年12月12日 下午5:40:24
     */
    List<ProjectAllByMonthDTO> findAllGroupByMonth(Integer startYear, Integer endYear);

    /**
     * @Description: 获取报表-项目级-按部门类型-小计
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @param pageNo 页数，
     * @param pageSize 每页数量，
     * @return Result<ProjectDepTypeByYearDTO> 项目级-按产生部门类型-小计-列表（按年份统计）
     * @author zhanglf
     */
    Result<ProjectDepTypeByYearDTO> findDepTypeSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     * @Description: 获取报表-项目级-按部门类型-小计
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @return List<ProjectDepTypeByYearDTO> 项目级-按产生部门类型-小计-列表（按年份统计）
     * @author zhanglf
     */
    List<ProjectDepTypeByYearDTO> findDepTypeSubTotal(Integer startYear, Integer endYear);

    /**
     * @Description: 获取报表-项目级-按部门类型-年度
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @param pageNo 页数，
     * @param pageSize 每页数量，
     * @return Result<ProjectDepTypeByYearDTO> 项目级-按产生部门类型-年度-列表（按年份统计）
     * @author zhanglf
     */
    Result<ProjectDepTypeByYearDTO> findDepTypeGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     * @Description: 获取报表-项目级-按部门类型-年度
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @return List<ProjectDepTypeByYearDTO> 项目级-按产生部门类型-年度-列表（按年份统计）
     * @author zhanglf
     */
    List<ProjectDepTypeByYearDTO> findDepTypeGroupByYear(Integer startYear, Integer endYear);

    /**
     * @Description: 获取报表-项目级-按部门类型-月度
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @param pageNo 页数，
     * @param pageSize 每页数量，
     * @return Result<ProjectDepTypeByMonthDTO> 项目级-按产生部门类型-月度-列表
     * @author zhanglf
     */
    Result<ProjectDepTypeByMonthDTO> findDepTypeGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     * @Description: 获取报表-项目级-按部门类型-月度
     * @param startYear 开始年份，
     * @param endYear 结束年份，
     * @return List<ProjectDepTypeByMonthDTO> 项目级-按产生部门类型-月度-列表
     * @author zhanglf
     */
    List<ProjectDepTypeByMonthDTO> findDepTypeGroupByMonth(Integer startYear, Integer endYear);
}
