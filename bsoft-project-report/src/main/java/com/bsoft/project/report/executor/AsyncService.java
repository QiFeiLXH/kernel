package com.bsoft.project.report.executor;

import com.bsoft.project.report.entity.primary.*;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.List;

/**
 * @Auther: hy
 * @Date: 2019/12/13
 * @Description:
 */
public interface AsyncService {

    ListenableFuture<List<ManpowerCostPDO>> manpowerCostPAsync(List<ManpowerCostPDO> oldList, List<ManpowerCostPViewDO> newList);
    ListenableFuture<List<ManpowerCostTDO>> manpowerCostTAsync(List<ManpowerCostTDO> oldList, List<ManpowerCostTViewDO> newList);
    ListenableFuture<List<ReimbursementBonusDO>> reimbursementBonusAsync(List<ReimbursementBonusDO> oldList, List<ReimbursementBonusViewDO> newList);
}
