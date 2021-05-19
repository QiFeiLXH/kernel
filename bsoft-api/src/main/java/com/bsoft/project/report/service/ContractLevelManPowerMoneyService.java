package com.bsoft.project.report.service;

import com.bsoft.common.result.Result;
import com.bsoft.project.report.dto.*;

import java.util.List;

public interface ContractLevelManPowerMoneyService {
    /**
     * * 分页查询
     * C07 获取报表人力成本-金额-合同级-全部-小计
     * @param startYear 开始年份
     * @param endYear   结束年份
     * @param pageNo    页码
     * @param pageSize  每页条数
     * @return
     */
    Result<ContractLevelManPowerMoneyAllDTO> findAllSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);
    /**
     * 列表查询
     * @param startYear
     * @param endYear
     * @return
     */
    List<ContractLevelManPowerMoneyAllDTO> findAllSubTotalList(Integer startYear, Integer endYear);

    /**
     * * 分页查询
     * C08 获取报表人力成本-金额-合同级-全部-年度
     * @param startYear
     * @param endYear
     * @param pageNo
     * @param pageSize
     * @return
     */
    Result<ContractLevelManPowerMoneyAllByYearDTO> findAllGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);
    /**
     * 列表查询
     * @param startYear
     * @param endYear
     * @return
     */
    List<ContractLevelManPowerMoneyAllByYearDTO> findAllGroupByYearList(Integer startYear, Integer endYear);

    /**
     * * 分页查询
     * C09 获取报表人力成本-金额-合同级-全部-月度
     * @param startYear
     * @param endYear
     * @param pageNo
     * @param pageSize
     * @return
     */
    Result<ContractLevelManPowerMoneyAllByMonthDTO> findAllGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);
    /**
     * 列表查询
     * @param startYear
     * @param endYear
     * @return
     */
    List<ContractLevelManPowerMoneyAllByMonthDTO> findAllGroupByMonthList(Integer startYear, Integer endYear);

    /**
     * * 分页查询
     * C10 获取报表人力成本-金额-合同级-按产生部门类别-小计
     * @param startYear
     * @param endYear
     * @param pageNo
     * @param pageSize
     * @return
     */
    Result<ContractLevelManPowerMoneyAllByDepDTO> findDepTypeSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);
    /**
     * 列表查询
     * @param startYear
     * @param endYear
     * @return
     */
    List<ContractLevelManPowerMoneyAllByDepDTO> findDepTypeSubTotalList(Integer startYear, Integer endYear);

    /**
     * * 分页查询
     * C11 获取报表人力成本-金额-合同级-按产生部门类别-年度
     * @param startYear
     * @param endYear
     * @param pageNo
     * @param pageSize
     * @return
     */
    Result<ContractLevelManPowerMoneyAllByDepByYearDTO> findDepTypeGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);
    /**
     * 列表查询
     * @param startYear
     * @param endYear
     * @return
     */
    List<ContractLevelManPowerMoneyAllByDepByYearDTO> findDepTypeGroupByYearList(Integer startYear, Integer endYear);

    /**
     * * 分页查询
     * C12 获取报表人力成本-金额-合同级-按产生部门类别-月度
     * @param startYear
     * @param endYear
     * @param pageNo
     * @param pageSize
     * @return
     */
    Result<ContractLevelManPowerMoneyAllByDepByMonthDTO> findDepTypeGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);
    /**
     * 列表查询
     * @param startYear
     * @param endYear
     * @return
     */
    List<ContractLevelManPowerMoneyAllByDepByMonthDTO> findDepTypeGroupByMonthList(Integer startYear, Integer endYear);
}
