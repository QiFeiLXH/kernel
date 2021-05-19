package com.bsoft.cost.manager;

import com.bsoft.cost.entity.primary.CostTypeDeptViewDO;
import com.bsoft.cost.entity.primary.DeptCostTypeViewDO;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/3/3 16:03
 * @Description: 部门费用类别
 */
public interface DeptCostTypeManager {

    List<CostTypeDeptViewDO> findDeptList(Integer year, Integer flag, Integer bmlb, Integer zxbz, String deptId);

    List<CostTypeDeptViewDO> findDeptListByDept(Integer year,Integer flag, Integer bmlb, Integer zxbz,String parentBm);

    DeptCostTypeViewDO getDeptCostType(Integer year, String deptNo);

    void saveCostType(DeptCostTypeViewDO viewDO);

    boolean checkAnnualGener(Integer year);

    void annualGener(Integer year,String personId);
}
