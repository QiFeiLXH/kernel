package com.bsoft.project.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.entity.primary.PublicDicDO;
import com.bsoft.common.manager.PublicDicManager;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.project.condition.ProjectStandardWordQueryCnd;
import com.bsoft.project.condition.ProjectWordCountViewQueryCnd;
import com.bsoft.project.dto.*;
import com.bsoft.project.entity.primary.*;
import com.bsoft.project.entity.second.ProjectWordDetailDO;
import com.bsoft.project.manager.ProjectWordManager;
import com.bsoft.project.service.ProjectWordService;

import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;
import java.util.Map;

/*
 * @author  hy
 * @date  2020/3/27 9:43
 * @description
 */
@Service(protocol = {"hessian","dubbo"})
public class ProjectWordServiceImpl implements ProjectWordService {
    private static final Logger logger = LoggerFactory.getLogger(ProjectWordServiceImpl.class);
    @Autowired
    private ProjectWordManager projectWordManager;
    @Autowired
    private IGenerator generatorUtil;
    @Autowired
    private PublicDicManager publicDicManager;

    @Override
    public Result<ProjectWordViewDTO> getProjectWordViewList(Integer page, Integer size, String contractNo, String projectId,Integer stage) {
        Page<ProjectWordViewDO> result = projectWordManager.getProjectWordViewList(page,size,contractNo,projectId,stage);
        return ResultUtils.parseResult(result,ProjectWordViewDTO.class);
    }

    @Override
    public Result<ProjectWordRecordViewDTO> getProjectWordDetails(Integer page, Integer size, Integer id, Integer milepostId) {
        Page<ProjectWordRecordViewDO> result = projectWordManager.getProjectWordDetails(page,size, id, milepostId);
        return ResultUtils.parseResult(result, ProjectWordRecordViewDTO.class);
    }

    @Override
    public Result<ProjectStandardWordDTO> getProjectStandardWordList(ProjectStandardWordQueryCndDTO projectStandardWordQueryCndDTO) {
        ProjectStandardWordQueryCnd cnds = generatorUtil.convert(projectStandardWordQueryCndDTO,ProjectStandardWordQueryCnd.class);
        Page<ProjectStandardWordDO> result = projectWordManager.getProjectStandardWordList(cnds);
        return ResultUtils.parseResult(result, ProjectStandardWordDTO.class);
    }

    @Override
    public void projectWordUpload(ProjectWordBaseUploadDTO uploadDTO, String fileYear) {
        projectWordManager.saveOrUpdateWord(uploadDTO,fileYear);
    }

    @Override
    public ProjectWordDetailDTO findDetailById(String wordAge, Integer detailId) {
        ProjectWordDetailDO projectWordDetailDO = projectWordManager.findById(wordAge,detailId);
        return generatorUtil.convert(projectWordDetailDO, ProjectWordDetailDTO.class);
    }

    @Override
    public void deleteFile(Integer id,Integer detailId, String wordAge) {
        projectWordManager.deleteProjectWord(id,wordAge,detailId);
    }

    @Override
    public ReferenceDocumentDTO getReferenceDocument(Integer id){
        ReferenceDocumentDO referenceDocumentDO = projectWordManager.getReferenceDocument(id);
        return generatorUtil.convert(referenceDocumentDO, ReferenceDocumentDTO.class);
    }

    @Override
    public List<PublicDicDTO> getProjectLogFileUploadType() {
        List<PublicDicDO> fileTypes = publicDicManager.getPublicDic(2002); //获取上传格式
        return generatorUtil.convert(fileTypes, PublicDicDTO.class);
    }

    @Override
    public List<Integer> getStageDocumentCount(String contractNo) {
        List<Integer> count = projectWordManager.countStageDocumentByContractNo(contractNo);
        return count;
    }

    @Override
    public List<Integer> getMilepostStageDocumentCount() {
        List<Integer> count = projectWordManager.getMilepostStageDocumentCount();
        return count;
    }

    @Override
    public List<Map<String, Object>> getDocumentDisplayList(String contractNo,String projectId) {
        List<Map<String,Object>> result = projectWordManager.getDocumentDisplayList(contractNo,projectId);
        return result;
    }

    @Override
    public List<Map<String, Object>> getDocumentDisplayListWithPlan(String contractNo,String projectId, Integer milepostId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<Map<String,Object>> result = projectWordManager.getDocumentDisplayListWithPlan(contractNo,projectId,milepostId);
        long times = timeConsumer.end();
        logger.info("获取计划维护-里程碑：{}需上传文档信息:{}",new Object[]{milepostId,times});
        return result;
    }

    @Override
    public List<Map<String, Object>> getMilepostDocumentDisplayList(String contractNo, Integer dutyId) {
        List<Map<String,Object>> result = projectWordManager.getMilepostDocumentDisplayList(contractNo, dutyId);
        return result;
    }

    @Override
    public List<ContractWordViewDTO> getContractWordViewDisplayList(String contractId, String inputContent, Integer isRequired) {
        List<ContractWordViewDO> list = projectWordManager.getContractWordViewDisplayList(contractId, inputContent, isRequired);
        return generatorUtil.convert(list, ContractWordViewDTO.class);
    }

    @Override
    public List<ContractWordViewDTO> getContractWordViewList(String contractId, String inputContent, Integer isRequired) {
        List<ContractWordViewDO> list = projectWordManager.getContractWordViewList(contractId, inputContent, isRequired);
        return generatorUtil.convert(list, ContractWordViewDTO.class);
    }

    @Override
    public List<ContractWordDetailViewDTO> getContractWordDetailViewList(String contractId, Integer standardWordId) {
        List<ContractWordDetailViewDO> list = projectWordManager.getContractWordDetailViewList(contractId, standardWordId);
        return generatorUtil.convert(list, ContractWordDetailViewDTO.class);
    }

    @Override
    public ProjectWordDetailDTO getProjectWordDBDetailDO(String fileYear, Integer dbDetailId, String personId) {
        ProjectWordDetailDO projectWordDBDetailDO = projectWordManager.getProjectWordDBDetailDO(fileYear, dbDetailId, personId);
        return generatorUtil.convert(projectWordDBDetailDO, ProjectWordDetailDTO.class);
    }

    @Override
    public ProjectWordViewDTO getProjectWordView(String contractId, String projectId, Integer standardWordId) {
        ProjectWordViewDO projectWordView = projectWordManager.getProjectWordView(contractId, projectId, standardWordId);
        return generatorUtil.convert(projectWordView, ProjectWordViewDTO.class);
    }

    @Override
    public Result<ProjectWordCountViewDTO> getProjectWordCountViewList(ProjectWordCountViewQueryCndDTO cndDTO) {
        ProjectWordCountViewQueryCnd cnd = generatorUtil.convert(cndDTO, ProjectWordCountViewQueryCnd.class);
        Result<ProjectWordCountViewDO> result = projectWordManager.getProjectWordCountViewList(cnd);
        return generatorUtil.convert(result, ProjectWordCountViewDTO.class);
    }


}
