package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.LaborContractApplyDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-12-08 16:55
 * @Version 1.0
 */
@Repository
public interface LaborContractApplyDao extends JpaRepository<LaborContractApplyDO, Integer>, JpaSpecificationExecutor<LaborContractApplyDO> {
    List<LaborContractApplyDO> findByProcessInstanceId(String processInstanceId);
}
