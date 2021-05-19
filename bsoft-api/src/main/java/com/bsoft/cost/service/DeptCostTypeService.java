package com.bsoft.cost.service;

import com.bsoft.cost.dto.CostTypeDeptViewDTO;
import com.bsoft.cost.dto.DeptCostTypeViewDTO;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/3/4 9:53
 * @Description:
 */
public interface DeptCostTypeService {
    List<CostTypeDeptViewDTO> findDeptList(Integer year,Integer flag, Integer bmlb, Integer zxbz,String deptId);

    DeptCostTypeViewDTO getDeptCostType(Integer year,String deptNo);

    void saveCostType(DeptCostTypeViewDTO dto);

    boolean checkAnnualGener(Integer year);

    void annualGener(Integer year,String personId);
}
