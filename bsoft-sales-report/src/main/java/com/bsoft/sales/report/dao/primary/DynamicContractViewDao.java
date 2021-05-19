package com.bsoft.sales.report.dao.primary;

import com.bsoft.sales.report.entity.primary.DynamicContractViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DynamicContractViewDao extends JpaRepository<DynamicContractViewDO,Integer>, JpaSpecificationExecutor<DynamicContractViewDO> {
    public List<DynamicContractViewDO> findByDynamicId(Integer dynamicId);
}
