package com.bsoft.project.service;

import com.bsoft.common.result.Result;
import com.bsoft.project.dto.ProjectDTO;
import com.bsoft.project.dto.ProjectLookDTO;
import com.bsoft.project.dto.ProjectBaseDTO;
import com.bsoft.project.dto.ProjectRankDTO;

import java.util.Date;
import java.util.List;

public interface ProjectService {
    /**
     * @Description: 分页获取项目信息列表
     * @param page 页码，起始页从0开始
     * @param size 条数，一页显示的条数
     * @return Result<ProjectDTO> 项目对象列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    Result<ProjectDTO> getProjects(Integer page,Integer size);

    /**
     * @Description: 分页获取项目信息列表，一页默认25条
     * @param page 页码，起始页从0开始，一页默认25条数据
     * @return Result<ProjectDTO> 项目对象列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    Result<ProjectDTO> getProjects(Integer page);

    /**
     * @Description: 根据合同号、项目名称、拼音简码检索项目列表
     * @param page 页码，起始页从0开始，一页默认25条数据
     * @return Result<ProjectDTO> 项目对象列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    Result<ProjectDTO> searchProjects(String context,Integer page);

    /**
     * @Description: 根据合同号、项目名称、拼音简码检索项目列表
     * @param page 页码，起始页从0开始
     * @param size 条数，一页显示的条数
     * @return Result<ProjectDTO> 项目对象列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    Result<ProjectDTO> searchProjects(String context,Integer page,Integer size);

    /**
     * @Description: 根据合同号、项目名称、拼音简码检索项目列表
     * @param clueId 线索ID
     * @return Result<ProjectDTO> 项目对象列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    List<ProjectLookDTO> getClueProjects(Integer clueId);

    /**
     * @Description: 获取所有项目的项目ID
     * @return List<String>项目ID列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    List<String> getAllProjectId();

    ProjectLookDTO getProject(String projectId);

    ProjectBaseDTO getProjectBase(String projectId);

    List<ProjectRankDTO> getProjectRankWithPersonId(String personId, Date evalDate);

    /**
     * @Description: 获取合同号对应的项目
     * @return Result<ProjectDTO>项目列表
     */
    Result<ProjectDTO> getProjectsWithContractNo(Integer pageNo, Integer pageSize, String contractNo);

    /**
     * @Description: 获取项目查找列表
     * @param contractNo 合同号
     * @param inputContent 输入内容
     * @return Result<ProjectLookDTO>项目列表
     */
    Result<ProjectLookDTO> getProjectLookList(Integer pageNo, Integer pageSize, String contractNo, String inputContent);

    /**
     * 获取工程、服务，未完结的所有项目
     * @param pageNo
     * @param pageSize
     * @param inputContent
     * @return
     */
    Result<ProjectLookDTO> getAllProjectList(Integer pageNo, Integer pageSize, String inputContent);

    /**
     * 更新项目的项目经理
     * @param projectId 项目id
     * @param projectManager 项目经理
     * @return
     */
    void updateProjectManager(String projectId,Integer projectManager);

    /**
     * @author zy
     * @description 根据合同编号获取项目列表
     * @param contractId 合同编号htbh
     */
    List<ProjectDTO> getProjectList(String contractId);

    /**
     * @author zy
     * @description 更新同一合同下项目的终验日期
     * @param contractId 合同编号htbh
     * @param checkDate 终验日期
     */
    void updateProjectFinalCheckDate(String contractId, Date checkDate);

    /**
     * 更新项目更新标志
     * @param projectId 项目id
     * @param updateFlag 更新标志
     * @return
     */
    void updateProjectUpdateFlag(String projectId,Integer updateFlag);

    /**
     * 更新进度上报中的项目进度
     * @param projectId
     * @param progress
     * @param progressMonth
     */
    void updateProjectProgress(String projectId,Double progress,Date progressMonth);
}
