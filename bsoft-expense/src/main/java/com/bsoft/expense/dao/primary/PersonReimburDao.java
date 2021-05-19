package com.bsoft.expense.dao.primary;

import com.bsoft.expense.entity.primary.PersonReimburDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2021/1/7 16:43
 * @Description:
 */
@Repository
public interface PersonReimburDao extends JpaRepository<PersonReimburDO,String>, JpaSpecificationExecutor<PersonReimburDO> {

    @Modifying
    @Query("update PersonReimburDO a set a.dept = :dept where a.accountDate >= :hsrq and a.reimburPerson = :personid")
    void updateDept(@Param("personid") String personid, @Param("dept") String dept, @Param("hsrq") Date hsrq);

}
