package com.bsoft.contract.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.contract.dto.ContractDTO;
import com.bsoft.contract.dto.ContractExDTO;
import com.bsoft.contract.entity.primary.ContractDO;
import com.bsoft.contract.entity.primary.ContractExDO;
import com.bsoft.contract.manager.ContractManager;
import com.bsoft.contract.service.ContractService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/*
 * @author  hy
 * @date  2020/3/29 19:55
 * @description
 */
@Service
public class ContractServiceImpl implements ContractService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContractServiceImpl.class);

    @Autowired
    private ContractManager contractManager;
    @Autowired
    private IGenerator generatorUtil;

    @Override
    public ContractDTO getContract(String id) {
        ContractDO contractDO = contractManager.getContract(id);
        return generatorUtil.convert(contractDO, ContractDTO.class);
    }

    @Override
    public ContractExDTO getContractEx(String contractNo) {
        ContractExDO contractEx = contractManager.getContractEx(contractNo);
        return generatorUtil.convert(contractEx, ContractExDTO.class);
    }

    @Override
    public ContractDTO getContractByContractNo(String contractNo) {
        ContractDO contractDO = contractManager.findContractBynumber(contractNo).get(0);
        return generatorUtil.convert(contractDO, ContractDTO.class);
    }

    @Override
    public void updateContractExCheckDate(String contractNo, Date finalCheckDate) {
        contractManager.updateFinalCheckDate(contractNo, finalCheckDate);
    }


    @Override
    public void updateContractProductUpdateFlag(Integer id, Integer updateFlag) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        contractManager.updateContractProductUpdateFlag(id,updateFlag);
        long times = timeConsumer.end();
        LOGGER.info("更新合同产品信息更新标志耗时:{}，id：{},updateFlag:{}",id,updateFlag,times);
    }
}
