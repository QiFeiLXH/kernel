package com.bsoft.work.dao.primary;

import com.bsoft.work.entity.primary.ExpressDetailDO;
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
 * @Date 2021/1/20 14:32
 * @Description
 */
@Repository
public interface ExpressDetailDao extends JpaRepository<ExpressDetailDO, Integer>, JpaSpecificationExecutor<ExpressDetailDO> {
    @Modifying
    @Query("update ExpressDetailDO a set a.status = 1, a.applyPayDate = :serverDate where id in(:ids)")
    void updateStatusAndApplyPayDateByIdIn(@Param("ids")List<Integer> ids, @Param("serverDate")Date serverDate);

    @Modifying
    @Query("update ExpressDetailDO a set a.status = 2 where id in(:ids)")
    void updateStatusByIdIn(@Param("ids") List<Integer> ids);

    @Modifying
    @Query("update ExpressDetailDO a set a.approval = :approval where id = :id")
    void updateApprovalById(@Param("id") Integer id,@Param("approval") Double approval);
}
