package com.bsoft.work.manager;

import com.bsoft.common.entity.primary.ImportResultDO;
import com.bsoft.work.condition.PrintingQueryCnd;
import com.bsoft.work.entity.primary.PrintingDO;
import com.bsoft.work.entity.primary.PrintingDetailDO;
import com.bsoft.work.entity.primary.PrintingViewDO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/27 15:07
 * @Description
 */
public interface PrintingManager {
    Page<PrintingViewDO> getPrintingList(PrintingQueryCnd cnd);

    Integer getPrintingUnpaidCount(PrintingQueryCnd cnd);

    Double getPrintingUnpaidAmount();

    Double getPrintingTotalAmount(List<Integer> printingIds);

    List<Integer> getPrintingIdList(PrintingQueryCnd cnd);

    ImportResultDO savePrintings(List<PrintingViewDO> needSaveDataViewDO, List<PrintingViewDO> errorDataViewDO, String personId);

    List<PrintingViewDO> getErrorPrintingList(String personId);

    List<PrintingViewDO> updatePrintingApplyPay(List<Integer> ids);

    void updatePrintingPay(List<Integer> ids);

    List<PrintingDetailDO> getPrintingDetailList(Integer printingId);

    void savePrinting(PrintingDO printingDO);
}
