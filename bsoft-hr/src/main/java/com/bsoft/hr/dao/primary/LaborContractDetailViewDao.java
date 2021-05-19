package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.LaborContractDetailViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @version 1.0
 * @author: zy
 * @date: 2020/12/24
 * @description
 */
@Repository
public interface LaborContractDetailViewDao extends JpaRepository<LaborContractDetailViewDO, Integer>, JpaSpecificationExecutor<LaborContractDetailViewDO> {
    List<LaborContractDetailViewDO> findByPersonIdOrderByRenewalStartDateDesc(String personId);
}
