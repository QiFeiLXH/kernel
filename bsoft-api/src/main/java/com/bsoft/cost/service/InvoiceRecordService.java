package com.bsoft.cost.service;

import com.bsoft.common.result.Result;
import com.bsoft.cost.dto.InvoiceContentDTO;
import com.bsoft.cost.dto.InvoiceRecordDTO;
import com.bsoft.cost.dto.InvoiceRecordQueryCndDTO;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/15 10:26
 * @Description
 */
public interface InvoiceRecordService {
    /**
     * 获取开票记录列表
     * @param cndDTO 查询参数
     * @return Result<InvoiceRecordDTO>
     */
    Result<InvoiceRecordDTO> getInvoiceRecordList(InvoiceRecordQueryCndDTO cndDTO);

    /**
     * 获取开票内容列表
     * @param invoiceRecordId 开票记录id
     * @return List<InvoiceContentDTO>
     */
    List<InvoiceContentDTO> getInvoiceContentList(Integer invoiceRecordId);
}
