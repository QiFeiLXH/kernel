package com.bsoft.sales.manager;

import com.bsoft.sales.condition.ContractModuleQueryCnd;
import com.bsoft.sales.condition.SalesContractAuditCnd;
import com.bsoft.sales.condition.SalesContractCheckQueryCnd;
import com.bsoft.sales.condition.SalesContractQueryCnd;
import com.bsoft.sales.entity.primary.*;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/3/3 12:52
 * @Description
 */
public interface ContractModuleManager {
    Page<ContractProducViewDO> getContractProductList(ContractModuleQueryCnd cnd);

    List<ContractModuleViewDO> getContractModuleList(ContractModuleQueryCnd cnd);

    void saveContractProductModuleRelation(List<ContractModuleProductDO> saveList, List<ContractModuleProductDO> list, String contractId, String personId);

    Page<SalesContractViewDO> getContractList(SalesContractQueryCnd cnd);

    Integer commitContractProductModuleRelation(List<ContractModuleProductDO> saveList, List<ContractModuleProductDO> deleteList, String contractId, String personId, Integer completeFlag);

    List<Integer> getSalesContractModuleCount(SalesContractQueryCnd cnd);

    List<SalesContractModuleViewDO> getSalesContractModuleList(SalesContractQueryCnd cnd);

    List<SalesContractAreaViewDO> getSalesContractAreaList(SalesContractAuditCnd cnd);

    Page<SalesContractViewDO> getSalesContractAuditList(SalesContractAuditCnd cnd);

    void auditSalesContract(String contractId);

    void returnSalesContract(String contractId, String backReason);

    PageInfo<SalesContractCheckViewDO> getSalesCheckContractList(SalesContractCheckQueryCnd cnd);

    Page<SalesContractModuleCheckViewDO> getSalesCheckContractModuleList(Integer pageNo, Integer pageSize, String contractId);

    void checkSalesContract(String contractId, String personId);

    Integer getUncheckedCount(String personId, Boolean allPermission);
}
