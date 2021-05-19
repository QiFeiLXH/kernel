package com.bsoft.contract.dao.primary;

import com.bsoft.contract.entity.primary.ContractDO;
import com.bsoft.contract.entity.primary.ContractViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ContractViewDao extends JpaRepository<ContractViewDO,String>, JpaSpecificationExecutor<ContractViewDO> {
    @Query("select a  from ContractViewDO a where registerDate >= :start and registerDate <= :end")
    public List<ContractViewDO> getContract(@Param("start") Date start, @Param("end") Date end);

}
