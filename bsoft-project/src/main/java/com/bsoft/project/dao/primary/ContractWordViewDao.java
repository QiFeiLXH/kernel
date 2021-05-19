package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ContractWordViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @version 1.0
 * @author: zy
 * @date: 2021/4/27
 * @description
 */
@Repository
public interface ContractWordViewDao extends JpaRepository<ContractWordViewDO, Integer>, JpaSpecificationExecutor<ContractWordViewDO> {
}
