package com.bsoft.payment.service;

import com.bsoft.common.dto.ImportResultDTO;
import com.bsoft.common.result.Result;
import com.bsoft.payment.dto.FlowPaymentDTO;
import com.bsoft.payment.dto.FlowPaymentQueryCndDTO;

import java.util.List;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.payment.service
 * @Author: Qi fei
 * @CreateTime: 2020-07-25 18:25
 * @Description:
 */
public interface FlowPaymentService {

    /** 运营流水、收益查询列表
     * @Param: flowPaymentQueryCndDTO
     * @return com.bsoft.common.result.Result<FlowPaymentDTO>
     * @author Xuhui Lin
     */
    Result<FlowPaymentDTO> getFinancialPaymentList(FlowPaymentQueryCndDTO flowPaymentQueryCndDTO);

    /** 删除运营流水、收益列表
     * @Param: deletes id
     * @return
     * @author Xuhui Lin
     */
    void deleteFinancialPayments(List<Integer> deletes);

    /** 审核运营流水、收益列表
     * @Param: flowPaymentDTOS
     * @Param: personId 工号
     * @return
     * @author Xuhui Lin
     */
    void auditFinancialPayments(List<FlowPaymentDTO> flowPaymentDTOS, String personId);

    /** 保存运营流水、收益列表
     * @Param: needSaveDTOS 待保存数据
     * @Param: errorDTOS 错误数据
     * @Param: personId 工号
     * @Param: flag 数据类型 1 流水 2收益
     * @return
     * @author Xuhui Lin
     */
    ImportResultDTO saveFinancialPayments(List<FlowPaymentDTO> needSaveDTOS, List<FlowPaymentDTO> errorDTOS, String personId, Integer flag);

    /** 获取错误列表
     * @Param: personId 工号
     * @Param: flag 数据类型 1 流水 2收益
     * @return
     * @author Xuhui Lin
     */
    List<FlowPaymentDTO> getErrorFinancialPayments(String personId, Integer flag);


}
