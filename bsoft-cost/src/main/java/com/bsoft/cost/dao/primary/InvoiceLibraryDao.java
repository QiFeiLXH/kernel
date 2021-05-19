package com.bsoft.cost.dao.primary;

import com.bsoft.cost.entity.primary.InvoiceLibraryDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceLibraryDao extends JpaRepository<InvoiceLibraryDO,Integer>, JpaSpecificationExecutor<InvoiceLibraryDO> {
    @Query("select a from InvoiceLibraryDO a where a.id != :id and a.invoiceCode =:invoiceCode and a.invoiceNumber = :invoiceNumber")
    List<InvoiceLibraryDO> findByIdAndInvocie(@Param("id") Integer id,@Param("invoiceCode") String invoiceCode,@Param("invoiceNumber") String invoiceNumber);

    @Query("select a from InvoiceLibraryDO a where a.invoiceCode =:invoiceCode and a.invoiceNumber = :invoiceNumber")
    List<InvoiceLibraryDO> findByInvocie(@Param("invoiceCode") String invoiceCode,@Param("invoiceNumber") String invoiceNumber);
}
