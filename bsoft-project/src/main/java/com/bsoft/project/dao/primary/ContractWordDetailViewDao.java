package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ContractWordDetailViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @version 1.0
 * @author: zy
 * @date: 2021/4/27
 * @description
 */
@Repository
public interface ContractWordDetailViewDao extends JpaRepository<ContractWordDetailViewDO, Integer>, JpaSpecificationExecutor<ContractWordDetailViewDO> {
    List<ContractWordDetailViewDO> findAllByContractIdAndStandardWordId(String contractId, Integer standardWordId);
}
