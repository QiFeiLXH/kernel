package com.bsoft.project.report.repository.primary;

import com.bsoft.project.report.entity.primary.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ContractLevelManPowerMoneyRepository {
    List<ContractLevelManPowerMoneyAllDO> findAllSubTotal(Integer startYear, Integer endYear);
    List<ContractLevelManPowerMoneyAllByYearDO> findAllGroupByYear(Integer startYear, Integer endYear);
    List<ContractLevelManPowerMoneyAllByMonthDO> findAllGroupByMonth(Integer startYear, Integer endYear);

    List<ContractLevelManPowerMoneyAllByDepDO> findDepTypeSubTotal(Integer startYear, Integer endYear);
    List<ContractLevelManPowerMoneyAllByDepByYearDO> findDepTypeGroupByYear(Integer startYear, Integer endYear);
    List<ContractLevelManPowerMoneyAllByDepByMonthDO> findDepTypeGroupByMonth(Integer startYear, Integer endYear);
}
