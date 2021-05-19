package com.bsoft.project.service;

import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.result.Result;
import com.bsoft.project.dto.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/*
 * @author  hy
 * @date  2020/3/27 9:42
 * @description
 */
public interface ProjectWordService {

    /**
     * @Description: 获取项目文档列表
     * @param page
     * @param size
     * @param contractNo 合同号
     * @param projectId 项目id
     */
    public Result<ProjectWordViewDTO> getProjectWordViewList(Integer page, Integer size, String contractNo, String projectId,Integer stage);

    /**
     * @Description: 获取文档记录
     * @param page 页数
     * @param size 大小
     * @param id 文档记录Id
     * @param milepostId 里程碑Id
     */
    public Result<ProjectWordRecordViewDTO> getProjectWordDetails(Integer page, Integer size, Integer id, Integer milepostId);

    public Result<ProjectStandardWordDTO> getProjectStandardWordList(ProjectStandardWordQueryCndDTO projectStandardWordQueryCndDTO);
    /**
     * @Description: 文档上传
     * @param uploadDTO 上传DTO
     * @param fileYear 年份
     */
    public void projectWordUpload(ProjectWordBaseUploadDTO uploadDTO, String fileYear);

    /**
     * @Description: 文档列表
     * @param fileYear 年份
     * @param id
     */
    public ProjectWordDetailDTO findDetailById(String fileYear, Integer id);

    /**
     * @Description: 删除文档
     * @param id 文档记录id
     * @param detailId 文档详情id
     * @param fileYear 年份
     */
    public void deleteFile(Integer id,Integer detailId, String fileYear);

    /**
     * @Description: 获取模板文档
     * @param id 模板文档id
     */
    public ReferenceDocumentDTO getReferenceDocument(Integer id);

    /**
     * @Description: 获取项目日志文档上传格式
     */
    List<PublicDicDTO> getProjectLogFileUploadType();

    /**
     * @Description: 获取阶段文档个数
     * @param contractNo 合同编号
     */
    List<Integer> getStageDocumentCount(String contractNo)

    ;/**
     * @Description: 获取项目责任书-里程碑设置阶段文档个数
     */
    List<Integer> getMilepostStageDocumentCount();

    /**
     * @Description: 获取阶段文档
     * @param contractNo
     */
    List<Map<String,Object>> getDocumentDisplayList(String contractNo,String projectId);

    /**
     * @Description: 计划维护-获取阶段文档数量
     * @param contractNo
     */
    List<Map<String,Object>> getDocumentDisplayListWithPlan(String contractNo,String projectId,Integer milepostId);

    /**
     * @Description: 获取项目责任书-里程碑、文档列表数据
     * @param contractNo
     * @param dutyId 责任书Id
     */
    List<Map<String,Object>> getMilepostDocumentDisplayList(String contractNo, Integer dutyId);


    /**
     * @param contractId   合同编号htbh
     * @param inputContent 文本搜索
     * @param isRequired   是否必须
     * @author zy
     * @description 项目进度——获取合同标准文档展示列表（检测文档信息表wdxx是否完整，否则补全）
     */
    List<ContractWordViewDTO> getContractWordViewDisplayList(String contractId, String inputContent, Integer isRequired);

    /**
     * @author zy
     * @description 项目进度——获取项目文档列表
     * @param contractId 合同编号htbh
     * @param inputContent 文本搜索
     * @param isRequired 是否必须
     */
    List<ContractWordViewDTO> getContractWordViewList(String contractId, String inputContent, Integer isRequired);

    /**
     * @author zy
     * @description 项目进度——根据文档信息ID获取文档明细列表
     * @param contractId 合同编号htbh
     * @param standardWordId 标准文档ID
     */
    List<ContractWordDetailViewDTO> getContractWordDetailViewList(String contractId, Integer standardWordId);

    /**
     * @author zy
     * @description 项目进度——获取项目文档（带水印）
     * @param fileYear 年份
     * @param dbDetailId 文档详情ID
     * @param personId 下载人
     */
    ProjectWordDetailDTO getProjectWordDBDetailDO(String fileYear, Integer dbDetailId, String personId);

    /**
     * @author zy
     * @description 项目进度——获取标准文档
     * @param contractId 合同编号
     * @param projectId 项目ID
     * @param standardWordId 标准文档ID
     */
    ProjectWordViewDTO getProjectWordView(String contractId, String projectId, Integer standardWordId);

    /**
     * @author zy
     * @description 项目进度——获取项目文档上传情况统计列表
     * @param cnd 模糊查询参数
     */
    Result<ProjectWordCountViewDTO> getProjectWordCountViewList(ProjectWordCountViewQueryCndDTO cnd);
}
