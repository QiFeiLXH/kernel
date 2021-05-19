package com.bsoft.contract.manager;

import com.bsoft.contract.entity.primary.ContractDO;
import com.bsoft.contract.entity.primary.ContractExDO;
import com.bsoft.contract.entity.primary.ContractViewDO;

import java.util.Date;
import java.util.List;

public interface ContractManager {
    List<ContractViewDO> getTodayContract();

    ContractDO getContract(String id);

    ContractExDO getContractEx(String contractNo);

    List<ContractDO> findContractBynumber(String contractNo);

    void saveAssignFlag(String htbh);

    void calcleAssignFlag(String htbh);

    void updateCommitted(Integer committed, String id);

    void returnContract(String id, String backReason);

    void checkSalesContract(String contractId, String personId);

    void updateContractProductUpdateFlag(Integer id, Integer updateFlag);

    /**
    * @author zy
    * @description 根据合同号更新终验日期
    * @param contractId 合同编号htbh
    * @param finalCheckDate 终验日期
    */
    void updateFinalCheckDate(String contractId, Date finalCheckDate);
}
