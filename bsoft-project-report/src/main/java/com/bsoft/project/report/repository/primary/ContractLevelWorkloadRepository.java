package com.bsoft.project.report.repository.primary;

import com.bsoft.project.report.entity.primary.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author zhanglf
 * @Date 2020-01-03 9:53
 * @Version 1.0
 * @Description
 */
@Mapper
@Repository
public interface ContractLevelWorkloadRepository {
    List<ContractLevelworkloadAllDO> findAllSubTotal(Integer startYear, Integer endYear);
    List<ContractLevelworkloadAllByYearDO> findAllGroupByYear(Integer startYear, Integer endYear);
    List<ContractLevelworkloadAllByMonthDO> findAllGroupByMonth(Integer startYear, Integer endYear);

    List<ContractLevelworkloadAllByDepDO> findDepTypeSubTotal(Integer startYear, Integer endYear);
    List<ContractLevelworkloadAllByDepByYearDO> findDepTypeGroupByYear(Integer startYear, Integer endYear);
    List<ContractLevelworkloadAllByDepByMonthDO> findDepTypeGroupByMonth(Integer startYear, Integer endYear);
}
