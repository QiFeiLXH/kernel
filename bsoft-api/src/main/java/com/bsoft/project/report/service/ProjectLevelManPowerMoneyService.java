package com.bsoft.project.report.service;

import com.bsoft.common.result.Result;
import com.bsoft.project.report.dto.*;

import java.util.List;

public interface ProjectLevelManPowerMoneyService {

    /**
     * * 分页查询
     * C01 获取报表人力成本-金额-项目级-全部-小计
     * @param startYear 开始年份
     * @param endYear   结束年份
     * @param pageNo    页数
     * @param pageSize  每页条数
     * @return
     */
    Result<ProjectLevelManPowerMoneyAllDTO> findAllSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);

    /**
     * 列表查询
     * @param startYear
     * @param endYear
     * @return
     */
    List<ProjectLevelManPowerMoneyAllDTO> findAllSubTotalList(Integer startYear, Integer endYear);

    /**
     * * 分页查询
     * C02 获取报表人力成本-金额-项目级-全部-年度
     * @param startYear
     * @param endYear
     * @param pageNo
     * @param pageSize
     * @return
     */
    Result<ProjectLevelManPowerMoneyAllByYearDTO> findAllGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);
    /**
     * 列表查询
     * @param startYear
     * @param endYear
     * @return
     */
    List<ProjectLevelManPowerMoneyAllByYearDTO> findAllGroupByYearList(Integer startYear, Integer endYear);

    /**
     * * 分页查询
     * C03 获取报表人力成本-金额-项目级-全部-月度
     * @param startYear
     * @param endYear
     * @param pageNo
     * @param pageSize
     * @return
     */
    Result<ProjectLevelManPowerMoneyAllByMonthDTO> findAllGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);
    /**
     * 列表查询
     * @param startYear
     * @param endYear
     * @return
     */
    List<ProjectLevelManPowerMoneyAllByMonthDTO> findAllGroupByMonthList(Integer startYear, Integer endYear);

    /**
     * * 分页查询
     * C04 获取报表人力成本-金额-项目级-按产生部门类别-小计
     * @param startYear
     * @param endYear
     * @param pageNo
     * @param pageSize
     * @return
     */
    Result<ProjectLevelManPowerMoneyAllByDepDTO> findDepTypeSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);
    /**
     * 列表查询
     * @param startYear
     * @param endYear
     * @return
     */
    List<ProjectLevelManPowerMoneyAllByDepDTO> findDepTypeSubTotalList(Integer startYear, Integer endYear);

    /**
     * * 分页查询
     * C05 获取报表人力成本-金额-项目级-按产生部门类别-年度
     * @param startYear
     * @param endYear
     * @param pageNo
     * @param pageSize
     * @return
     */
    Result<ProjectLevelManPowerMoneyAllByDepByYearDTO> findDepTypeGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);
    /**
     * 列表查询
     * @param startYear
     * @param endYear
     * @return
     */
    List<ProjectLevelManPowerMoneyAllByDepByYearDTO> findDepTypeGroupByYearList(Integer startYear, Integer endYear);


    /**
     * * 分页查询
     * C06 获取报表人力成本-金额-项目级-按产生部门类别-月度
     * @param startYear
     * @param endYear
     * @param pageNo
     * @param pageSize
     * @return
     */
    Result<ProjectLevelManPowerMoneyAllByDepByMonthDTO> findDepTypeGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);
    /**
     * 列表查询
     * @param startYear
     * @param endYear
     * @return
     */
    List<ProjectLevelManPowerMoneyAllByDepByMonthDTO> findDepTypeGroupByMonthList(Integer startYear, Integer endYear);
}
