package com.bsoft.cost.service;

import com.bsoft.common.result.Result;
import com.bsoft.common.dto.CompanyDTO;
import com.bsoft.cost.dto.InvoiceLibraryDTO;
import com.bsoft.cost.dto.InvoiceLibraryQueryCndDTO;

import java.util.List;

public interface InvoiceLibraryService {
    /** 票据库查询
     * @param invoiceLibraryQueryCndDTO (userId 申请人工号, pageNo 页码, pageSize 分页参数, type 用途(数据来源), allPermission 查看权限)
     * @return com.bsoft.common.result.Result<com.bsoft.cost.dto.InvoiceLibraryDTO>
     */
    Result<InvoiceLibraryDTO> getInvoiceLibraryList(InvoiceLibraryQueryCndDTO invoiceLibraryQueryCndDTO);

    /**
     * 获取公司机构列表
     * @return
     */
    List<CompanyDTO> getCompanyList();
}
