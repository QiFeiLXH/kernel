package com.bsoft.project.report.repository.primary;

import com.bsoft.project.report.entity.primary.ContractAllSubTotalDO;
import com.bsoft.project.report.entity.primary.ContractDepTypeByYearDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author zhanglf
 * @Date 2019-12-23 14:59
 * @Version 1.0
 * @Description
 */
@Mapper
@Repository
public interface ContractLevelRepository {
    List<ContractAllSubTotalDO> findAllSubTotal(Integer startYear, Integer endYear);

    List<ContractDepTypeByYearDO> findDepTypeSubTotal(Integer startYear, Integer endYear);
}
