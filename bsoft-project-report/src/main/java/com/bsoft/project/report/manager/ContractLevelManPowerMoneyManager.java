package com.bsoft.project.report.manager;

import com.bsoft.common.result.Result;
import com.bsoft.project.report.entity.primary.*;

import java.util.List;

public interface ContractLevelManPowerMoneyManager {
    Result<ContractLevelManPowerMoneyAllDO> findAllSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);
    List<ContractLevelManPowerMoneyAllDO> findAllSubTotalList(Integer startYear, Integer endYear);

    Result<ContractLevelManPowerMoneyAllByYearDO> findAllGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);
    List<ContractLevelManPowerMoneyAllByYearDO> findAllGroupByYearList(Integer startYear, Integer endYear);

    Result<ContractLevelManPowerMoneyAllByMonthDO> findAllGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);
    List<ContractLevelManPowerMoneyAllByMonthDO> findAllGroupByMonthList(Integer startYear, Integer endYear);

    Result<ContractLevelManPowerMoneyAllByDepDO> findDepTypeSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);
    List<ContractLevelManPowerMoneyAllByDepDO> findDepTypeSubTotalList(Integer startYear, Integer endYear);

    Result<ContractLevelManPowerMoneyAllByDepByYearDO> findDepTypeGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);
    List<ContractLevelManPowerMoneyAllByDepByYearDO> findDepTypeGroupByYearList(Integer startYear, Integer endYear);


    Result<ContractLevelManPowerMoneyAllByDepByMonthDO> findDepTypeGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize);
    List<ContractLevelManPowerMoneyAllByDepByMonthDO> findDepTypeGroupByMonthList(Integer startYear, Integer endYear);
}
