package com.bsoft.cost.manager;

import com.bsoft.cost.condition.InvoiceRecordQueryCnd;
import com.bsoft.cost.entity.primary.InvoiceContentViewDO;
import com.bsoft.cost.entity.primary.InvoiceRecordViewDO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/15 10:22
 * @Description
 */
public interface InvoiceRecordManager {
    Page<InvoiceRecordViewDO> getInvoiceRecordList(InvoiceRecordQueryCnd cnd);

    List<InvoiceContentViewDO> getInvoiceContentList(Integer invoiceRecordId);
}
