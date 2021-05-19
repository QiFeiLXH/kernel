package com.bsoft.dept.manager.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.dept.dao.primary.*;
import com.bsoft.dept.entity.primary.*;
import com.bsoft.dept.manager.DeptManager;
import com.bsoft.dept.repository.primary.DeptSelectRepository;
import com.bsoft.exception.ServiceException;
import com.google.common.collect.Collections2;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class DeptManagerImpl implements DeptManager {
    private static final Logger logger = LoggerFactory.getLogger(DeptManagerImpl.class);

    public static final String DEFAULT_CACHENAME = "Dept";
    public static final String DEFAULT_CACHENAME_DETAIL = DEFAULT_CACHENAME + ":detail";
    public static final String DEFAULT_CACHENAME_ALL = DEFAULT_CACHENAME + ":all";
    public static final String DEFAULT_CACHENAME_VAILD = DEFAULT_CACHENAME + ":vaild";
    public static final String DEFAULT_CACHENAME_TREE= DEFAULT_CACHENAME + ":tree";
    @Autowired
    private DeptDao deptDao;
    @Autowired
    private DeptSelectDao deptSelectDao;
    @Autowired
    private DeptSelectViewDao deptSelectViewDao;
    @Autowired
    private DeptWithPersonDao deptWithPersonDao;
    @Autowired
    private GeneratorUtil generatorUtil;
    @Autowired
    private DeptSelectRepository deptSelectRepository;
    @Autowired
    private CloudschoolDeptSyncDao cloudschoolDeptSyncDao;

    @Override
//    @Cacheable(cacheNames = DEFAULT_CACHENAME_VAILD)
    public List<DeptDO> getDeptList() {
        return deptDao.findByLogout(0);
    }

    @Override
//    @Cacheable(cacheNames = DEFAULT_CACHENAME_DETAIL,key = "#deptId")
    public DeptDO getDept(String deptId) {
        if(StringUtils.isBlank(deptId)){
            throw new ServiceException("部门编码不能为空");
        }
        Optional<DeptDO> dept = deptDao.findById(deptId);
        DeptDO deptDO = dept.orElseThrow(()->new ServiceException("无效部门编码"));
        return deptDO;
    }

    @Override
//    @Cacheable(cacheNames = DEFAULT_CACHENAME_ALL)
    public List<DeptDO> getAllDept() {
        return deptDao.findAll();
    }

    @Override
    public Map<String, String> getDicDept() {
        List<DeptDO> deptList = deptDao.findByLogout(0);
        return deptList.stream().collect(Collectors.toMap(DeptDO::getDeptId,DeptDO::getDeptName,(key1,key2)->key1));
    }

    @Override
    public Map<String, String> getAllDicDept() {
        List<DeptDO> deptList = deptDao.findAll();
        return deptList.stream().collect(Collectors.toMap(DeptDO::getDeptId,DeptDO::getDeptName,(key1,key2)->key1));
    }

    @Override
    @Cacheable(cacheNames = DEFAULT_CACHENAME_TREE,key = "#logout")
    public List<DeptSelectDO> getDeptSelectList(String logout) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<DeptSelectDO> result = null;

        result = deptSelectDao.findAll(new Specification<DeptSelectDO>() {
            @Override
            public Predicate toPredicate(Root<DeptSelectDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotEmpty(logout)) {
                    predicates.add(criteriaBuilder.equal(root.get("logout"), Integer.valueOf(logout)));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });

        Collection<DeptSelectDO> roots = Collections2.filter(result, x -> x.getParentId() == null);
        for (DeptSelectDO dept : roots) {
            this.toDeptTree(dept, result);
        }
        List<DeptSelectDO> sortedTree = roots.stream().sorted(Comparator.comparing(DeptSelectDO::getSortBy)).collect(Collectors.toList());

        long times = timeConsumer.end();
        logger.info("方法名:{}部门查找获取数据耗时:{}",new Object[]{"findDeptSearchList",times});
        return sortedTree;
    }

    //logout 2含注销且部门内有人员的
    @Override
    public List<DeptSelectDO> getDeptSelectList(String logout, String deptType) {
        List<DeptSelectViewDO> result = deptSelectViewDao.findAll(new Specification<DeptSelectViewDO>() {
            @Override
            public Predicate toPredicate(Root<DeptSelectViewDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotEmpty(logout) && "2".equals(logout)){
                    Predicate predicate1 = criteriaBuilder.gt(root.get("personNum"), 0);
                    Predicate predicate2 = criteriaBuilder.equal(root.get("logout"), 1);
                    Predicate predicate3 = criteriaBuilder.equal(root.get("logout"), 0);
                    predicates.add(criteriaBuilder.or(criteriaBuilder.and(predicate1,predicate2),predicate3));
                }
                if (StringUtils.isNotEmpty(logout) && !"2".equals(logout)) {
                    predicates.add(criteriaBuilder.equal(root.get("logout"), Integer.valueOf(logout)));
                }
                if (StringUtils.isNotEmpty(deptType)) {
                    predicates.add(criteriaBuilder.equal(root.get("deptType"), Integer.valueOf(deptType)));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
        List<DeptSelectDO> deptSelectDOS = generatorUtil.convert(result,DeptSelectDO.class);
        Collection<DeptSelectDO> roots = Collections2.filter(deptSelectDOS, x -> x.getParentId() == null);
        for (DeptSelectDO dept : roots) {
            this.toDeptTree(dept, deptSelectDOS);
        }
        List<DeptSelectDO> sortedTree = roots.stream().sorted(Comparator.comparing(DeptSelectDO::getDeptType)).collect(Collectors.toList());
        return sortedTree;
    }

    @Override
    public List<DeptSelectDO> getDeptSelectListWithPerson(String logout, String deptType, String personId) {
        List<DeptSelectViewDO> list = deptSelectRepository.getDeptSelectList(logout,deptType,personId);
        List<DeptSelectDO> deptSelectDOS = generatorUtil.convert(list,DeptSelectDO.class);
        List<DeptSelectDO> newList = new ArrayList<>(deptSelectDOS);
        Collection<DeptSelectDO> roots = Collections2.filter(deptSelectDOS, x -> x.getParentId() == null);
        for (DeptSelectDO dept : roots) {
            newList.remove(dept);
            this.toDeptTreeNew(dept, deptSelectDOS,newList);
        }
        List<DeptSelectDO> sortedTree = roots.stream().sorted(Comparator.comparing(DeptSelectDO::getDeptType)).collect(Collectors.toList());
        for (DeptSelectDO deptSelectDO:newList){
            sortedTree.add(deptSelectDO);
        }
        return sortedTree;
    }

    @Override
    public Boolean isFirstManager(String personId) {
        Integer count = deptDao.getFirstDepManagerCount(personId);
        return count > 0?true:false;
    }

    @Override
    public Boolean isDepManager(String personId) {
        Integer count = deptDao.getSecondDepManagerCount(personId);
        return count > 0?true:false;
    }

    @Override
    public Boolean isHr(String personId) {
        Integer count = deptDao.getHrManagerCount(personId);
        return count > 0?true:false;
    }

    @Override
    public List<DeptDO> getValidDept() {
        return deptDao.findByLogout(0);
    }

    @Override
    public List<DeptWithPersonDO> getDeptWithPerson() {
        return deptWithPersonDao.findByLogout(0);
    }

    @Override
    public Boolean isLeader(String personId) {
        Integer count = deptDao.getLeaderCount(personId);
        return count > 0?true:false;
    }

    @Override
    public List<DeptDO> getDeptList(List<String> deptNameList) {
        return deptDao.findByDeptNameIn(deptNameList);
    }

    @Override
    public List<DeptDO> getChildDeptList(String parentDept, Integer logout) {
        List<DeptDO> list = deptDao.findAllByParentIdAndLogout(parentDept, logout);
        return list;
    }

    @Override
    public List<CloudschoolDeptSyncDO> findByLogout(Integer type) {
        return  cloudschoolDeptSyncDao.findByLogout(type);
    }

    @Override
    public List<DeptSelectDO> getAllValidParentDeptList() {
        return deptSelectDao.getAllValidParentDeptList();
    }

    @Override
    public List<DeptDO> getValidDeptListWithRegionDeptIds(List<String> deptIds) {
        return deptDao.getValidDeptListWithRegionDeptIds(deptIds);
    }

    @Override
    public List<DeptDO> getAllValidRegionAndSubDeptList() {
        return deptSelectRepository.getAllValidRegionAndSubDeptList();
    }


    private void toDeptTreeNew(DeptSelectDO dept, List<DeptSelectDO> result,List<DeptSelectDO> newlist) {
        String deptId = dept.getValue();
        List<DeptSelectDO> childrens = Collections2.filter(result, x -> x.getParentId() != null && x.getParentId().equals(deptId)).stream().collect(Collectors.toList());
        List<DeptSelectDO> sortedChildrens = childrens.stream().sorted(Comparator.comparing(DeptSelectDO::getSortBy)).collect(Collectors.toList());

        dept.setChildren(sortedChildrens);
        for (DeptSelectDO children : childrens) {
            newlist.remove(children);
            toDeptTreeNew(children, result,newlist);
        }

    }

    private void toDeptTree(DeptSelectDO dept, List<DeptSelectDO> result) {
        String deptId = dept.getValue();
        List<DeptSelectDO> childrens = Collections2.filter(result, x -> x.getParentId() != null && x.getParentId().equals(deptId)).stream().collect(Collectors.toList());
        List<DeptSelectDO> sortedChildrens = childrens.stream().sorted(Comparator.comparing(DeptSelectDO::getSortBy)).collect(Collectors.toList());

        dept.setChildren(sortedChildrens);
        for (DeptSelectDO children : childrens) {
            toDeptTree(children, result);
        }


    }

}
