package com.bsoft.cost.service;

import com.bsoft.common.result.Result;
import com.bsoft.cost.dto.BondInfoDTO;
import com.bsoft.cost.dto.BondInfoQueryCndDTO;
import com.bsoft.cost.dto.BondOverdueInfoDTO;

import java.util.List;
import com.bsoft.cost.dto.NeedDealCountDTO;

/**
 * @Author zhanglf
 * @Date 2020-04-20 10:31
 * @Version 1.0
 * @Description
 */
public interface BondService {
    /**
     * 保证金，履约保证金 未冲账待办列表
     * @param userId 申请人工号
     * @param context 过滤条件
     * @param performanceSymbol 履约保证金标志 1.履约保证金 0.保证金
     * @param pageSize 分页参数
     * @param pageNo 分页参数
     * @return
     */
    Result<BondInfoDTO> getBondNotRushAccount(String userId,Integer performanceSymbol,String context, Integer pageSize, Integer pageNo);

    /**
     * 查询该登录人员的 对公费用，保证金等待办数量
     * @param userId  登录员工工号
     * @return
     */
    NeedDealCountDTO getNeedDealCount(String userId);

    /**
     * 保证金逾期情况列表
     * @param bondInfoQueryCndDTO (userId 申请人工号,pageNo 分页参数，pageSize 分页参数,overdueFlag 逾期标志（-1全部 0未逾期 1逾期），allPermission 查看权限, inputContent 筛选条件-收款单位，startDate 开始时间， endDate 结束时间)
     * @return
     */
    Result<BondOverdueInfoDTO> getBondOverdueInfoList(BondInfoQueryCndDTO bondInfoQueryCndDTO);

    /**
     * 保证金逾期情况列表
     * @param bondInfoQueryCndDTO (userId 申请人工号,pageNo 分页参数，pageSize 分页参数,overdueFlag 逾期标志（-1全部 0未逾期 1逾期），allPermission 查看权限， inputContent 筛选条件-收款单位，startDate 开始时间， endDate 结束时间)
     * @return
     */
    List<BondOverdueInfoDTO> getAllBondOverdueInfoList(BondInfoQueryCndDTO bondInfoQueryCndDTO);

    /**
     * 根据id获取对应保证金信息
     * @param id
     * @return
     */
    BondOverdueInfoDTO getBondOverdueInfo(String id);

    /**
     * 个人保证金逾期情况列表
     * @param bondInfoQueryCndDTO (userId 申请人工号,pageNo 分页参数，pageSize 分页参数,overdueFlag 逾期标志（-1全部 0未逾期 1逾期），allPermission 查看权限, inputContent 筛选条件-收款单位，startDate 开始时间， endDate 结束时间)
     * @return
     */
    Result<BondOverdueInfoDTO> getPersonalBondList(BondInfoQueryCndDTO bondInfoQueryCndDTO);

    /**
     * 个人保证金逾期情况列表
     * @param bondInfoQueryCndDTO (userId 申请人工号,pageNo 分页参数，pageSize 分页参数,overdueFlag 逾期标志（-1全部 0未逾期 1逾期），allPermission 查看权限， inputContent 筛选条件-收款单位，startDate 开始时间， endDate 结束时间)
     * @return
     */
    List<BondOverdueInfoDTO> getPersonalAllBondList(BondInfoQueryCndDTO bondInfoQueryCndDTO);
}
