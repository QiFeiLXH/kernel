package com.bsoft.contract.dao.primary;

import com.bsoft.contract.entity.primary.ContractSubjectDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractSubjectDao extends JpaRepository<ContractSubjectDO,Integer>, JpaSpecificationExecutor<ContractSubjectDO> {

}
