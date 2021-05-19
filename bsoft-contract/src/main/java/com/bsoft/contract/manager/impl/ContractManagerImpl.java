package com.bsoft.contract.manager.impl;

import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.contract.dao.primary.ContractDao;
import com.bsoft.contract.dao.primary.ContractExDao;
import com.bsoft.contract.dao.primary.ContractProductDao;
import com.bsoft.contract.dao.primary.ContractViewDao;
import com.bsoft.contract.entity.primary.ContractDO;
import com.bsoft.contract.entity.primary.ContractExDO;
import com.bsoft.contract.entity.primary.ContractViewDO;
import com.bsoft.contract.manager.ContractManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class ContractManagerImpl implements ContractManager {
    @Autowired
    private ContractDao contractDao;
    @Autowired
    private ContractExDao contractExDao;
    @Autowired
    private ContractProductDao contractProductDao;

    @Autowired
    private ContractViewDao contractViewDao;
    @Autowired
    private ServerDateManager serverDateManager;

    @Override
    public List<ContractViewDO> getTodayContract() {
        java.sql.Date start = serverDateManager.getServerDate();
        Date end = serverDateManager.getServerDateTime();
        return contractViewDao.getContract(start, end);
    }

    @Override
    public ContractDO getContract(String id) {
        return contractDao.findById(id).get();
    }

    @Override
    public ContractExDO getContractEx(String contractNo) {
        try {
            ContractExDO contractExDO = contractExDao.findById(contractNo).get();
            return contractExDO;
        } catch (Exception e) {
            if (e instanceof NoSuchElementException) {
                return new ContractExDO();
            }
        }
        return new ContractExDO();
    }

    @Override
    public List<ContractDO> findContractBynumber(String contractNo) {
        List<ContractDO> list = contractDao.findAllByNumberEquals(contractNo);
        return list;
    }

    @Override
    public void saveAssignFlag(String htbh) {
        contractDao.saveAssignFlag(htbh);
    }

    @Override
    public void calcleAssignFlag(String htbh) {
        contractDao.cancleAssignFlag(htbh);
    }

    @Override
    @Transactional
    public void updateCommitted(Integer committed,String id) {
        contractDao.updateCommitted(committed, id);
    }

    @Override
    @Transactional
    public void returnContract(String id, String backReason) {
        contractDao.returnContract(id, backReason);
    }

    @Override
    @Transactional
    public void checkSalesContract(String contractId, String personId) {
        java.sql.Date serverDate = serverDateManager.getServerDate();
        contractDao.updateContractCheck(contractId, personId, serverDate);
    }

    @Override
    @Transactional
    public void updateContractProductUpdateFlag(Integer id, Integer updateFlag) {
        contractProductDao.updateContractProductUpdateFlag(id, updateFlag);
    }

    @Override
    @Transactional
    public void updateFinalCheckDate(String contractNo, Date finalCheckDate) {
        ContractExDO contractExDO = null;
        try {
            contractExDO = contractExDao.findById(contractNo).get();
        } catch (Exception e) {
            if (e instanceof NoSuchElementException) {
                contractExDO = new ContractExDO();
            }
        }
        if (StringUtils.isNotBlank(contractExDO.getContractNo())) {
            contractExDao.updateCheckDate(contractNo, finalCheckDate);
        } else {
            contractExDO.setContractNo(contractNo);
            contractExDO.setCheckDate(finalCheckDate);
            contractExDao.save(contractExDO);
        }

    }
}
