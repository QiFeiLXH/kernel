package com.bsoft.contract.dao.primary;

import com.bsoft.contract.entity.primary.ContractDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ContractDao extends JpaRepository<ContractDO,String>, JpaSpecificationExecutor<ContractDO> {
    @Query("select a  from ContractDO a where registerDate >= :start and registerDate <= :end")
    public List<ContractDO> getContract(@Param("start") Date start, @Param("end") Date end);

    public List<ContractDO> findAllByNumberEquals(String contractNo);

    @Modifying
    @Query("update ContractDO a set a.assignFlag = 1 where a.id = :htbh and (a.assignFlag = 0 or a.assignFlag is null)")
    void saveAssignFlag(@Param("htbh") String htbh);

    @Modifying
    @Query("update ContractDO a set a.assignFlag = 0 where a.id = :htbh and a.assignFlag = 1")
    void cancleAssignFlag(@Param("htbh") String htbh);

    @Modifying
    @Query("update ContractDO a set a.committed = :committed where a.id = :id")
    void updateCommitted(@Param("committed") Integer committed, @Param("id") String id);

    @Modifying
    @Query("update ContractDO a set a.committed = 3, a.backReason = :backReason where a.id = :id")
    void returnContract(@Param("id") String id, @Param("backReason") String backReason);

    @Modifying
    @Query("update ContractDO a set a.checkDate = :checkDate, a.checkPerson = :checkPerson, a.committed = 0 where a.id = :id")
    void updateContractCheck(@Param("id") String id, @Param("checkPerson") String checkPerson, @Param("checkDate")java.sql.Date checkDate);

    @Modifying
    @Query("update ContractDO a set a.finalCheckDate = :finalCheckDate where a.id = :contractId")
    void updateFinalCheckDate(@Param("contractId") String contractId, @Param("finalCheckDate")Date finalCheckDate);

}
