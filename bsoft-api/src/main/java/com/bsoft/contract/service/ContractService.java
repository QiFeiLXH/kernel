package com.bsoft.contract.service;

import com.bsoft.contract.dto.ContractDTO;
import com.bsoft.contract.dto.ContractExDTO;

import java.util.Date;

/*
 * @author  hy
 * @date  2020/3/29 19:53
 * @description
 */
public interface ContractService {
    ContractDTO getContract(String id);

    ContractExDTO getContractEx(String contractNo);

    ContractDTO getContractByContractNo(String contractNo);

    /**
     * @param contractId     合同编号htbh
     * @param finalCheckDate 终验日期
     * @author zy
     * @description 根据合同号更新终验日期
     */
    void updateContractExCheckDate(String contractId, Date finalCheckDate);


    /** 更新合同产品信息的更新标志
     * @Param: id 产品信息表id
     * @Param: updateFlag 更新标志
     * @author Xuhui Lin
     */
    void updateContractProductUpdateFlag(Integer id, Integer updateFlag);
}
