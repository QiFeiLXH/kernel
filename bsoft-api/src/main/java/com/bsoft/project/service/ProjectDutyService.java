package com.bsoft.project.service;

import com.bsoft.common.result.Result;
import com.bsoft.project.dto.*;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/12 9:34
 * @Description
 */
public interface ProjectDutyService {
    /** 项目责任书维护列表
      * @Param: cnd 责任书查找条件
      * @return com.bsoft.common.result.Result<ProjectDutyViewDTO>
      * @author Xuhui Lin
      */
    Result<ProjectDutyViewDTO> getProjectDutyMaintainList(ProjectDutyQueryCndDTO cnd);

    /** 项目责任书管理列表
     * @Param: cnd 责任书查找条件
     * @return com.bsoft.common.result.Result<ProjectDutyAuditViewDTO>
     * @author Xuhui Lin
     */
    Result<ProjectDutyAuditViewDTO> getProjectDutyAuditList(ProjectDutyQueryCndDTO cnd);

    /**
     * 门户平台-项目责任书获取待审核数量
     * @return
     */
    Integer getProjectDutyAuditCount(String userId);

    /** 项目责任书-客户选择
     * @Param: pageSize 页量
     * @Param: pageNo 页码
     * @Param: userId 登录人
     * @return com.bsoft.common.result.Result<ProjectDutyCustomerAndProjectSelectViewDTO>
     * @author Xuhui Lin
     */
    Result<ProjectDutyCustomerAndProjectSelectViewDTO> getProjectDutyCustomerSelectList(Integer pageNo, Integer pageSize, String userId);

    /** 项目责任书-项目范围
     * @Param: pageSize 页量
     * @Param: pageNo 页码
     * @Param: dutyId 责任书id
     * @return List<ProjectDutyRegionViewDTO>
     * @author Xuhui Lin
     */
    List<ProjectDutyRegionViewDTO> getProjectDutyRegionList(Integer dutyId);

    /** 项目责任书-项目选择
     * @Param: userId 登录人
     * @Param: customerId 客户id
     * @Param: pageSize 页量
     * @Param: pageNo 页码
     * @return com.bsoft.common.result.Result<ProjectDutyCustomerAndProjectSelectViewDTO>
     * @author Xuhui Lin
     */
    Result<ProjectDutyCustomerAndProjectSelectViewDTO> getProjectDutyProjectSelectList(String userId, String customerId, Integer pageNo, Integer pageSize);

    /** 项目责任书-责任书编号
     * @Param: customerId 客户id
     * @Param: year 年度
     * @return
     * @author Xuhui Lin
     */
    String getProjectDutyNameNo(String customerId, String year);

    /** 项目责任书-删除项目责任书
     * @Param: dutyId 责任书id
     * @return
     * @author Xuhui Lin
     */
    void deleteProjectDuty(Integer dutyId);

    /** 项目责任书-里程碑
     * @Param: contractNo 合同编号
     * @return
     * @author hy
     */
    List<ProjectDutyMilepostDTO> getProjectDutyMileposts(String contractNo);

    /** 计划维护-里程碑选择
     * @Param: contractNo 合同编号
     * @return
     * @author hy
     */
    List<ProjectDutyMilepostDTO> getDutyMilepostsWithPlan(String contractNo);

    /** 项目责任书-里程碑
     * @Param: contractNo 合同编号
     * @Param: dutyId 责任书id
     * @return
     * @author hy
     */
    List<ProjectDutyMilepostDTO> getProjectDutyMileposts(String contractNo, Integer dutyId);

    /**
     * 项目责任书-里程碑
     * @param id 责任书里程碑id
     * @return
     */
    List<ProjectDutyMilepostDTO> getProjectDutyMileposts(Integer id);

    /** 项目责任书-里程碑
     * @Param: contractNo 合同编号
     * @Param: dutyId 责任书id
     * @Param: pageSize 页量
     * @Param: pageNo 页码
     * @return
     * @author hy
     */
    Result<ProjectDutyMilepostViewDTO> getProjectDutyMilepostList(String contractNo, Integer dutyId, Integer pageNo, Integer pageSize);

    /**
     * @Param: projectDuty 需要保存的项目责任书数据
     * @Param: regions 需要保存的项目范围
     * @Param: deleteRegions 需要删除的项目范围
     * @Param: userId 登录人员
     * @Param: contractNo 删除范围的合同编号
     * @return 责任书id
     * @author Xuhui Lin
     */
    Integer saveProjectDutyAndRegion(ProjectDutyDTO projectDuty, List<ProjectDutyRegionDTO> regions, List<Integer> deleteRegions, String userId, List<String> contractNo);


    /**
     * 项目责任书审核
     * @param auditSaveDOS 审核DO的集合
     */
    void auditProjectDutyList(List<ProjectDutyAuditSaveDTO> auditSaveDOS,String userId);

    /**
     * @Param: projectDutyMilepostDTOS 需要保存的里程碑
     * @Param: deletes 需要删除的里程碑
     * @return void
     * @author Xuhui Lin
     */
    void saveProjectDutyMilepost(List<ProjectDutyMilepostDTO> projectDutyMilepostDTOS, List<Integer> deletes);

    /**
     * @Param: dutyId 责任书id
     * @return List<ProjectDutyPaymentViewDTO>
     * @author Xuhui Lin
     */
    List<ProjectDutyPaymentViewDTO> getProjectDutyPayment(Integer dutyId);

    /**
     * @Param: saves 新增、修改计划回款
     * @Param: deletes 删除计划回款
     * @return void
     * @author Xuhui Lin
     */
    void saveProjectDutyPayment(List<ProjectDutyPaymentDTO> saves, List<Integer> deletes);

    /** 项目责任书管理列表-导出审核列表
     * @Param: cnd 查找条件
     * @return List<ProjectDutyAuditViewDTO>
     * @author Xuhui Lin
     */
    List<ProjectDutyAuditViewDTO> getAllProjectDutyAuditList(ProjectDutyQueryCndDTO cnd);

    /** 项目责任书
     * @Param: cnd 查找条件
     * @return ProjectDutyViewDTO
     * @author Xuhui Lin
     */
    ProjectDutyViewDTO getOneProjectDutyView(Integer dutyId);
}
