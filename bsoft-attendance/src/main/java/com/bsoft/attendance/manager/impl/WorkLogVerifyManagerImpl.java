package com.bsoft.attendance.manager.impl;

import com.bsoft.attendance.dao.primary.WorkLogDao;
import com.bsoft.attendance.dao.primary.WorkLogVerifyDao;
import com.bsoft.attendance.entity.primary.WorkLogVerifyDO;
import com.bsoft.attendance.manager.WorkLogVerifyManager;
import com.bsoft.exception.ServiceException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class WorkLogVerifyManagerImpl implements WorkLogVerifyManager {
    @Autowired
    private WorkLogVerifyDao workLogVerifyDao;
    @Autowired
    private WorkLogDao workLogDao;

    @Override
    public Page<WorkLogVerifyDO> getPendingWorkLog(String personId, String content, Integer page, Integer size) {
        Sort sort = Sort.by(Sort.Order.desc("attendanceDate"));
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<WorkLogVerifyDO> results = workLogVerifyDao.findAll(new Specification<WorkLogVerifyDO>() {
            @Override
            public Predicate toPredicate(Root<WorkLogVerifyDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if(StringUtils.isBlank(content)){
                    return criteriaBuilder.equal(root.get("projectManager"),personId);
                }
                Predicate predicate1 = criteriaBuilder.like(root.get("projectName"),content);
                Predicate predicate2 = criteriaBuilder.like(root.get("projectPinyin"),content);
                Predicate predicate3 = criteriaBuilder.like(root.get("personName"),content);
                Predicate predicate4 = criteriaBuilder.like(root.get("personPinyin"),content);
                Predicate predicate5 = criteriaBuilder.or(predicate1,predicate2,predicate3,predicate4);
                Predicate predicate6 = criteriaBuilder.equal(root.get("projectManager"),personId);
                Predicate predicate7 = criteriaBuilder.and(predicate5,predicate6);
                return predicate7;
            }
        },pageable);
        return results;
    }

    @Override
    @Transactional
    public void verifyWorkLog(WorkLogVerifyDO workLogVerify) {
        if(!checkWorkLog(workLogVerify)){
            throw new ServiceException("数据校验不通过，请检查!");
        }
        Integer workLogId = workLogVerify.getWorkLogId();
        Integer verifyFlag = workLogVerify.getVerifyFlag();
        Double verifyHours = workLogVerify.getVerifyHours();
        String verifyRemark = workLogVerify.getVerifyRemark();
        String verifier = workLogVerify.getVerifier();
        workLogDao.verifyWorkLog(workLogId,verifyFlag,verifyHours,verifyRemark,verifier);
    }

    @Override
    @Transactional
    public void verifyWorkLogs(List<WorkLogVerifyDO> workLogVerifys) {
        for(WorkLogVerifyDO workLogVerify : workLogVerifys){
            if(!checkWorkLog(workLogVerify)){
                throw new ServiceException("数据校验不通过，请检查!");
            }
            Integer workLogId = workLogVerify.getWorkLogId();
            Integer verifyFlag = workLogVerify.getVerifyFlag();
            Double verifyHours = workLogVerify.getVerifyHours();
            String verifyRemark = workLogVerify.getVerifyRemark();
            String verifier = workLogVerify.getVerifier();
            workLogDao.verifyWorkLog(workLogId,verifyFlag,verifyHours,verifyRemark,verifier);
        }
    }

    private Boolean checkWorkLog(WorkLogVerifyDO workLogVerify){
        if(workLogVerify.getWorkLogId() == null){ //日志ID不能为空
            return false;
        }

        if(workLogVerify.getVerifyFlag() == 1 || workLogVerify.getVerifyFlag() == -1){ //同意和不同意：审核人不能为空
            if(StringUtils.isBlank(workLogVerify.getVerifier())){
                return false;
            }
        }

        if(workLogVerify.getVerifyFlag() == 1){ //同意：审核工时不能为空
            if(workLogVerify.getVerifyHours() == null){
                return false;
            }
        }

        return true;
    }
}
