package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.LaborContractQuitViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-12-08 16:19
 * @Version 1.0
 */
@Repository
public interface LaborContractQuitViewDao extends JpaRepository<LaborContractQuitViewDO, Integer>, JpaSpecificationExecutor<LaborContractQuitViewDO> {
    List<LaborContractQuitViewDO> findByPersonId(String personId);
}
