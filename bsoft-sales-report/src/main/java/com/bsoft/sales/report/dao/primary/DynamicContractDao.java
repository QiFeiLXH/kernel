package com.bsoft.sales.report.dao.primary;

import com.bsoft.sales.report.entity.primary.DynamicContractDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DynamicContractDao extends JpaRepository<DynamicContractDO,Integer>, JpaSpecificationExecutor<DynamicContractDO> {
    public List<DynamicContractDO> findByDynamicId(Integer dynamicId);
}
