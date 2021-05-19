package com.bsoft.hr.dao.primary;

import com.bsoft.common.entity.primary.PublicDicDO;
import com.bsoft.hr.entity.primary.DeptCostMaintainDO;
import com.bsoft.hr.entity.primary.PostAndCostRuleDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface PostAndCostRuleDao extends JpaRepository<PostAndCostRuleDO,Integer>, JpaSpecificationExecutor<PostAndCostRuleDO> {

    @Transactional
    @Modifying
    @Query(value = "update PostAndCostRuleDO pc set pc.costType = :costType,pc.financialType=:financialType where pc.id=:id")
    void updatePostAndCostRule(@Param("id") Integer id, @Param("costType") Integer costType , @Param("financialType")Integer financialType);

    @Query(value = "select pc.postType from PostAndCostRuleDO pc where pc.id=:id")
    Integer getByIdFindPostType(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "delete from  PostAndCostRuleDO pc where pc.id=:id")
    void deleteById(@Param("id") Integer id);

    @Query(value ="select pc from PostAndCostRuleDO pc where pc.financialType=:financialType" )
    List<PostAndCostRuleDO> findByFinancial(@Param("financialType") Integer financialType);

}
