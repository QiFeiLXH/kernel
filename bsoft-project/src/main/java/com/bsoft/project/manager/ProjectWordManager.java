package com.bsoft.project.manager;

import com.bsoft.common.result.Result;
import com.bsoft.project.condition.ProjectStandardWordQueryCnd;
import com.bsoft.project.condition.ProjectWordCountViewQueryCnd;
import com.bsoft.project.dto.ProjectWordBaseUploadDTO;
import com.bsoft.project.dto.ProjectWordViewDTO;
import com.bsoft.project.entity.primary.*;
import com.bsoft.project.entity.second.ProjectWordDetailDO;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;
import java.util.Map;

/*
 * @author  hy
 * @date  2020/3/23 15:22
 * @description
 */
public interface ProjectWordManager {
    Page<ProjectWordViewDO> getProjectWordViewList(Integer page, Integer size, String contractNo, String projectId,Integer stage);
    Page<ProjectWordRecordViewDO> getProjectWordDetails(Integer page, Integer size, Integer id, Integer milepostId);
    void deleteProjectWord(Integer id,String wordAge,Integer detailId);
    Page<ProjectStandardWordDO> getProjectStandardWordList(ProjectStandardWordQueryCnd cnds);
    ReferenceDocumentDO getReferenceDocument(Integer id);

    /**
     * 根据年份及ID获取文档
     * @param wordAge 年份
     * @param id 文档数据库记录ID
     * @return
     */
    ProjectWordDetailDO findById(String wordAge, Integer id);
    void saveOrUpdateWord(ProjectWordBaseUploadDTO uploadDTO, String wordAge);

    List<Map<String,Object>> getDocumentDisplayList(String contractNo,String projectId);

    List<Map<String,Object>> getDocumentDisplayListWithPlan(String contractNo,String projectId,Integer milepostId);

    List<Integer> countStageDocumentByContractNo(String contractNo);

    List<Map<String, Object>> getMilepostDocumentDisplayList(String contractNo, Integer dutyId);

    List<Integer> getMilepostStageDocumentCount();

    /**
     * 获取合同标准文档展示列表（检测文档信息表wdxx是否完整，否则补全）
     * @param contractId 合同编号htbh
     * @param inputContent 文本搜索
     * @param isRequired 是否必须
     */
    List<ContractWordViewDO> getContractWordViewDisplayList(String contractId, String inputContent, Integer isRequired);

    /**
     * 获取项目文档列表
     * @param contractId 合同编号htbh
     * @param inputContent 文本搜索
     * @param isRequired 是否必须
     */
    List<ContractWordViewDO> getContractWordViewList(String contractId, String inputContent, Integer isRequired);

    /**
     * 根据文档信息ID获取文档明细列表
     * @param contractId 合同编号htbh
     */
    List<ContractWordDetailViewDO> getContractWordDetailViewList(String contractId, Integer standardWordId);

    /**
     * 根据文档信息ID获取文档明细列表（分页）
     * @param contractId 合同编号htbh
     */
    Result<ContractWordDetailViewDO> getContractWordDetailViewList(String contractId, Integer standardWordId, Integer pageNo, Integer pageSize);


    /**
    * @author zy
    * @description 获取项目文档（带水印）
    * @param fileYear 年份
    * @param dbDetailId 文档详情ID
    * @param personId 下载人
    */
    ProjectWordDetailDO getProjectWordDBDetailDO(String fileYear, Integer dbDetailId, String personId);


    /**
     * 根据文档信息ID获取文档明细列表
     * @param wordInfoId 文档信息ID
     */
    List<ProjectWordRecordViewDO> getProjectWordDetailViewList(Integer wordInfoId);

    /**
     * @author zy
     * @description 获取标准文档
     * @param contractId 合同编号
     * @param projectId 项目ID
     * @param standardWordId 标准文档ID
     */
    ProjectWordViewDO getProjectWordView(String contractId, String projectId, Integer standardWordId);

    /**
     * 获取项目文档上传情况统计列表
     * @param cnd 模糊查询参数
     */
    Result<ProjectWordCountViewDO> getProjectWordCountViewList(ProjectWordCountViewQueryCnd cnd);

}
