package com.bsoft.work.dao.primary;

import com.bsoft.work.entity.primary.PrintingDetailDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/27 15:25
 * @Description
 */
@Repository
public interface PrintingDetailDao extends JpaRepository<PrintingDetailDO, Integer>, JpaSpecificationExecutor<PrintingDetailDO> {
    List<PrintingDetailDO> findAllByPrintingId(Integer printingId);
}
