package com.bsoft.dept.manager;

import com.bsoft.dept.entity.primary.CloudschoolDeptSyncDO;
import com.bsoft.dept.entity.primary.DeptDO;
import com.bsoft.dept.entity.primary.DeptSelectDO;
import com.bsoft.dept.entity.primary.DeptWithPersonDO;

import java.util.List;
import java.util.Map;

public interface DeptManager {
    List<DeptDO> getDeptList();
    DeptDO getDept(String deptId);
    List<DeptDO> getAllDept();
    Map<String,String> getDicDept();
    Map<String,String> getAllDicDept();
    List<DeptSelectDO> getDeptSelectList(String logout);
    List<DeptSelectDO> getDeptSelectList(String logout, String deptType);
    List<DeptSelectDO> getDeptSelectListWithPerson(String logout, String deptType,String personId);
    Boolean isFirstManager(String personId);
    Boolean isDepManager(String personId);
    Boolean isHr(String personId);
    List<DeptDO> getValidDept();
    List<DeptWithPersonDO> getDeptWithPerson();
    Boolean isLeader(String personId);

    /**
     * 根据部门名称获取部门列表
     * @param deptNameList
     * @return
     */
    List<DeptDO> getDeptList(List<String> deptNameList);

    /**
     * 根据一级部门，获取下级部门
     * @param parentDept 一级部门编码
     * @param logout 注销标志
     * @return
     */
    List<DeptDO> getChildDeptList(String parentDept,Integer logout);
    /**
     * 查询部门所有未注销的数据（同步）
     */
    List<CloudschoolDeptSyncDO> findByLogout(Integer type);

    /**
     * 查询所有有效的一级大区
     * @return
     */
    List<DeptSelectDO> getAllValidParentDeptList();

    /**
     * 查询指定一级大区下的有效的二级部门
     * @return
     */
    List<DeptDO> getValidDeptListWithRegionDeptIds(List<String> deptIds);

    /**
     * 查询所有有效的一级大区及其二级部门
     * @return
     */
    List<DeptDO> getAllValidRegionAndSubDeptList();
}

