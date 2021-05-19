package com.bsoft.cost.manager;

import com.bsoft.common.result.Result;
import com.bsoft.cost.condition.BondInfoQueryCnd;
import com.bsoft.cost.dto.BondInfoQueryCndDTO;
import com.bsoft.cost.entity.primary.BondInfoDO;
import com.bsoft.cost.entity.primary.BondSaveDO;
import com.bsoft.cost.entity.primary.NeedDealCountDO;
import com.bsoft.cost.entity.primary.BondOverdueInfoDO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-04-20 9:46
 * @Version 1.0
 * @Description
 */
public interface BondManager {
    void sendBondRemindMessage();

    void sendPerformanceBondRemindMessage();

    Result<BondInfoDO> getBondNotRushAccount(String userId, Integer performanceSymbol,String context, Integer pageSize, Integer pageNo) ;

    NeedDealCountDO getNeedDealCount(String userId);

    Page<BondOverdueInfoDO> getBondOverdueInfoList(BondInfoQueryCnd bondInfoQueryCnd);

    Page<BondOverdueInfoDO> getPersonalBondList(BondInfoQueryCnd bondInfoQueryCnd);

    List<BondOverdueInfoDO> getAllBondOverdueInfoList(BondInfoQueryCnd bondInfoQueryCnd);

    List<BondOverdueInfoDO> getPersonalAllBondList(BondInfoQueryCnd bondInfoQueryCnd);

    BondOverdueInfoDO getBondOverdueInfoById(String id);

    List<BondSaveDO> getNeedFrozenAccount();

    void saveBondInfos(List<BondSaveDO> bondInfoDOS);

    BondSaveDO getById(String id);
}
