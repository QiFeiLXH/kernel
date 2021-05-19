package com.bsoft.cost.service;

import com.bsoft.cost.dto.BankChargesNoBillDTO;
import com.bsoft.common.result.Result;
import com.bsoft.cost.dto.DeptPublicCostDTO;
import com.bsoft.cost.dto.PublicCostCndDTO;

/**
 * @Author zhanglf
 * @Date 2020-04-17 16:16
 * @Version 1.0
 * @Description
 */
public interface BankChargesService {
    /**
     * 对公费用申请单，财务叶菲发放后，未收到票据的，进行待办提醒。
     * @param userId 申请人工号
     * @param context 查询条件
     * @param pageSize 分页参数
     * @param pageNo 分页参数
     * @return
     */
    Result<BankChargesNoBillDTO> getBillNotReceived(String userId,String context, Integer pageSize, Integer pageNo);

    /** 部门对公费用（中标服务费）查询
     * @param publicCostCndDTO (userId 申请人工号, pageNo 页码, pageSize 分页参数, returnFlag 发票归还标志（0为全部， 1为未归还）, allPermission 查看权限)
     * @return com.bsoft.common.result.Result<com.bsoft.cost.dto.DeptPublicCostDTO>
     */
    Result<DeptPublicCostDTO> getPublicCostList(PublicCostCndDTO publicCostCndDTO);

    /**
     * 根据id获取对应银行费用信息
     * @param id
     * @return
     */
    DeptPublicCostDTO getDeptPublicCost(Integer id);

    /** 个人对公费用（中标服务费）查询
     * @param publicCostCndDTO (userId 申请人工号, pageNo 页码, pageSize 分页参数, returnFlag 发票归还标志（0为全部， 1为未归还），startDate 开始时间， endDate 结束时间)
     * @return com.bsoft.common.result.Result<com.bsoft.cost.dto.DeptPublicCostDTO>
     */
    Result<DeptPublicCostDTO> getPersonalPublicCostList(PublicCostCndDTO publicCostCndDTO);
}
