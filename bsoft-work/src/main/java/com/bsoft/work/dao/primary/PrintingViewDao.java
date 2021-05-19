package com.bsoft.work.dao.primary;

import com.bsoft.work.entity.primary.PrintingViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/27 15:25
 * @Description
 */
@Repository
public interface PrintingViewDao extends JpaRepository<PrintingViewDO, Integer>, JpaSpecificationExecutor<PrintingViewDO> {
    @Query("select nvl(sum(a.approval),0) from PrintingViewDO a where a.status = 0")
    Double getPrintingUnpaidAmount();

    @Query("select nvl(sum(a.approval),0) from PrintingViewDO a where a.id in (:printingIds)")
    Double getPrintingTotalAmount(@Param("printingIds")List<Integer> printingIds);

    List<PrintingViewDO> findAllByOrderNumIn(List<String> orderNums);

    List<PrintingViewDO> findAllByIdIn(List<Integer> ids);
}
