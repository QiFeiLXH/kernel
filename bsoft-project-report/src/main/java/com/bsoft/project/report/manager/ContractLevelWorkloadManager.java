package com.bsoft.project.report.manager;

import com.bsoft.common.result.Result;
import com.bsoft.project.report.entity.primary.*;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-01-03 9:55
 * @Version 1.0
 * @Description
 */
public interface ContractLevelWorkloadManager {

    Result<ContractLevelworkloadAllDO> findAllSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//人力成本-工作量-合同级-全部-小计
    List<ContractLevelworkloadAllDO> findAllSubTotalList(Integer startYear, Integer endYear);//人力成本-工作量-合同级-全部-小计

    Result<ContractLevelworkloadAllByYearDO> findAllGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//人力成本-工作量-合同级-全部-年度
    List<ContractLevelworkloadAllByYearDO> findAllGroupByYearList(Integer startYear, Integer endYear);//人力成本-工作量-合同级-全部-年度

    Result<ContractLevelworkloadAllByMonthDO> findAllGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//人力成本-工作量-合同级-全部-月度
    List<ContractLevelworkloadAllByMonthDO> findAllGroupByMonthList(Integer startYear, Integer endYear);//人力成本-工作量-合同级-全部-月度

    Result<ContractLevelworkloadAllByDepDO> findDepTypeSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//人力成本-工作量-合同级-按产生部门类型-小计
    List<ContractLevelworkloadAllByDepDO> findDepTypeSubTotalList(Integer startYear, Integer endYear);//人力成本-工作量-合同级-按产生部门类型-小计

    Result<ContractLevelworkloadAllByDepByYearDO> findDepTypeGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//人力成本-工作量-合同级-按产生部门类型-年度
    List<ContractLevelworkloadAllByDepByYearDO> findDepTypeGroupByYearList(Integer startYear, Integer endYear);//人力成本-工作量-合同级-按产生部门类型-年度

    Result<ContractLevelworkloadAllByDepByMonthDO> findDepTypeGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);//人力成本-工作量-合同级-按产生部门类型-月度
    List<ContractLevelworkloadAllByDepByMonthDO> findDepTypeGroupByMonthList(Integer startYear, Integer endYear);//人力成本-工作量-合同级-按产生部门类型-月度
}
