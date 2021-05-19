package com.bsoft.work.dao.primary;

import com.bsoft.work.condition.ExpressQueryCnd;
import com.bsoft.work.entity.primary.ExpressDetailViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/30 15:08
 * @Description
 */
@Repository
public interface ExpressDetailViewDao extends JpaRepository<ExpressDetailViewDO, Integer>, JpaSpecificationExecutor<ExpressDetailViewDO> {
    @Query("select nvl(sum(a.approval),0) from ExpressDetailViewDO a where a.status = 0")
    Double getExpressUnpaidAmount();

    @Query("select nvl(sum(a.approval),0) from ExpressDetailViewDO a where a.id in (:expressIds)")
    Double getExpressTotalAmount(@Param("expressIds") List<Integer> expressIds);

    List<ExpressDetailViewDO> findAllByExpressNoIn(List<String> expressNos);

    List<ExpressDetailViewDO> findAllByIdIn(List<Integer> ids);


}
