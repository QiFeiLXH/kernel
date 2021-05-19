package com.bsoft.contract.manager.impl;

import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.contract.dao.primary.ContractReviewViewDao;
import com.bsoft.contract.entity.primary.ContractReviewViewDO;
import com.bsoft.contract.manager.ContractReviewManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
@Component
public class ContractReviewManagerImpl implements ContractReviewManager {
    @Autowired
    private ContractReviewViewDao contractReviewViewDao;
    @Autowired
    private ServerDateManager serverDateManager;
    @Override
    public List<ContractReviewViewDO> getTodayContractReview() {
        java.sql.Date start =  serverDateManager.getServerDate();
        Date end = serverDateManager.getServerDateTime();
        return contractReviewViewDao.getContractReview(start,end);
    }
}
