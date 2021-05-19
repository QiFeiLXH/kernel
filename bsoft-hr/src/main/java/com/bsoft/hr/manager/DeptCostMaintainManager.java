package com.bsoft.hr.manager;

import com.bsoft.hr.condition.ClockInModeQueryCnd;
import com.bsoft.hr.condition.DeptMaintainInfoQueryCnd;
import com.bsoft.hr.dto.DeptCostMaintainDTO;
import com.bsoft.hr.dto.DeptMaintainInfoQueryCndDTO;
import com.bsoft.hr.entity.primary.ClockInModeDeptInfoDO;
import com.bsoft.hr.entity.primary.DeptCostMaintainDO;
import com.bsoft.hr.entity.primary.PersonDeptMaintainViewDO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DeptCostMaintainManager {
    /**
     * 获取部门集合
     */
    List<String> getDeptList();

    /**
     * 按部门更新财物类别信息(更新同时删除该部门下所有岗位的维护信息)
     */
    boolean updateDeptCost(String userId,DeptCostMaintainDO deptCostMaintainDO);

    /**
     * 按照岗位更新财物类别信息
     */
    List<String> updatePostCost(String userId,List<DeptCostMaintainDO> deptCostMaintainDO);

    /**
     * 查询部门下所有的岗位财务类别信息
     */
    List<DeptCostMaintainDTO> selectWithDept(String Dept);

    /**
     * 查询按部门更新财务类别的信息
     */
    DeptCostMaintainDO getDeptFinancialType(String Dept);


    /**
     * 获取部门是否维护信息
     */
    Page<PersonDeptMaintainViewDO> listDeptInfoWithPage(DeptMaintainInfoQueryCnd queryCnd);
    /**
     * 获取子部门维护信息
     */
    List<PersonDeptMaintainViewDO> listChildDeptInfo(List<PersonDeptMaintainViewDO> parentList);


    /**
     * 修改部门维护信息
     * @param
     * @return
     */
    void updateDeptInfoWithPage(String dept,Integer personTypeFlag);



    /**
     * 获取表里所有维护信息
     * @param
     * @return
     */
    List<DeptCostMaintainDO>  getFindAll();
}
