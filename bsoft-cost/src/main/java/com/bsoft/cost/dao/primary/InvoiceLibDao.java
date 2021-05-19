package com.bsoft.cost.dao.primary;

import com.bsoft.cost.entity.primary.InvoiceLibDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author: xucl
 * @DateTime: 2020/9/29 14:12
 * @Description:
 */
@Repository
public interface InvoiceLibDao extends JpaRepository<InvoiceLibDO,Integer>, JpaSpecificationExecutor<InvoiceLibDO> {
}
