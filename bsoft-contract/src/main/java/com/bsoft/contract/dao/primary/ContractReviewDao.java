package com.bsoft.contract.dao.primary;

import com.bsoft.contract.entity.primary.ContractReviewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ContractReviewDao extends JpaRepository<ContractReviewDO,String>, JpaSpecificationExecutor<ContractReviewDO> {
    @Query("select a  from ContractReviewDO a where a.applyDate >= :start and a.applyDate <= :end")
    public List<ContractReviewDO> getContractReview(@Param("start") Date start, @Param("end") Date end);

}
