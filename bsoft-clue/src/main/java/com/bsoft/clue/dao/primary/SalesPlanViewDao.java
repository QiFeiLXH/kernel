package com.bsoft.clue.dao.primary;

import com.bsoft.clue.entity.primary.SalesPlanViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesPlanViewDao extends JpaRepository<SalesPlanViewDO,Integer>, JpaSpecificationExecutor<SalesPlanViewDO> {
    List<SalesPlanViewDO> findAllByProcessInstanceIdIn(List<String> processInstanceIds);
    SalesPlanViewDO findByProcessInstanceId(String processInstanceId);

}
