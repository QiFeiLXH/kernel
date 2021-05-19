package com.bsoft.cost.manager;

import com.bsoft.common.result.Result;
import com.bsoft.cost.condition.PublicCostCnd;
import com.bsoft.cost.dto.PublicCostCndDTO;
import com.bsoft.cost.entity.primary.BankChargesNoBillDO;
import com.bsoft.cost.entity.primary.CostRecordDO;
import com.bsoft.cost.entity.primary.DeptPublicCostDO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-04-20 9:46
 * @Version 1.0
 * @Description
 */
public interface BankChargesManager {
    void sendPublicFeRemindMessage();

    void sendWinningBidMessage();

    Result<BankChargesNoBillDO> getBillNotReceived(String userId,String context, Integer pageSize, Integer pageNo) ;

    Page<DeptPublicCostDO> getPublicCostList(PublicCostCnd publicCostCnd);

    List<CostRecordDO> getNeedFrozenAccount();

    DeptPublicCostDO getDeptPublicCostById(Integer id);

    void saveCostRecords(List<CostRecordDO> costRecordDOS);

    Page<DeptPublicCostDO> getPersonalPublicCostList(PublicCostCnd cnd);
}
