package com.bsoft.work.dao.primary;

import com.bsoft.work.entity.primary.PrintingDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/27 15:25
 * @Description
 */
@Repository
public interface PrintingDao extends JpaRepository<PrintingDO, Integer>, JpaSpecificationExecutor<PrintingDO> {
    @Modifying
    @Query("update PrintingDO a set a.approval = :approval where a.id = :id")
    void updateApprovalById(@Param("id") Integer id, @Param("approval") Double approval);

    @Modifying
    @Query("update PrintingDO a set a.status = 1, a.applyPayDate = :serverDate where a.id in (:ids)")
    void updateStatusAndApplyPayDateByIdIn(@Param("ids") List<Integer> ids, @Param("serverDate") Date serverDate);

    @Modifying
    @Query("update PrintingDO a set a.status = 2 where a.id in (:ids)")
    void updateStatusByIdIn(@Param("ids") List<Integer> ids);
}
