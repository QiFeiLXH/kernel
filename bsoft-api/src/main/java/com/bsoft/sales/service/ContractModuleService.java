package com.bsoft.sales.service;

import com.bsoft.common.result.Result;
import com.bsoft.sales.dto.*;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/3/3 12:56
 * @Description
 */
public interface ContractModuleService {
    /** 合同模块-产品列表
     * @Param: contractNo 合同号
     * @Param: deptId 部门id
     * @Param: relationFlag 关联标志
     * @Param: pageNo 页码
     * @Param: pageSize 每页条数
     * @return com.bsoft.common.result.Result<ContractProducDTO>
     * @author Xuhui Lin
     */
    Result<ContractProducDTO> getContractProductList(ContractModuleQueryCndDTO cndDTO);

    /** 合同模块-模块列表
     * @Param: contractNo 合同号
     * @Param: moduleName 模块名称
     * @Param: pageSize 每页条数
     * @return com.bsoft.common.result.Result<ContractModuleDTO>
     * @author Xuhui Lin
     */
    List<ContractModuleDTO> getContractModuleList(ContractModuleQueryCndDTO cndDTO);

    /** 合同模块-保存关联
     * @Param: saves 待保存的数据
     * @Param: deletes 待删除的数据
     * @Param: contractId 合同编号
     * @Param: personId 工号
     * @author Xuhui Lin
     */
    void saveContractProductModuleRelation(List<ContractModuleProductDTO> saves,List<ContractModuleProductDTO> deletes,String contractId,String personId);

    /** 合同模块-提交关联
     * @Param: saves 待保存的数据
     * @Param: deletes 待删除的数据
     * @Param: contractId 合同编号
     * @Param: personId 工号
     * @Param: completeFlag 合同金额方式
     * @author Xuhui Lin
     */
    Integer commitContractProductModuleRelation(List<ContractModuleProductDTO> saves,List<ContractModuleProductDTO> deletes,String contractId,String personId, Integer completeFlag);

    /** 销售 合同模块-保存关联
     * @Param: salesContractQueryCndDTO 条件
     * @author Xuhui Lin
     */
    Result<SalesContractDTO> getContractList(SalesContractQueryCndDTO salesContractQueryCndDTO);

    /** 销售 获取合同模块数量
     * @Param:
     * @author Xuhui Lin
     */
    List<Integer> getSalesContractModuleCount(SalesContractQueryCndDTO cndDTO);

    /** 销售 获取合同模块列表
     * @Param: contractId 合同编号
     * @author Xuhui Lin
     */
    List<SalesContractModuleDTO> getSalesContractModuleList(SalesContractQueryCndDTO cndDTO);

    /** 审核 获取合同销售区域
     * @Param: cndDTO
     * @author Xuhui Lin
     */
    List<SalesContractAreaDTO> getSalesContractAreaList(SalesContractAuditCndDTO cndDTO);

    /** 审核 获取合同销售审核列表
     * @Param: cndDTO
     * @author Xuhui Lin
     */
    Result<SalesContractDTO> getSalesContractAuditList(SalesContractAuditCndDTO cndDTO);

    /** 审核合同
     * @Param: contractId 合同编号
     * @author Xuhui Lin
     */
    void auditSalesContract(String contractId);

    /** 退回合同
     * @Param: contractId 合同编号
     * @Param: backReason 退回原因
     * @author Xuhui Lin
     */
    void returnSalesContract(String contractId, String backReason);

    /** 合同核对列表
     * @Param: cndDTO
     * @author Xuhui Lin
     */
    Result<SalesContractCheckDTO> getSalesCheckContractList(SalesContractCheckQueryCndDTO cndDTO);

    /** 合同模块核对列表
     * @Param: pageNo
     * @Param: pageSize
     * @Param: contractId 合同编号
     * @author Xuhui Lin
     */
    Result<SalesContractModuleCheckDTO> getSalesCheckContractModuleList(Integer pageNo, Integer pageSize, String contractId);

    /** 合同核对
     * @Param: contractId 合同编号
     * @Param: personId 工号
     * @author Xuhui Lin
     */
    void checkSalesContract(String contractId, String personId);

    /** 未核对的合同数量
     * @Param: personId 工号
     * @Param: allPermission 全部权限
     * @author Xuhui Lin
     */
    Integer getUncheckedCount(String personId, Boolean allPermission);
}
