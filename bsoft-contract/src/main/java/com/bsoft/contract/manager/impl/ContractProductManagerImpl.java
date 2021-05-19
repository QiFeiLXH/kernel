package com.bsoft.contract.manager.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.contract.dao.primary.ContractProductSyncViewDao;
import com.bsoft.contract.dto.ContractProductSyncDTO;
import com.bsoft.contract.entity.primary.ContractProductSyncViewDO;
import com.bsoft.contract.manager.ContractProductManager;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/4/28 11:16
 * @Description
 */
@Component
public class ContractProductManagerImpl implements ContractProductManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContractProductManagerImpl.class);
    @Autowired
    private ContractProductSyncViewDao contractProductSyncViewDao;
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public void syncContractProduct() {
        List<ContractProductSyncViewDO> products = contractProductSyncViewDao.findAll();
        if(!products.isEmpty()) {
            List<ContractProductSyncDTO> productSyncDTOS = iGenerator.convert(products, ContractProductSyncDTO.class);
            productSyncDTOS.parallelStream().forEach(product -> {
                rocketMQTemplate.convertAndSend("snycProduct",product);
            });
        }

    }
}
