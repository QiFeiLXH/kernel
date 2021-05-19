package com.bsoft.contract.dao.primary;

import com.bsoft.contract.entity.primary.ContractDO;
import com.bsoft.contract.entity.primary.ContractExDO;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author: zy
 * @date: 2021/4/29
 * @description
 */
@Repository
public interface ContractExDao extends JpaRepository<ContractExDO,String>, JpaSpecificationExecutor<ContractExDO> {
    @Modifying
    @Query("update ContractExDO a set a.checkDate = :checkDate where a.contractNo = :contractNo")
    void updateCheckDate(@Param("contractNo") String contractNo, @Param("checkDate") Date checkDate);
}
