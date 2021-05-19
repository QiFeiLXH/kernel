package com.bsoft.contract.manager;

import com.bsoft.contract.entity.primary.ContractReviewViewDO;

import java.util.List;

public interface ContractReviewManager {
    public List<ContractReviewViewDO> getTodayContractReview();
}
