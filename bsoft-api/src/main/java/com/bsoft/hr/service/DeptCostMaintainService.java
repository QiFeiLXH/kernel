package com.bsoft.hr.service;

import com.bsoft.common.result.Result;
import com.bsoft.hr.dto.*;

import java.util.List;

public interface DeptCostMaintainService {
    /**
     *   获取部门列表
     */
    List<String>  getDeptList();

    /**
     * 按部门更新财物类别信息(更新同时删除该部门下所有岗位的维护信息)
     */
    boolean updateDeptCost(String userId,DeptCostMaintainDTO deptCostMaintainDTO);

    /**
     * 按照岗位更新财物类别信息
     */
    List<String> updatePostCost(String userId,List<DeptCostMaintainDTO> deptCostMaintainDTOListDTO);

    /**
     * 按岗位查询部门下所有的岗位财务类别信息
     */
    List<DeptCostMaintainDTO> selectWithDept(String Dept);

    /**
     * 查询按部门更新财务类别的信息
     */
    DeptCostMaintainDTO getDeptFinancialType(String Dept);

    /**
     * 获取部门维护信息
     * @param queryCndDTO
     * @return
     */
    Result<DeptMaintainInfoDTO> listDeptInfoWithPage(String userId, DeptMaintainInfoQueryCndDTO queryCndDTO);


    /**
     * 修改部门维护信息
     * @param queryCndDTO
     * @return
     */
    void updateDeptInfoWithPage(String userId, List<DeptMaintainInfoQueryCndDTO> queryCndDTO);



}
