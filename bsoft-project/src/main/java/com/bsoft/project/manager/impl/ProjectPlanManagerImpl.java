package com.bsoft.project.manager.impl;

import com.bsoft.auth.manager.ProjectPermissionManager;
import com.bsoft.common.entity.primary.PublicDicDO;
import com.bsoft.common.key.KeyGenerator;
import com.bsoft.common.lock.RedisLocker;
import com.bsoft.common.manager.PublicDicManager;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.exception.ServiceException;
import com.bsoft.project.condition.ProjectPlanQueryCnd;
import com.bsoft.project.dao.primary.ProjectPlanDao;
import com.bsoft.project.dao.primary.ProjectPlanDetailDao;
import com.bsoft.project.dao.primary.ProjectWithPlanDao;
import com.bsoft.project.entity.primary.*;
import com.bsoft.project.manager.ProjectMilepostManager;
import com.bsoft.project.manager.ProjectPlanManager;
import com.bsoft.project.repository.primary.ProjectPlanRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Collections2;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author zhanglf
 * @Date 2020-01-19 16:46
 * @Version 1.0
 * @Description
 */
@Component
public class ProjectPlanManagerImpl implements ProjectPlanManager {
    private static final Logger logger = LoggerFactory.getLogger(ProjectPlanManagerImpl.class);
    private static final String DEFAULT_LOCKKEY = "plan:";
    @Autowired
    private ProjectPlanDao projectPlanDao; //????????????dao
    @Autowired
    private ProjectWithPlanDao projectWithPlanDao; //?????????????????????dao
    @Autowired
    private ProjectPlanDetailDao projectPlanDetailDao; //??????????????????dao
    @Autowired
    private ProjectMilepostManager projectMilepostManager;
    @Autowired
    private PublicDicManager publicDicManager;
    @Autowired
    private KeyGenerator keyGenerator;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private ProjectPlanRepository projectPlanRepository;
    @Autowired
    private ProjectPermissionManager projectPermissionManager;
    @Autowired
    private RedisLocker redisLocker;

    @Override
    public ProjectPlanDO saveProjectPlan(ProjectPlanDO projectPlanDO) {
        return projectPlanDao.save(projectPlanDO);
    }

    @Override
    public ProjectPlanDetailDO saveProjectPlanDetail(ProjectPlanDetailDO projectPlanDetailDO) {
        return projectPlanDetailDao.save(projectPlanDetailDO);
    }

    @Override
    public void saveProjectPlanDetails(List<ProjectPlanDetailDO> details) {
        projectPlanDetailDao.saveAll(details);
    }

    @Override
    public void deleteProjectPlanDetail(Integer id) {
        projectPlanDetailDao.deleteById(id);
    }

    @Override
    public ProjectPlanDO getProjectPlan(Integer id) {
        Optional<ProjectPlanDO> projectPlan = projectPlanDao.findById(id);
        projectPlan.orElseThrow(()->new ServiceException("???????????????ID???????????????"));
        return projectPlan.get();
    }

    @Override
    public Page<ProjectWithPlanDO> getProjectWithPlans(String projectManager, String context, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<ProjectWithPlanDO> result = projectWithPlanDao.findAll(new Specification<ProjectWithPlanDO>() {
            @Override
            public Predicate toPredicate(Root<ProjectWithPlanDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(projectManager != null){
                    Predicate c1 = criteriaBuilder.equal(root.get("projectManager"),projectManager);
                    predicates.add(c1);
                }
                if(context != null){
                    Predicate c1 = criteriaBuilder.like(root.get("pyjm"),"%"+context+"%");
                    Predicate c2 = criteriaBuilder.like(root.get("projectName"),"%"+context+"%");
                    Predicate c3 = criteriaBuilder.like(root.get("contractName"),"%"+context+"%");
                    Predicate c4 = criteriaBuilder.like(root.get("contractNo"),"%"+context+"%");
                    predicates.add(criteriaBuilder.or(c1,c2,c3,c4));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return result;
    }

    @Override
    @Transactional
    public PageInfo<ProjectWithPlanDO> getProjectWithPlansAndAuth(String personId, ProjectPlanQueryCnd cnds,Integer page, Integer size) {
        cnds.setPersonId(personId);
        PageHelper.startPage(page, size);
        List<ProjectWithPlanDO> list = projectPlanRepository.getProjectWithPlansAndAuth(cnds);
        PageInfo<ProjectWithPlanDO> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<ProjectPlanDetailDO> getProjectPlanDetails(Integer planId) {
        return projectPlanDetailDao.findByPlanIdOrderByLogoffAscMilepostIdAscSortAsc(planId);
    }

    @Override
    public ProjectPlanDetailDO getProjectPlanDetail(Integer id) {
        Optional<ProjectPlanDetailDO> detail = projectPlanDetailDao.findById(id);
        detail.orElseThrow(()->new ServiceException("?????????ID?????????????????????"));
        return detail.get();
    }

    @Override
    public List<ProjectPlanDetailDO> getProjectPlanDetailTree(Integer planId) {
        List<ProjectPlanDetailDO> result = getProjectPlanDetails(planId);
        Collection<ProjectPlanDetailDO> roots = Collections2.filter(result, x->x.getParentId().equals(0));
        for(ProjectPlanDetailDO root : roots){
            root.setStage(root.getMilepostId());
            toPlanTree(root,result,root.getStage());
        }
        return new ArrayList<>(roots);
    }

    @Override
    public List<ProjectLogPlanDetailDO> getProjectLogPlanDetailTree(String projectId, String personId, Date attendanceDate,Integer part) {
        List<ProjectLogPlanDetailDO> result = projectPlanRepository.getProjectLogPlanDetail(projectId,personId,attendanceDate,part);
        Collection<ProjectLogPlanDetailDO> roots = Collections2.filter(result,x->x.getParentId().equals(0));
        for(ProjectLogPlanDetailDO root : roots){
            toProjectLogPlanTree(root,result);
        }
        return new ArrayList<>(roots);
    }

    @Override
    public List<ProjectLogPlanDetailDO> getProjectLogPlanDetailQueryTree(String contractNo, Integer part) {
        List<ProjectLogPlanDetailDO> result = projectPlanRepository.getProjectLogPlanDetailQuery(contractNo,part);
        Collection<ProjectLogPlanDetailDO> roots = Collections2.filter(result,x->x.getParentId().equals(0));
        for(ProjectLogPlanDetailDO root : roots){
            toProjectLogPlanTree(root,result);
        }
        return new ArrayList<>(roots);
    }

    @Override
    public List<ProjectPlanDetailDO> getProjectPlanTemplate() {
        List<PublicDicDO> stages = publicDicManager.getPublicDic(2000); //????????????????????????
        List<ProjectPlanDetailDO> planDetails = new ArrayList<>();
        String[] icons = new String[]{"play-circle","schedule","hourglass","eye","setting"};
        for(PublicDicDO stage : stages) { //?????????????????????????????? ?????????
            ProjectPlanDetailDO detail = new ProjectPlanDetailDO();
//            detail.setId(1000+stage.getId());//??????ID
            detail.setPlanId(null);//????????????ID 1.?????? 2.?????? 3.?????? 4.?????? 5.???????????????
            detail.setParentId(0);
            detail.setRange(1);//???????????? ???????????? 1
            detail.setMilepostId(stage.getId());//??????ID
            detail.setIcon(icons[stage.getId()-1]);//??????
            detail.setMilepostName(stage.getName());//????????????
            detail.setMilepostLevel(1);
            detail.setLogoff(0);
            planDetails.add(detail);
            List<ProjectPlanDetailDO> childs = new ArrayList<>();
            if(!childs.isEmpty()){
                detail.setChildren(childs);
            }
        }
        return planDetails;
    }

    @Override
    @Transactional
    public ProjectPlanDO savePlanAndDetail(ProjectPlanDO plan, List<ProjectPlanDetailDO> details,List<Integer> deletes){
        String requestId = redisLocker.getRequestId();
        redisLocker.lock(DEFAULT_LOCKKEY + plan.getContractNo(),requestId);
        try{
            Date now = serverDateManager.getServerDateTime();
            plan.setModifyDate(now);
            if(plan.getCreateDate() == null){
                plan.setCreateDate(now);
            }
            if(plan.getBatchFlag() == null){
                plan.setBatchFlag(2);
            }
            if(plan.getChangeFlag() == null){
                plan.setChangeFlag(1);
            }
            if(plan.getLogoff() == null){
                plan.setLogoff(2);
            }
            if(plan.getAuditFlag() == null){
                plan.setAuditFlag(1);
            }
            ProjectPlanDO projectPlan = projectPlanDao.save(plan);
            Integer planId = projectPlan.getId();
            for(ProjectPlanDetailDO detail : details){
                if(detail.getActualFinishDate() != null && detail.getActualFinishDate().getTime() > now.getTime()){
                    throw new ServiceException("??????????????????????????????????????????");
                }
                if(detail.getPlanId() == null){
                    detail.setPlanId(planId);
                }
                if(detail.getActualFinishDate() != null){
                    detail.setFinishFlag(1);
                }
            }
            projectPlanDetailDao.saveAll(details);
            deletes.stream().forEach(delete->projectPlanDetailDao.deleteById(delete));
            return projectPlan;
        }finally {
            redisLocker.releaseLock(DEFAULT_LOCKKEY + plan.getContractNo(),requestId);
        }
    }

    @Override
    public List<ProjectPlanDetailDO> detailTreeToList(List<ProjectPlanDetailDO> trees) {
        List<ProjectPlanDetailDO> details = new ArrayList<>();
        trees.stream().forEach(detail->{
            Integer id = detail.getId();
            if(id == null){
                id = keyGenerator.increaseProjectPlanDetail();
                detail.setId(id);
            }
            details.add(detail);
            if(detail.getActualFinishDate() != null){
                detail.setFinishFlag(1);
            }
            toPlanList(detail,details,id);
        });
        return details;
    }

    @Override
    public Boolean milepostPlanIsFinished(String contractId, Integer dutyId) {
        List<ProjectPlanDetailDO> list = projectPlanDetailDao.findByContractIdAndMilepostDutyId(contractId, dutyId);
        Long count = list.stream().filter(item -> item.getFinishFlag()!=null&& item.getFinishFlag()== 1).count();
        return count.intValue() == list.size();
    }

    @Override
    public Integer getProjectLogPlanCount(String projectId) {
        return projectPlanRepository.getProjectLogPlanCount(projectId);
    }

    private void toPlanList(ProjectPlanDetailDO detail,List<ProjectPlanDetailDO> details,Integer parentId){
        List<ProjectPlanDetailDO> childrens = detail.getChildren();
        if(childrens != null){
            childrens.stream().forEach(children->{
                Integer id = children.getId();
                if(id == null){
                    id = keyGenerator.increaseProjectPlanDetail();
                    children.setId(id);
                }
                if(detail.getActualFinishDate() != null && detail.getMilepostFlag().equals(1)){
                    detail.setFinishFlag(1);
                    children.setFinishFlag(1);
                    children.setMilepostFlag(1);
                    children.setActualFinishDate(detail.getActualFinishDate());
                }
                children.setParentId(parentId);
                details.add(children);
                toPlanList(children,details,id);
            });
        }

    }


    private void toPlanTree(ProjectPlanDetailDO parent,List<ProjectPlanDetailDO> result,Integer stage){
        Integer parentId = parent.getId();
        Collection<ProjectPlanDetailDO> childrens = Collections2.filter(result,x->x.getParentId().equals(parentId));
        if(childrens != null && !childrens.isEmpty()){
            parent.setChildren(new ArrayList<>(childrens));
            for(ProjectPlanDetailDO children : childrens){
                children.setStage(stage);
                toPlanTree(children,result,stage);
            }
        }

    }

    private void toProjectLogPlanTree(ProjectLogPlanDetailDO parent,List<ProjectLogPlanDetailDO> result){
        Integer parentId = parent.getId();
        Collection<ProjectLogPlanDetailDO> childrens = Collections2.filter(result,x->x.getParentId().equals(parentId));
        if(childrens != null && !childrens.isEmpty()){
            parent.setChildren(new ArrayList<>(childrens));
            for(ProjectLogPlanDetailDO children : childrens){
                toProjectLogPlanTree(children,result);
            }
        }

    }

}
