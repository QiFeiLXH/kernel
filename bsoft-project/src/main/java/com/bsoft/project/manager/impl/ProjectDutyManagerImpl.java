package com.bsoft.project.manager.impl;

import com.bsoft.auth.manager.ProjectPermissionManager;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.exception.ServiceException;
import com.bsoft.project.condition.ProjectDutyQueryCnd;
import com.bsoft.project.dao.primary.*;
import com.bsoft.project.entity.primary.*;
import com.bsoft.project.manager.ProjectDutyManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/12 13:24
 * @Description
 */
@Service
public class ProjectDutyManagerImpl implements ProjectDutyManager {
    @Autowired
    private ProjectDutyViewDao projectDutyViewDao;
    @Autowired
    private ProjectDutyAuditViewDao projectDutyAuditViewDao;
    @Autowired
    private ProjectDutyAuditSaveDao projectDutyAuditSaveDao;
    @Autowired
    private ProjectDutyCustomerAndProjectSelectViewDao projectDutyCustomerAndProjectSelectViewDao;
    @Autowired
    private ProjectDutyRegionViewDao projectDutyRegionViewDao;
    @Autowired
    private ProjectDutyDao projectDutyDao;
    @Autowired
    private ProjectDutyUpdateDao projectDutyUpdateDao;
    @Autowired
    private ProjectDutyMilepostDao projectDutyMilepostDao;
    @Autowired
    private ProjectDutyMilepostViewDao projectDutyMilepostViewDao;
    @Autowired
    private ProjectDutyRegionDao projectDutyRegionDao;
    @Autowired
    private ProjectDutyPaymentDao projectDutyPaymentDao;
    @Autowired
    private ProjectDutyPaymentViewDao projectDutyPaymentViewDao;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private ProjectPermissionManager projectPermissionManager;

    @Override
    public Page<ProjectDutyViewDO> getProjectDutyMaintainList(ProjectDutyQueryCnd cnd) {
        Sort sort = Sort.by("signDate").descending()
                .and(Sort.by("id").descending());
        Pageable pageable = PageRequest.of(cnd.getPageNo()-1,cnd.getPageSize(),sort);
        Page<ProjectDutyViewDO> pages = projectDutyViewDao.findAll(new Specification<ProjectDutyViewDO>() {
            @Override
            public Predicate toPredicate(Root<ProjectDutyViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("signner"), cnd.getUserId())); //当前登陆人创建的责任书列表
                predicates.add(criteriaBuilder.equal(root.get("year"), cnd.getYear())); //责任书年度
                if (cnd.getAuditFlag() != -1) {
                    predicates.add(criteriaBuilder.equal(root.get("auditFlag"), cnd.getAuditFlag())); // 审核情况
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return pages;
    }

    @Override
    public Page<ProjectDutyAuditViewDO> getProjectDutyAuditList(ProjectDutyQueryCnd cnd) {
        Sort sort = Sort.by("auditDate").descending()
                .and(Sort.by("signDate").descending())
                .and(Sort.by("id").descending());
        Pageable pageable = PageRequest.of(cnd.getPageNo()-1,cnd.getPageSize(),sort);
        List<String> areaList = projectPermissionManager.getProjectAreaPermission(cnd.getUserId());
        Page<ProjectDutyAuditViewDO> pages = projectDutyAuditViewDao.findAll(new Specification<ProjectDutyAuditViewDO>() {
            @Override
            public Predicate toPredicate(Root<ProjectDutyAuditViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(cnd.getStartYear() != null){
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("year"), cnd.getStartYear()));
                }
                if(cnd.getEndYear() != null){
                    predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("year"), cnd.getEndYear()));
                }
                if(StringUtils.isNotBlank(cnd.getDutyName())){
                    predicates.add(criteriaBuilder.like(root.get("name"),"%"+cnd.getDutyName()+"%"));
                }
                if (cnd.getAuditFlag() != -1) {
                    predicates.add(criteriaBuilder.equal(root.get("auditFlag"), cnd.getAuditFlag())); // 审核情况
                    if (cnd.getAuditFlag() == 0) {
                        predicates.add(criteriaBuilder.equal(root.get("committed"), 1)); // 已提交
                    }
                }
                CriteriaBuilder.In<String> in = criteriaBuilder.in(root.get("area"));
                if (areaList.isEmpty()) {
                    in.value("");
                }else{
                    for(String area : areaList){
                        in.value(area);
                    }
                }
                predicates.add(in);
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return pages;
    }

    @Override
    public Integer getProjectDutyAuditCount(ProjectDutyQueryCnd cnd) {
        List<String> areaList = projectPermissionManager.getProjectAreaPermission(cnd.getUserId());
        List<ProjectDutyAuditViewDO> list = projectDutyAuditViewDao.findAll(new Specification<ProjectDutyAuditViewDO>() {
            @Override
            public Predicate toPredicate(Root<ProjectDutyAuditViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (cnd.getAuditFlag() != -1) {
                    predicates.add(criteriaBuilder.equal(root.get("auditFlag"), cnd.getAuditFlag())); // 审核情况
                }
                CriteriaBuilder.In<String> in = criteriaBuilder.in(root.get("area"));
                if (areaList.isEmpty()) {
                    in.value("");
                }else{
                    for(String area : areaList){
                        in.value(area);
                    }
                }
                predicates.add(in);
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
        return list.size();
    }

    @Override
    public Page<ProjectDutyCustomerAndProjectSelectViewDO> getProjectDutyCustomerSelectList(Integer pageNo, Integer pageSize, String userId) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        // 本人是该合同最大软件额项目（未完结）的项目经理的合同客户
        Page<ProjectDutyCustomerAndProjectSelectViewDO> pages = projectDutyCustomerAndProjectSelectViewDao.findAllByProjectManager(userId,pageable);
        return pages;
    }

    @Override
    public List<ProjectDutyRegionViewDO> getProjectDutyRegionList(Integer dutyId) {
        List<ProjectDutyMilepostViewDO> milepostList = projectDutyMilepostViewDao.findAllByDutyId(dutyId);
        milepostList.forEach(milepost -> {
            if (!StringUtils.isBlank(milepost.getWords())) {
                milepost.setWordsNum(milepost.getWords().split(",").length);
                List<Integer> list = Arrays.asList(milepost.getWords().split(",")).stream().map(i -> Integer.valueOf(i)).collect(Collectors.toList());
                milepost.setWordsList(list);
            } else {
                milepost.setWordsList(new ArrayList<>());
            }
        });
        Map<String, List<ProjectDutyMilepostViewDO>> listMap = milepostList.stream().collect(Collectors.groupingBy(ProjectDutyMilepostViewDO::getContractNo));
        List<ProjectDutyRegionViewDO> regions = projectDutyRegionViewDao.findAllByDutyId(dutyId);
        regions.forEach(item -> {
            item.setMileposts(listMap.get(item.getContractNo()));
        });
        return regions;
    }

    @Override
    public Page<ProjectDutyCustomerAndProjectSelectViewDO> getProjectDutyProjectSelectList(String userId, String customerId, Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        // 选择该客户对应合同最大软件额项目的项目经理是自己的项目（未完结）
        Page<ProjectDutyCustomerAndProjectSelectViewDO> pages = projectDutyCustomerAndProjectSelectViewDao.findAllByProjectManagerAndCustomerId(userId, customerId,pageable);
        return pages;
    }

    @Override
    public String getProjectDutyNameNo(String customerId, String year) {
        return projectDutyDao.getProjectDutyNameNoByCustomerIdAndYear(customerId, year);
    }

    @Override
    @Transactional
    public void deleteProjectDuty(Integer dutyId) {
        // 删除责任书
        projectDutyDao.deleteById(dutyId);
        // 删除项目范围
        projectDutyRegionDao.deleteAllByDutyId(dutyId);
        // 删除回款
        projectDutyPaymentDao.deleteAllByDutyId(dutyId);
        // 删除里程碑
        projectDutyMilepostDao.deleteAllByDutyId(dutyId);
    }

    @Override
    public List<ProjectDutyMilepostDO> getProjectDutyMilepostList(String contractNo) {
        return projectDutyMilepostDao.findByContractNoOrderById(contractNo);
    }

    @Override
    public List<ProjectDutyMilepostDO> getDutyMilepostWithPlan(String contractNo) {
        Calendar c = Calendar.getInstance();
        Date now = serverDateManager.getServerDateTime();
        c.setTime(now);
        int year = c.get(Calendar.YEAR);
        return projectDutyMilepostDao.getDutyMilepostWithPlan(contractNo,year);
    }

    @Override
    public List<ProjectDutyMilepostDO> getProjectDutyMileposts(String contractNo, Integer dutyId) {
        return projectDutyMilepostDao.findByContractNoAndDutyIdOrderById(contractNo, dutyId);
    }

    @Override
    public List<ProjectDutyMilepostDO> getProjectDutyMileposts(Integer id) {
        List<ProjectDutyMilepostDO> result = new ArrayList<>();
        ProjectDutyMilepostDO projectDutyMilepostDO = projectDutyMilepostDao.getOne(id);
        result.add(projectDutyMilepostDO);
        return result;
    }


    @Override
    public Page<ProjectDutyMilepostViewDO> getProjectDutyMilepostList(String contractNo, Integer dutyId, Integer pageNo, Integer pageSize) {
        Sort sort = Sort.by("id").ascending();
        Pageable pageable = PageRequest.of(pageNo-1,pageSize,sort);
        Page<ProjectDutyMilepostViewDO> pages = projectDutyMilepostViewDao.findAllByContractNoAndDutyId(contractNo, dutyId, pageable);
        return pages;
    }

    @Override
    public List<ProjectDutyPaymentViewDO> getProjectDutyPayment(Integer dutyId) {
        List<ProjectDutyPaymentViewDO> paymentList = projectDutyPaymentViewDao.findAllByDutyIdOrderByPaymentItemAsc(dutyId);
        Map<String, List<ProjectDutyPaymentViewDO>> paymentMap = paymentList.stream().collect(Collectors.groupingBy(ProjectDutyPaymentViewDO::getContractCode));
        List<ProjectDutyPaymentViewDO> result = new ArrayList<>();
        paymentMap.forEach((contractCode,list) -> {
            ProjectDutyPaymentViewDO totalPayment = new ProjectDutyPaymentViewDO();
            totalPayment.setId(contractCode);
            totalPayment.setContractNo(list.get(0).getContractNo());
            totalPayment.setContractCode(contractCode);
            totalPayment.setSelectedFlag(-1); // -1仅代表此数据为合计数据，展示预计回款的总和
            totalPayment.setExpected(list.stream().mapToDouble(ProjectDutyPaymentViewDO::getExpected).sum());
            totalPayment.setChildren(list);
            result.add(totalPayment);
        });

        return result;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveProjectDutyPayment(List<ProjectDutyPaymentDO> payments, List<Integer> deletes) {
        projectDutyPaymentDao.saveAll(payments);
        projectDutyPaymentDao.deleteAllByIdIn(deletes);
    }

    @Override
    public List<ProjectDutyAuditViewDO> getAllProjectDutyAuditList(ProjectDutyQueryCnd cnd) {
        Sort sort = Sort.by("auditDate").descending()
                .and(Sort.by("signDate").descending())
                .and(Sort.by("id").descending());
        List<String> areaList = projectPermissionManager.getProjectAreaPermission(cnd.getUserId());
        List<ProjectDutyAuditViewDO> list = projectDutyAuditViewDao.findAll(new Specification<ProjectDutyAuditViewDO>() {
            @Override
            public Predicate toPredicate(Root<ProjectDutyAuditViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(cnd.getStartYear() != null){
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("year"), cnd.getStartYear()));
                }
                if(cnd.getEndYear() != null){
                    predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("year"), cnd.getEndYear()));
                }
                if(StringUtils.isNotBlank(cnd.getDutyName())){
                    predicates.add(criteriaBuilder.like(root.get("name"),"%"+cnd.getDutyName()+"%"));
                }
                if (cnd.getAuditFlag() != -1) {
                    predicates.add(criteriaBuilder.equal(root.get("auditFlag"), cnd.getAuditFlag())); // 审核情况
                    if (cnd.getAuditFlag() == 0) {
                        predicates.add(criteriaBuilder.equal(root.get("committed"), 1)); // 已提交
                    }
                }
                CriteriaBuilder.In<String> in = criteriaBuilder.in(root.get("area"));
                if (areaList.isEmpty()) {
                    areaList.add("");
                }
                for(String area : areaList){
                    in.value(area);
                }
                predicates.add(in);
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },sort);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer saveProjectDutyAndRegion(ProjectDutyDO dutyDO, List<ProjectDutyRegionDO> regionDOs, String userId) {
        Date currentDate = serverDateManager.getServerDateTime();
        // 保存项目责任书
        dutyDO.setRegisterDate(currentDate);
        dutyDO.setSignDate(currentDate);
        dutyDO.setSignner(userId);
        dutyDO.setAuditFlag(0);

        projectDutyDao.save(dutyDO);
        if(dutyDO.getId() != null) {
            // 保存项目范围
            if (!regionDOs.isEmpty()){
                regionDOs.forEach(region -> {
                    region.setDutyId(dutyDO.getId());
                });
                projectDutyRegionDao.saveAll(regionDOs);
            }
        }
        return dutyDO.getId();

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer updateProjectDutyAndRegion(ProjectDutyUpdateDO dutyDO, List<ProjectDutyRegionDO> regionDOs, List<Integer> deleteRegions, List<String> contractNo) {
        Integer dutyId = dutyDO.getId();
        // 更新项目责任书
        projectDutyUpdateDao.save(dutyDO);
        // 保存项目范围
        if (!regionDOs.isEmpty()){
            regionDOs.forEach(region -> {
                region.setDutyId(dutyDO.getId());
            });
            projectDutyRegionDao.saveAll(regionDOs);
        }
        // 删除项目范围
        if(!deleteRegions.isEmpty()) {
            projectDutyRegionDao.deleteByIdIn(deleteRegions);
            // 删除里程碑
            projectDutyMilepostDao.deleteAllByDutyIdAndContractNoIn(dutyId, contractNo);
            // 删除计划回款
            projectDutyPaymentDao.deleteAllByDutyIdAndContractNoIn(dutyId, contractNo);
        }

        return dutyDO.getId();
    }

    @Override
    public void auditProjectDutyList(List<ProjectDutyAuditSaveDO> auditSaveDOS,String userId) {
        Date now = serverDateManager.getServerDateTime();
        auditSaveDOS.forEach(auditDO -> {
            auditDO.setAuditFlag(1);
            auditDO.setAuditter(userId);
            auditDO.setAuditDate(now);
        });
        projectDutyAuditSaveDao.saveAll(auditSaveDOS);
    }

    @Override
    @Transactional
    public void saveProjectDutyMilepost(List<ProjectDutyMilepostDO> mileposts, List<Integer> deletes) {
        projectDutyMilepostDao.saveAll(mileposts);
        if(!deletes.isEmpty()) {
            projectDutyMilepostDao.deleteAllByIdIn(deletes);
        }
    }

    @Override
    public ProjectDutyViewDO getOneProjectDutyView(Integer dutyId) {
        ProjectDutyViewDO projectDutyViewDO = projectDutyViewDao.getOne(dutyId);
        return projectDutyViewDO;
    }
}
