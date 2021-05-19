package com.bsoft.dept.service;

import com.bsoft.dept.dto.DeptDTO;
import com.bsoft.dept.dto.DeptSelectDTO;

import java.util.List;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.dept.service
 * @Author: Xuhui Lin
 * @CreateTime: 2020-02-21
 * @Description:
 */
public interface DeptService {

    /**
     * 功能描述 部门选择(查找)
     * @param logout 注销标志 ''为全部,0为未注销，1为注销
     * @return List<com.bsoft.dept.dto.DeptSelectDTO>
     * @author Xuhui Lin
     * @date 2020/2/7
     */
    List<DeptSelectDTO> findDeptSelectList(String logout);

    /**
     * 获取部门选择器组件数据
     * @param logout 注销标志 ''全部，0未注销，1注销
     * @param deptType 部门类别 ''全部，1行政职能，2大区，3事业部，4其他
     * @return java.util.List<com.bsoft.dept.dto.DeptSelectDTO;>
     */
    List<DeptSelectDTO> listDeptForSelect(String logout, String deptType);

    /**
     * 根据人员权限内获取部门选择器组件数据
     * @param logout 注销标志 ''全部，0未注销，1注销，2含注销且部门内有人员的,3 根据人员权限
     * @param deptType 部门类别 ''全部，1行政职能，2大区，3事业部，4其他
     * @param personId 人员工号
     * @return
     */
    List<DeptSelectDTO> listDeptForSelectWithPerson(String logout, String deptType,String personId);

    List<DeptDTO> getValidDept();

    List<DeptDTO> getDeptWithPerson();

    List<DeptDTO> getAllDept();

    /**
     * 根据部门名称获取部门列表
     * @param nameList 名称列表
     * @return
     */
    List<DeptDTO> getDeptList(List<String> nameList);

    /**
     * 获取所有有效的一级的一级部门
     * @return
     */
    List<DeptSelectDTO> getAllValidParentDeptList();

    /**
     * 获取指定一级大区的二级部门
     * @return
     */
    List<DeptDTO> getValidDeptListWithRegionDeptIds(List<String> deptIds);

    /**
     * 获取所有一级大区及其子部门
     * @return
     */
    List<DeptDTO> getAllValidRegionAndSubDeptList();

}
