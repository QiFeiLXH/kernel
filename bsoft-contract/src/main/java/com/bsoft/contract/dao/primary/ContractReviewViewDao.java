package com.bsoft.contract.dao.primary;

import com.bsoft.contract.entity.primary.ContractReviewViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ContractReviewViewDao extends JpaRepository<ContractReviewViewDO,String>, JpaSpecificationExecutor<ContractReviewViewDO> {
    @Query("select a  from ContractReviewViewDO a where a.applyDate >= :start and a.applyDate <= :end")
    public List<ContractReviewViewDO> getContractReview(@Param("start") Date start, @Param("end") Date end);

}
