package com.bsoft.work.manager;

import com.bsoft.common.entity.primary.ImportResultDO;
import com.bsoft.work.condition.ExpressQueryCnd;
import com.bsoft.work.entity.primary.ExpressDetailDO;
import com.bsoft.work.entity.primary.ExpressDetailViewDO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/30 15:09
 * @Description
 */
public interface ExpressManager {
    Page<ExpressDetailViewDO> getExpressList(ExpressQueryCnd cnd);

    Integer getExpressUnpaidCount(ExpressQueryCnd cnd);

    Double getExpressUnpaidAmount();

    Double getExpressTotalAmount(List<Integer> expressIds);

    List<Integer> getExpressIdList(ExpressQueryCnd cnd);

    ImportResultDO saveExpressDetails(List<ExpressDetailViewDO> needSaveDataViewDO, List<ExpressDetailViewDO> errorDataViewDO, String personId);

    List<ExpressDetailViewDO> getErrorExpressList(String personId);

    List<ExpressDetailViewDO> updateExpressApplyPay(List<Integer> ids);

    void updateExpressPay(List<Integer> ids);

    List<ExpressDetailViewDO> getExpressList(List<Integer> ids);

    void saveExpressDetail(ExpressDetailDO detailDO);
}
