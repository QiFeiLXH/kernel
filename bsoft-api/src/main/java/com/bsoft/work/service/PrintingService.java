package com.bsoft.work.service;

import com.bsoft.common.dto.ImportResultDTO;
import com.bsoft.common.result.Result;
import com.bsoft.work.dto.PrintingDTO;
import com.bsoft.work.dto.PrintingDetailDTO;
import com.bsoft.work.dto.PrintingQueryCndDTO;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/27 14:39
 * @Description
 */
public interface PrintingService {
    /**
     * 文印查询
     * @param cndDTO 查询条件
     */
    Result<PrintingDTO> getPrintingList(PrintingQueryCndDTO cndDTO);

    /**
     * 未支付数量查询
     * @param cndDTO 查询条件
     */
    Integer getPrintingUnpaidCount(PrintingQueryCndDTO cndDTO);

    /**
     * 未支付金额
     * @param
     */
    Double getPrintingUnpaidAmount();

    /**
     * 总金额
     * @param
     */
    Double getPrintingTotalAmount(List<Integer> printingIds);

    /**
     * 指定条件下的文印id
     * @param
     */
    List<Integer> getPrintingIdList(PrintingQueryCndDTO cndDTO);

    /**
     * 导入快递核准金额
     * @param
     */
    ImportResultDTO savePrintings(List<PrintingDTO> needSaveDataDTO, List<PrintingDTO> errorDataDTO, String personId);

    /**
     * 获取导入文印核准金额失败列表
     * @param personId 工号
     */
    List<PrintingDTO> getErrorPrintingList(String personId);

    /**
     * 文印申请支付
     */
    List<PrintingDTO> updatePrintingApplyPay(List<Integer> ids);

    /**
     * 文印支付
     */
    void updatePrintingPay(List<Integer> ids);

    /**
     * 获取文印明细
     */
    List<PrintingDetailDTO> getPrintingDetailList(Integer printingId);

    /**
     * 修改核准金额并同步分摊表金额
     */
    void savePrinting(PrintingDTO printingDTO);
}
