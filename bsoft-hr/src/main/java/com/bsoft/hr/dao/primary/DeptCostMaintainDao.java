package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.DeptCostMaintainDO;
import com.bsoft.hr.entity.primary.PostAndCostRuleDO;
import oracle.sql.DATE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
@Repository
public interface DeptCostMaintainDao extends JpaRepository<DeptCostMaintainDO,Integer>, JpaSpecificationExecutor<DeptCostMaintainDO> {
    @Query(value = "select dept from DeptCostMaintainDO")
    List<String> getDeptList ();


    @Query(value = "select dp from DeptCostMaintainDO dp  where dp.dept = :dept and dp.type = :type")
    List<DeptCostMaintainDO> selectWithDept (@Param("dept") String dept,@Param("type") Integer type);

    @Query(value = "select dp from DeptCostMaintainDO dp  where dp.dept = :dept and dp.type = :type")
    DeptCostMaintainDO getDeptFinancialType (@Param("dept") String dept,@Param("type") Integer type);



    @Transactional
    @Modifying
    @Query(value = "update DeptCostMaintainDO dp set dp.financialType=:financialType,dp.adjustDate =:adjustDate where dp.dept =:dept and dp.type = :type ")
    void updateDeptCost(@Param("dept") String Dept,@Param("type") Integer type,@Param("financialType") Integer financialType,@Param("adjustDate") Date adjustDate);

    @Transactional
    @Modifying
    @Query(value = "delete from DeptCostMaintainDO dp  where dp.dept=:dept and dp.type=:type")
    void deleteFromDeptCostwithType(@Param("dept") String Dept,@Param("type") Integer type);

    @Transactional
    @Modifying
    @Query(value = "update DeptCostMaintainDO dp set dp.type = :type,dp.financialType=:financialType,dp.adjustDate = :adjustDate where dp.postType =:post ")
    void updatePostCost(@Param("post") Integer post,@Param("type") Integer type,@Param("financialType") Integer financialType,@Param("adjustDate") Date adjustDate);


    @Query(value ="select dp from DeptCostMaintainDO dp where dp.financialType=:financialType" )
    List<DeptCostMaintainDO>  findByFinancial(@Param("financialType") Integer financialType);

}
