package com.bsoft.hr.manager.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.hr.condition.ClockInModeQueryCnd;
import com.bsoft.hr.dao.primary.ClockInModeDeptInfoDao;
import com.bsoft.hr.dao.primary.ClockInModeDeptSaveDao;
import com.bsoft.hr.dao.primary.ClockInModePersonalInfoDao;
import com.bsoft.hr.dao.primary.ClockInModePersonalSaveDao;
import com.bsoft.hr.entity.primary.ClockInModeDeptInfoDO;
import com.bsoft.hr.entity.primary.ClockInModeDeptSaveDO;
import com.bsoft.hr.entity.primary.ClockInModePersonalInfoDO;
import com.bsoft.hr.entity.primary.ClockInModePersonalSaveDO;
import com.bsoft.hr.manager.ClockInModeManager;
import com.google.common.collect.Collections2;
import org.apache.commons.lang3.StringUtils;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @author: zy
 * @date: 2020/8/30
 * @description 打卡方式维护
 */
@Component
public class ClockInModeManagerImpl implements ClockInModeManager {

    @Autowired
    private ClockInModeDeptInfoDao clockInModeDeptInfoDao;
    @Autowired
    private ClockInModePersonalInfoDao clockInModePersonalInfoDao;
    @Autowired
    private ClockInModeDeptSaveDao clockInModeDeptSaveDao;
    @Autowired
    private ClockInModePersonalSaveDao clockInModePersonalSaveDao;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Page<ClockInModeDeptInfoDO> listDeptInfoWithPage(ClockInModeQueryCnd queryCnd) {
        String dept = queryCnd.getDept();
        String deptType = queryCnd.getDeptType();
        Integer pageNo = queryCnd.getPageNo();
        Integer pageSize = queryCnd.getPageSize();
        Sort sort = Sort.by("sortBy").ascending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        Page<ClockInModeDeptInfoDO> page = clockInModeDeptInfoDao.findAll(new Specification<ClockInModeDeptInfoDO>() {
            @Override
            public Predicate toPredicate(Root<ClockInModeDeptInfoDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("logout"), 0));// 只查询未注销部门
                if (StringUtils.isNotEmpty(deptType)) {
                    predicates.add(criteriaBuilder.equal(root.get("deptType"), Integer.valueOf(deptType)));
                }
                if (StringUtils.isNotEmpty(dept)) {// 如果传了部门id则根据id查找
                    predicates.add(criteriaBuilder.equal(root.get("dept"), dept));
                } else {// 未传部门id则查询所有一级部门
                    predicates.add(criteriaBuilder.isNull(root.get("parentDept")));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return page;
    }

    @Override
    public List<ClockInModeDeptInfoDO> listChildDeptInfo(List<ClockInModeDeptInfoDO> parentList) {
        List<String> deptList = new ArrayList<>();
        parentList.forEach(parent -> {
            deptList.add(parent.getDept());
        });
        List<ClockInModeDeptInfoDO> result = clockInModeDeptInfoDao.findByParentDeptIn(deptList);
        Collection<ClockInModeDeptInfoDO> children = Collections2.filter(result, x -> x.getLogout() == 0);
        return new ArrayList<>(children);
    }

    @Override
    public Page<ClockInModePersonalInfoDO> listPersonalInfoWithPage(ClockInModeQueryCnd queryCnd) {
        String personId = queryCnd.getPersonId();
        String personName = queryCnd.getPersonName();
        String dept = queryCnd.getDept();
        Integer pageNo = queryCnd.getPageNo();
        Integer pageSize = queryCnd.getPageSize();
        Sort sort = Sort.by("personId").ascending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        Page<ClockInModePersonalInfoDO> page = clockInModePersonalInfoDao.findAll(new Specification<ClockInModePersonalInfoDO>() {
            @Override
            public Predicate toPredicate(Root<ClockInModePersonalInfoDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(personId)) {
                    predicates.add(criteriaBuilder.equal(root.get("personId"), personId));
                }
                if (StringUtils.isNotBlank(personName)) {
                    Predicate c1 = criteriaBuilder.like(root.get("nameCode"),"%" + personName + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("nameCode"),"%" + personName.toLowerCase() + "%");
                    Predicate c3 = criteriaBuilder.like(root.get("personName"),"%" + personName + "%");
                    predicates.add(criteriaBuilder.or(c1,c2,c3));
                }
                if (StringUtils.isNotBlank(dept)) {
                    predicates.add(criteriaBuilder.equal(root.get("dept"), dept));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return page;
    }

    @Override
    @Transactional
    public void setDept(List<ClockInModeDeptSaveDO> deptSaveDOList, List<ClockInModePersonalSaveDO> personalSaveDOList) {
        clockInModeDeptSaveDao.saveAll(deptSaveDOList);
        clockInModePersonalSaveDao.saveAll(personalSaveDOList);
    }

    @Override
    @Transactional
    public void setPersonal(List<ClockInModePersonalSaveDO> personalSaveDOList) {
        clockInModePersonalSaveDao.saveAll(personalSaveDOList);
    }

    @Override
    public List<ClockInModeDeptSaveDO> processDeptSaveDOList(List<ClockInModeDeptInfoDO> deptInfoDOList) {
        List<ClockInModeDeptSaveDO> resultList = new ArrayList<>();
        deptInfoDOList.forEach(deptInfoDO -> {
            String dept = deptInfoDO.getDept();
            Integer attendFlag = deptInfoDO.getAttendFlagDept();
            Optional<ClockInModeDeptSaveDO> result = clockInModeDeptSaveDao.findById(dept);
            ClockInModeDeptSaveDO saveDO = result.get();
            saveDO.setAttendFlagDept(attendFlag);
            resultList.add(saveDO);
        });
        return resultList;
    }

    @Override
    public List<ClockInModePersonalSaveDO> processPersonalSaveDOList(List<ClockInModePersonalInfoDO> personalInfoDOList) {
        List<ClockInModePersonalSaveDO> resultList = new ArrayList<>();
        personalInfoDOList.forEach(personalInfoDO -> {
            String personId = personalInfoDO.getPersonId();
            Integer attendFlag = personalInfoDO.getAttendFlagPersonal();
            Optional<ClockInModePersonalSaveDO> result = clockInModePersonalSaveDao.findById(personId);
            ClockInModePersonalSaveDO saveDO = result.get();
            saveDO.setAttendFlagPersonal(attendFlag);
            resultList.add(saveDO);
        });
        return resultList;
    }

    @Override
    public List<ClockInModePersonalSaveDO> processNeedChangePersonList(List<ClockInModeDeptInfoDO> deptInfoDOList) {
        List<ClockInModePersonalSaveDO> resultList = new ArrayList<>();
        deptInfoDOList.forEach(deptInfoDO -> {
            String dept = deptInfoDO.getDept();
            Integer attendFlag = deptInfoDO.getAttendFlagDept();
            List<ClockInModePersonalInfoDO> personalInfoDOList = clockInModePersonalInfoDao.findByDept(dept);
            List<ClockInModePersonalSaveDO> personalSaveDOList = iGenerator.convert(personalInfoDOList, ClockInModePersonalSaveDO.class);
            personalSaveDOList.forEach(personalSaveDO -> {
                personalSaveDO.setAttendFlagPersonal(attendFlag);
            });
            if (personalSaveDOList.size() > 0) {
                resultList.addAll(personalSaveDOList);
            }
        });
        return resultList;
    }

    @Override
    public List<ClockInModeDeptInfoDO> findAll() {
        return clockInModeDeptInfoDao.findAll();
    }
}
