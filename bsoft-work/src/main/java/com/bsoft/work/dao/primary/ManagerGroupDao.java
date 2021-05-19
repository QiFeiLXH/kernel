package com.bsoft.work.dao.primary;


import com.bsoft.work.entity.primary.ManagerGroupDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;



/**
 * @author Huang GH
 * @date 2021/5/10 10:53
 */
@Repository
public interface ManagerGroupDao extends JpaRepository<ManagerGroupDO, Integer>, JpaSpecificationExecutor<ManagerGroupDO> {

    /**
     * 注销委员会组
     * @param councilId
     * @param isCancel
     */
    @Transactional
    @Modifying
    @Query("update ManagerGroupDO m set m.isCancel = :isCancel where m.councilId = :councilId")
    void cancelManagerGroup(@Param("councilId") Integer councilId, @Param("isCancel") Integer isCancel);

}
