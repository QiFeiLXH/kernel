package com.bsoft.cost.dao.primary;

import com.bsoft.cost.entity.primary.InvoiceRecordViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRecordViewDao extends JpaRepository<InvoiceRecordViewDO,Integer>, JpaSpecificationExecutor<InvoiceRecordViewDO> {

}
