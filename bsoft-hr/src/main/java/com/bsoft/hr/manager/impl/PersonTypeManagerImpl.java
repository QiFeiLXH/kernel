package com.bsoft.hr.manager.impl;

import com.bsoft.common.dao.primary.PublicDicDao;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.entity.primary.PublicDicDO;
import com.bsoft.common.manager.PublicDicManager;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.utils.PinyinUtil;
import com.bsoft.hr.dao.primary.*;
import com.bsoft.hr.entity.primary.*;
import com.bsoft.hr.manager.PersonFinancialViewManager;
import com.bsoft.hr.manager.PersonTypeManager;
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
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonTypeManagerImpl implements PersonTypeManager {
    @Autowired
    private PersonTypeDao personTypeDao;
    @Autowired
    private IGenerator iGenerator;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private PublicDicManager publicDicManager;
    @Autowired
    private PublicDicDao publicDicDao;
    @Autowired
    private DeptCostMaintainDao deptCostMaintainDao;
    @Autowired
    private PostAndCostRuleDao postAndCostRuleDao;
    @Autowired
    private PersonFinancialViewDao personFinancialViewDao;
    @Autowired
    private ClockInModeDeptInfoDao clockInModeDeptInfoDao;
    @Autowired
    private PersonFinancialMaintainDao personFinancialMaintainDao;

    @Override
    public void addPersonType(String userId,PublicDicDO publicDicDO) {
        //当前登录日期
        Date serverDate = serverDateManager.getServerDate();
        publicDicDO.setRegisterDate(serverDate);
        publicDicDO.setRegistrant(userId);
        publicDicDO.setType(3012);
        Integer i = publicDicDao.selectMaxId();
        System.out.println(i);
        String firstSpell = PinyinUtil.getFirstSpell(publicDicDO.getName());
        publicDicDO.setPinyin(firstSpell);
        publicDicDO.setId(i);
        personTypeDao.save(publicDicDO);
    }

    @Override
    public void updatePersonType(String userId, PublicDicDO cnd) {
        PublicDicDO publicDicDO = publicDicDao.findByTypeAndId(3012,cnd.getId());
        if(publicDicDO!=null){
            personTypeDao.updatePersonType(publicDicDO.getType(),
                    publicDicDO.getId(),
                    publicDicDO.getName(),
                    publicDicDO.getPersonflag());
        }
    }

    @Override
    public Page<PublicDicDO> getPersonTypeList(Integer pageNo, Integer pageSize,Integer type,Integer personflag) {
        Sort sort = Sort.by("id").ascending();
        if(pageNo==null&&pageSize==null){
            pageNo=1;
            pageSize=25;
        }
        Pageable pageable = PageRequest.of(pageNo-1,pageSize,sort);
        Page<PublicDicDO> pages = publicDicDao.findAll(new Specification<PublicDicDO>() {   
            @Override
            public Predicate toPredicate(Root<PublicDicDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(type!=null){
                    predicates.add(criteriaBuilder.equal(root.get("type"), type));
                }
                if(personflag!=null){
                    predicates.add(criteriaBuilder.equal(root.get("personflag"), personflag));
                }
                    predicates.add(criteriaBuilder.gt(root.get("id"), 0));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return pages;
    }

    @Override
    public boolean ifFinancialType(Integer id) {
        List<DeptCostMaintainDO> deptFinancialList = deptCostMaintainDao.findByFinancial(id);
        List<PostAndCostRuleDO> postAndCostLisy = postAndCostRuleDao.findByFinancial(id);
        List<PersonFinancialViewDO> personFinancialViewDOS = personFinancialViewDao.findByFinancial(id);
        //筛选出正在使用的部门财务类别
        List<ClockInModeDeptInfoDO> newclockInModeDeptInfoDOS = new ArrayList<>();
        List<ClockInModeDeptInfoDO> clockInModeDeptInfoDOS = clockInModeDeptInfoDao.findByLogout();
        clockInModeDeptInfoDOS.forEach(clockInModeDeptInfoDO -> {
            deptFinancialList.forEach(deptCostMaintainDO -> {
                if(clockInModeDeptInfoDO.getDept().equals(deptCostMaintainDO.getDept())&&
                clockInModeDeptInfoDO.getPersonTypeFlag()==deptCostMaintainDO.getType()){
                    newclockInModeDeptInfoDOS.add(clockInModeDeptInfoDO);
                }
            });
            clockInModeDeptInfoDO.getDept();

        });
        //        List<PersonFinancialMaintainDO>  PersonFinancialMaintainDOS = personFinancialMaintainDao.findByFinancial(id);
        if(newclockInModeDeptInfoDOS.size()!=0||postAndCostLisy.size()!=0||personFinancialViewDOS.size()!=0){
            //该财务类别已被使用
            return false;
        }
        return true;
    }
}
