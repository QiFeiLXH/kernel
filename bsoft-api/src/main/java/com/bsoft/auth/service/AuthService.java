package com.bsoft.auth.service;

import com.bsoft.auth.dto.AuthorityPersonDTO;
import com.bsoft.auth.dto.AuthorityQueryCndDTO;
import com.bsoft.common.result.Result;

import java.util.List;
import java.util.Map;

public interface AuthService {

    /**
     * 获取office系统菜单按钮权限
     * @param userId
     * @return
     */
//    public List<Map> getOfficeAuth(String userId);

    /**
     * 获取不用系统的菜单按钮权限
     * @param userId
     * @param system
     * @return
     */
//    public List<Map> getOfficeAuthBySystem(String userId,Integer system);

    /**
     * 更新角色的菜单权限及菜单按钮权限
     * @param roleId 角色ID
     * @param menusId 有权限的菜单id
     * @param authInfo 菜单的按钮权限信息
     * @param system 系统ID 2office,3 administration
     * @return
     */
    public boolean saveOfficeAuth(Integer roleId,List<Integer> menusId,List<Map> authInfo,Integer system);

    /**
     * 根据工号，类型查询员工权限部门
     * @param personId 工号
     * @param flag 1 部门权限，2 工程区域
     * @return
     */
    List<String> getPersonalAuthorityDepts(String personId, Integer flag);

    /**
     * 根据工号，保存、删除员工权限部门
     * @param personId 工号
     * @param flag 1 部门权限 2工程区域权限
     * @param needSaves 待保存的部门ids
     * @param needDeletes 待删除的部门ids
     * @return
     */
    void saveAuthorityDept(String personId, Integer flag, List<String> needSaves, List<String> needDeletes);


    /**
     * 查询指定权限的员工列表
     * @param menuAuthDTOS 菜单、按钮权限列表
     * @param pageNo 页码
     * @param pageSize 单页条数
     * @return
     */
    Result<AuthorityPersonDTO> getPermissionalPersonList(List<AuthorityQueryCndDTO> menuAuthDTOS, Integer pageNo, Integer pageSize);

    /** 检查判断员工是否拥有全部权限
     * @Param: personId 员工工号
     * @Param: menuId 菜单id
     * @Param: key 全部权限编号
     * @return boolean true 有全部权限  false 无全部权限
     * @author Xuhui Lin
     */
    boolean checkAllPermission(String personId, Integer menuId, Integer key);

    /** 检查判断员工是否拥有非公用菜单权限
     * @Param: personId 员工工号
     * @Param: menuId 菜单id
     * @return boolean true 有权限  false 无权限
     * @author Xuhui Lin
     */
    boolean checkPrivateMenuPermission(String personId, Integer menuId);
}
