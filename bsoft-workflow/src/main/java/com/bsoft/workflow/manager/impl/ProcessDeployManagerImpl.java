package com.bsoft.workflow.manager.impl;

import com.bsoft.common.manager.FilerServerManager;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.workflow.condition.ProcessDeployQueryCnd;
import com.bsoft.workflow.dao.primary.ProcessDeployDao;
import com.bsoft.workflow.dto.WFProcessDefinitionDTO;
import com.bsoft.workflow.entity.primary.ProcessDeployDO;
import com.bsoft.workflow.entity.primary.ProcessFileDO;
import com.bsoft.workflow.manager.ProcessDeployManager;
import com.bsoft.workflow.service.ResourcesService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ProcessDeployManagerImpl implements ProcessDeployManager {
    @Autowired
    private ProcessDeployDao processDeployDao;
    @Autowired
    private FilerServerManager filerServerManager;
    @Autowired
    private ServerDateManager serverDateManager;
    @Reference(check=false,timeout = 10000)
    private ResourcesService resourcesService;

    @Override
    public Page<ProcessDeployDO> getProcessDeployList(ProcessDeployQueryCnd cnd) {
        Sort sort = Sort.by("deployDate").descending();
        Pageable pageable = PageRequest.of(cnd.getPageNo()-1,cnd.getPageSize(),sort);
        Page<ProcessDeployDO> processDeploys = processDeployDao.findAll(new Specification<ProcessDeployDO>(){
            @Override
            public Predicate toPredicate(Root<ProcessDeployDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(StringUtils.isNotBlank(cnd.getInputContent())){
                    Predicate c1 = criteriaBuilder.like(root.get("name"),"%"+cnd.getInputContent()+"%");
                    Predicate c2 = criteriaBuilder.like(root.get("key"),"%"+cnd.getInputContent()+"%");
                    predicates.add(criteriaBuilder.or(c1,c2));
                }
                if(cnd.getStatus() != null){
                    predicates.add(criteriaBuilder.equal(root.get("status"),cnd.getStatus()));
                }
                if (cnd.getType() != null && !cnd.getType().equals(0)) {
                    predicates.add(criteriaBuilder.equal(root.get("type"), cnd.getType()));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return processDeploys;
    }

    @Override
    public void saveProcess(ProcessDeployDO processDeployDO) {
        if(processDeployDO.getId() == null){
            Date currentDate = serverDateManager.getServerDateTime();
            processDeployDO.setCreateDate(currentDate);
            processDeployDO.setStatus(0);
        }
        processDeployDao.save(processDeployDO);

    }

    @Override
    public Integer saveProcessFile(ProcessFileDO fileDO) {
        // 将文件保存到文件服务器上
        Integer fileId = filerServerManager.save(fileDO.getMenuId(), fileDO.getFileName(), fileDO.getFileBytes());
        return fileId;
    }

    @Override
    public void deployProcess(Integer id) {
        ProcessDeployDO processDeployDO = processDeployDao.findById(id).get();
        WFProcessDefinitionDTO processDefinitionDTO = resourcesService.deploy(processDeployDO.getFileId());
        processDeployDO.setStatus(1);
        processDeployDO.setKey(processDefinitionDTO.getProcessDefinitionKey());
        processDeployDO.setDefinitionId(processDefinitionDTO.getProcessDefinitionId());
        processDeployDO.setDeploymentId(processDefinitionDTO.getDeploymentId());
        processDeployDO.setVersion(processDefinitionDTO.getProcessDefinitionVersion());
        Date currentDate = serverDateManager.getServerDateTime();
        processDeployDO.setDeployDate(currentDate);
        processDeployDao.save(processDeployDO);
    }
}
