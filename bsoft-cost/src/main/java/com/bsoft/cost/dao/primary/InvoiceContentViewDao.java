package com.bsoft.cost.dao.primary;

import com.bsoft.cost.entity.primary.InvoiceContentViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceContentViewDao extends JpaRepository<InvoiceContentViewDO,Integer>, JpaSpecificationExecutor<InvoiceContentViewDO> {
    List<InvoiceContentViewDO> findAllByInvoiceRecordIdOrderByIdDesc(Integer invoiceRecordId);
}
