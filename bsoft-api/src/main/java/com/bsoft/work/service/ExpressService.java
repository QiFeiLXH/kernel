package com.bsoft.work.service;

import com.bsoft.common.dto.ImportResultDTO;
import com.bsoft.common.result.Result;
import com.bsoft.work.dto.ExpressDetailDTO;
import com.bsoft.work.dto.ExpressQueryCndDTO;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/30 15:07
 * @Description
 */
public interface ExpressService {

    /**
     * 快递查询
     * @param cndDTO 查询条件
     */
    Result<ExpressDetailDTO> getExpressList(ExpressQueryCndDTO cndDTO);

    /**
     * 未支付数量查询
     * @param cndDTO 查询条件
     */
    Integer getExpressUnpaidCount(ExpressQueryCndDTO cndDTO);

    /**
     * 未支付金额
     * @param
     */
    Double getExpressUnpaidAmount();

    /**
     * 总金额
     * @param
     */
    Double getExpressTotalAmount(List<Integer> expressIds);

    /**
     * 指定条件下的快递id
     * @param
     */
    List<Integer> getExpressIdList(ExpressQueryCndDTO cndDTO);

    /**
     * 导入快递核准金额
     * @param
     */
    ImportResultDTO saveExpressDetails(List<ExpressDetailDTO> needSaveDataDTO, List<ExpressDetailDTO> errorDataDTO, String personId);

    /**
     * 获取导入快递核准金额失败列表
     * @param personId 工号
     */
    List<ExpressDetailDTO> getErrorExpressList(String personId);

    /**
     * 快递申请支付
     */
    List<ExpressDetailDTO> updateExpressApplyPay(List<Integer> ids);

    /**
     * 快递支付
     */
    void updateExpressPay(List<Integer> ids);

    /**
     * 获取快递明细
     */
    List<ExpressDetailDTO> getExpressList(List<Integer> ids);

    /**
     * 修改核准金额并同步分摊表金额
     */
    void saveExpressDetail(ExpressDetailDTO expressDetailDTO);
}
