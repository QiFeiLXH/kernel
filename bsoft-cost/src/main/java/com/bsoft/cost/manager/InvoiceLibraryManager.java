package com.bsoft.cost.manager;

import com.bsoft.cost.condition.InvoiceLibraryQueryCnd;
import com.bsoft.cost.entity.primary.InvoiceLibDO;
import com.bsoft.cost.entity.primary.InvoiceLibraryDO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface InvoiceLibraryManager {
    Page<InvoiceLibraryDO> getInvoiceLibraryList(InvoiceLibraryQueryCnd queryCnd);

    List<InvoiceLibraryDO> findByIdAndInvocie(Integer id,String invoiceCode,String invoiceNumber);

    List<InvoiceLibraryDO> findByInvocie(String invoiceCode,String invoiceNumber);

    InvoiceLibDO getInvoiceLib(Integer id);

    InvoiceLibDO saveInvoiceLib(InvoiceLibDO invoiceLibDO);

    void deleteInvoiceLib(Integer id);
}
