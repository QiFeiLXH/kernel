package com.bsoft.cost.service;

import com.bsoft.common.result.Result;
import com.bsoft.cost.dto.AccountCaliberDTO;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/4 9:59
 * @Description
 */
public interface AccountCaliberService {
    /**
     * 获取部门核算口径归属
     * @param pageNo 分页参数
     * @param pageSize 分页参数
     * @param year 年份
     * @param accountCaliber 核算口径归属
     * @param deptId 部门id
     * @param deptType 部门类别
     * @return
     */
    Result<AccountCaliberDTO> getDpetAccountCaliberList(Integer pageNo,Integer pageSize,Integer year,Integer accountCaliber,String deptId,Integer deptType);

    /**
     * 生成核算口径归属部门
     * @param year 年份
     * @return
     */
    void saveYearlyDeptAccountCaliber(Integer year);

    /**
     * 保存部门核算口径归属
     * @param caliberSaves 待保存的部门核算口径
     * @param caliberDeletes 待删除的部门核算口径
     * @param deptId 部门id
     * @param year 年份
     * @return
     */
    void saveDeptAccountCaliber(List<Integer> caliberSaves, List<Integer> caliberDeletes, String deptId, Integer year);

    /**
     * 获取部门的核算口径归属
     * @param deptId 部门ID
     * @param year 年份
     * @return
     */
    List<AccountCaliberDTO> getAccountCaliberByDeptId(String deptId,Integer year);
}
