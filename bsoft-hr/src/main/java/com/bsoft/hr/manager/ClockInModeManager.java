package com.bsoft.hr.manager;

import com.bsoft.hr.condition.ClockInModeQueryCnd;
import com.bsoft.hr.entity.primary.ClockInModeDeptInfoDO;
import com.bsoft.hr.entity.primary.ClockInModeDeptSaveDO;
import com.bsoft.hr.entity.primary.ClockInModePersonalInfoDO;
import com.bsoft.hr.entity.primary.ClockInModePersonalSaveDO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/8/30
 * @description 打卡方式维护
 */
public interface ClockInModeManager {
    /**
     * 获取部门打卡方式信息
     */
    Page<ClockInModeDeptInfoDO> listDeptInfoWithPage(ClockInModeQueryCnd queryCnd);
    /**
     * 获取子部门打卡方式信息
     */
    List<ClockInModeDeptInfoDO> listChildDeptInfo(List<ClockInModeDeptInfoDO> parentList);
    /**
     * 获取个人打卡方式信息
     */
    Page<ClockInModePersonalInfoDO> listPersonalInfoWithPage(ClockInModeQueryCnd queryCnd);
    /**
     * 设置部门打卡方式
     */
    void setDept(List<ClockInModeDeptSaveDO> deptSaveDOList, List<ClockInModePersonalSaveDO> personalSaveDOList);
    /**
     * 设置个人打卡方式
     */
    void setPersonal(List<ClockInModePersonalSaveDO> personalSaveDOList);
    /**
     *  处理需要修改的部门打卡方式
     */
    List<ClockInModeDeptSaveDO> processDeptSaveDOList(List<ClockInModeDeptInfoDO> deptInfoDOList);
    /**
     * 处理需要修改的人员打卡方式
     */
    List<ClockInModePersonalSaveDO> processPersonalSaveDOList(List<ClockInModePersonalInfoDO> deptInfoDOList);
    /**
     * 处理设置部门打卡方式时需要处理的人员打卡方式
     */
    List<ClockInModePersonalSaveDO> processNeedChangePersonList(List<ClockInModeDeptInfoDO> deptInfoDOList);

    /**
     * 查询所有
     */
    List<ClockInModeDeptInfoDO> findAll();
}
