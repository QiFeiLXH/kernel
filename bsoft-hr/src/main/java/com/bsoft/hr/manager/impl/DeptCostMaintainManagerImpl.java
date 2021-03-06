package com.bsoft.hr.manager.impl;

import com.bsoft.common.dao.primary.HumanDicDao;
import com.bsoft.common.dao.primary.PublicDicDao;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.entity.primary.HumanDicDO;
import com.bsoft.common.entity.primary.PublicDicDO;
import com.bsoft.hr.condition.ClockInModeQueryCnd;
import com.bsoft.hr.condition.DeptMaintainInfoQueryCnd;
import com.bsoft.hr.dao.primary.*;
import com.bsoft.hr.dto.DeptCostMaintainDTO;
import com.bsoft.hr.dto.DeptMaintainInfoQueryCndDTO;
import com.bsoft.hr.dto.PersonFinancialMaintainDTO;
import com.bsoft.hr.dto.PostAndCostRuleDTO;
import com.bsoft.hr.entity.primary.*;
import com.bsoft.hr.manager.DeptCostMaintainManager;
import com.bsoft.hr.manager.PersonFinancialMaintainManager;
import com.google.common.collect.Collections2;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DeptCostMaintainManagerImpl  implements DeptCostMaintainManager {

    @Autowired
    private DeptCostMaintainDao deptCostMaintainDao;

    @Autowired
    private IGenerator iGenerator;

    @Autowired
    private PublicDicDao publicDicDao;

    @Autowired
    private HumanDicDao humanDicDao;

    @Autowired
    private ClockInModeDeptInfoDao clockInModeDeptInfoDao;
    @Autowired
    private ClockInModePersonalInfoDao clockInModePersonalInfoDao;
    @Autowired
    private PersonDeptMaintainViewDao personDeptMaintainViewDao;
    @Autowired
    private PostAndCostRuleDao postAndCostRuleDao;


    @Autowired
    private PersonFinancialMaintainManager personFinancialMaintainManager;
    @Override
    public List<String> getDeptList() {
        return deptCostMaintainDao.getDeptList();
    }

    @Override
    @Transactional
    public boolean updateDeptCost(String userId,DeptCostMaintainDO deptCostMaintainDO) {
        try {
            PublicDicDO allByTypeAndFlag = null;
            if(deptCostMaintainDO.getDept()!=null){
                 allByTypeAndFlag = publicDicDao.findByDeptlogout(Integer.valueOf(deptCostMaintainDO.getFinancialType()));
            }
            if(allByTypeAndFlag==null){
                //????????????????????????
                this.insertDeptRecord(userId,deptCostMaintainDO);
                //?????????????????????????????????????????????????????????
                List<String> deptList = new ArrayList<>();
                DeptCostMaintainDO convert = iGenerator.convert(deptCostMaintainDO, DeptCostMaintainDO.class);
                deptList.add(deptCostMaintainDO.getDept());
                List<PersonDeptMaintainViewDO> result = personDeptMaintainViewDao.findByParentDeptIn(deptList);
                Collection<PersonDeptMaintainViewDO> children = Collections2.filter(result, x -> x.getLogout() == 0);
//            List<DeptCostMaintainDO> personDeptMaintainViewDOChildren  = new ArrayList<>();
                for(PersonDeptMaintainViewDO personDeptMaintainViewDO:children){
                    //?????????????????????
                    deptCostMaintainDO.setDept(personDeptMaintainViewDO.getDept());
                    //???????????????????????????????????????????????????????????????
                    List<DeptCostMaintainDO> deptCostMaintainDOS = deptCostMaintainDao.selectWithDept(personDeptMaintainViewDO.getDept(), 1);
                    List<DeptCostMaintainDO> deptPostCostMaintainDOS = deptCostMaintainDao.selectWithDept(personDeptMaintainViewDO.getDept(),2);
                    if(deptCostMaintainDOS.size()==0&&deptPostCostMaintainDOS.size()==0){
                        this.insertDeptRecord(userId,deptCostMaintainDO);
                    }
                }
                return true;
            }else {
                return false;
            }
        }catch (Exception exception){
            exception.getMessage();
            return false;
        }
    }
    @Override
    @Transactional
    public List<String> updatePostCost(String userId,List<DeptCostMaintainDO> deptCostMaintainDOList) {
        List<String> financiallists = new ArrayList<>();
        deptCostMaintainDOList.forEach(deptCostMaintainDTO -> {
            PublicDicDO allByTypeAndFlag = publicDicDao.findByDeptlogout(Integer.valueOf(deptCostMaintainDTO.getFinancialType()));
            if(allByTypeAndFlag!=null){
                financiallists.add(allByTypeAndFlag.getName());
            }
        });
        if(financiallists.size()==0){
            //??????????????????????????????
            this.insertPostRecord(userId,deptCostMaintainDOList);
            for(DeptCostMaintainDO deptCostMaintainDO:deptCostMaintainDOList){
                deptCostMaintainDO.setType(2);
            }
            //?????????????????????????????????
            List<DeptCostMaintainDO> convert = iGenerator.convert(deptCostMaintainDOList, DeptCostMaintainDO.class);
            deptCostMaintainDao.saveAll(convert);
            //?????????????????????????????????????????????????????????
            List<String> deptList = new ArrayList<>();
            convert.forEach(parent -> {
                deptList.add(parent.getDept());
            });
            List<PersonDeptMaintainViewDO> result = personDeptMaintainViewDao.findByParentDeptIn(deptList);
            Collection<PersonDeptMaintainViewDO> children = Collections2.filter(result, x -> x.getLogout() == 0);
            //???????????????????????????????????????????????????
            for (PersonDeptMaintainViewDO PersonDeptMaintainViewDO : children) {
                List<DeptCostMaintainDO> deptCostMaintainDOS = deptCostMaintainDao.selectWithDept(PersonDeptMaintainViewDO.getDept(),2);
                List<DeptCostMaintainDO> deptPostCostMaintainDOS = deptCostMaintainDao.selectWithDept(PersonDeptMaintainViewDO.getDept(),1);
                //??????????????????????????????????????????????????????????????????
                if(deptCostMaintainDOS.size()==0&&deptPostCostMaintainDOS.size()==0){
                    //???????????????????????????????????????????????????
                    deptCostMaintainDOList.forEach(deptCostMaintainDTO -> {
                        deptCostMaintainDTO.setDept(PersonDeptMaintainViewDO.getDept());
                    });
                    //??????????????????
                    this.insertPostRecord(userId,deptCostMaintainDOList);
                    deptCostMaintainDao.saveAll(iGenerator.convert(deptCostMaintainDOList,DeptCostMaintainDO.class));
                    //??????????????????????????????
                    clockInModeDeptInfoDao.updatePersonType(PersonDeptMaintainViewDO.getDept(),2);
                }
            }
            return financiallists;
        }else return financiallists;

//            children.forEach(PersonDeptMaintainViewDO->{
//
//            });

//            List<DeptCostMaintainDO> personDeptMaintainViewDOChildren  = new ArrayList<>();
//            for(PersonDeptMaintainViewDO personDeptMaintainViewDO:children){
//                        convert.forEach(deptCostMaintainDO->{
//                        deptCostMaintainDO.setDept(personDeptMaintainViewDO.getDept());
//                        personDeptMaintainViewDOChildren.add(deptCostMaintainDO);
//                    });
//                }
//            //???????????????????????????
//            List<DeptCostMaintainDTO> childrenConvert = iGenerator.convert(personDeptMaintainViewDOChildren, DeptCostMaintainDTO.class);
//            this.insertPostRecord(userId,childrenConvert);

    }

    @Override
    public List<DeptCostMaintainDTO> selectWithDept(String Dept) {
        List<DeptCostMaintainDO> deptCostMaintainDOS = deptCostMaintainDao.selectWithDept(Dept,2);
        List<DeptCostMaintainDO> deptCostMaintainNewListDO = new ArrayList<>();
        List<DeptCostMaintainDTO> convert = null;
        //????????????????????????????????????????????????????????????????????????????????????
        if(deptCostMaintainDOS.size()==0){
            List<PostAndCostRuleDO> postAndCostRuleDOall = postAndCostRuleDao.findAll();
            for(PostAndCostRuleDO postAndCostRuleDO:postAndCostRuleDOall){
                DeptCostMaintainDO deptCostMaintainDO = new DeptCostMaintainDO();
                deptCostMaintainDO.setPostType(postAndCostRuleDO.getPostType());
                deptCostMaintainDO.setFinancialType(postAndCostRuleDO.getFinancialType());
                deptCostMaintainNewListDO.add(deptCostMaintainDO);
            }
//            deptCostMaintainDao.saveAll(deptCostMaintainNewListDO);
             convert = iGenerator.convert(deptCostMaintainNewListDO, DeptCostMaintainDTO.class);
        }else{
          //???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
            List<DeptCostMaintainDO> newDeptCosts = new ArrayList<>();
            List<PostAndCostRuleDO> postAndCostRuleDaoAll = postAndCostRuleDao.findAll();
            Map<PostAndCostRuleDO,Integer> map  = new HashMap<>();
            for(PostAndCostRuleDO postAndCostRuleDO :postAndCostRuleDaoAll){
                map.put(postAndCostRuleDO,1);
            }
            postAndCostRuleDaoAll.forEach(postAndCostRuleDO -> {
                deptCostMaintainDOS.forEach(deptCostMaintainDO -> {
                    if(postAndCostRuleDO.getPostType().equals(deptCostMaintainDO.getPostType())) {
                        map.put(postAndCostRuleDO, 2);
                    }
                });
            });
            //??????value=2???entry???????????????????????????????????????
            for(Map.Entry<PostAndCostRuleDO, Integer> entry : map.entrySet()){
                    if(entry.getValue()==1){
                        DeptCostMaintainDO maintainDO =new DeptCostMaintainDO();
                        maintainDO.setPostType(entry.getKey().getPostType());
                        maintainDO.setFinancialType(entry.getKey().getFinancialType());
                        newDeptCosts.add(maintainDO);
                    }
            }

            for (DeptCostMaintainDO deptCostMaintainDO :deptCostMaintainDOS){
                newDeptCosts.add(deptCostMaintainDO);
            }
            //?????????????????????
            Collections.sort(newDeptCosts, Comparator.comparing(DeptCostMaintainDO::getPostType));
             convert = iGenerator.convert(newDeptCosts, DeptCostMaintainDTO.class);
        }
        /** ???financialName??????DTO??????*/
        List<PublicDicDO> allByTypeAndFlag = publicDicDao.findByType(3012);
        List<PublicDicDO> newallByTypeAndFlag = new ArrayList<>();
        for(PublicDicDO publicDicDO:allByTypeAndFlag){
            if(publicDicDO.getPersonflag()==0&&publicDicDO.getId()!=0){
                newallByTypeAndFlag.add(publicDicDO);
            }
        }
        for (DeptCostMaintainDTO deptCostMaintainDTO:convert) {
            for (PublicDicDO publicDicDO:newallByTypeAndFlag) {
                if(publicDicDO.getId().equals(deptCostMaintainDTO.getFinancialType())){
                    deptCostMaintainDTO.setFinancialName(publicDicDO.getName());
                }
            }
        }

        /** ???postName??????DTO??????*/
        List<HumanDicDO> humanDicDOList = humanDicDao.findAllByTypeAndIdNotOrderByIdAsc(2,0);
        for (DeptCostMaintainDTO deptCostMaintainDTO:convert) {
            for (HumanDicDO humanDicDO:humanDicDOList) {
                if(deptCostMaintainDTO.getPostType()==humanDicDO.getId()){
                    deptCostMaintainDTO.setPostName(humanDicDO.getName());
                }
            }
        }
        return convert ;
    }

    @Override
    public DeptCostMaintainDO getDeptFinancialType(String dept) {
        return deptCostMaintainDao.getDeptFinancialType(dept, 1);
    }

    @Override
    public Page<PersonDeptMaintainViewDO> listDeptInfoWithPage(DeptMaintainInfoQueryCnd queryCnd) {
        String dept = queryCnd.getDept();
        String deptType = queryCnd.getDeptType();
        Integer pageNo = queryCnd.getPageNo();
        Integer pageSize = queryCnd.getPageSize();
        Sort sort = Sort.by("sortBy").ascending();
//        List<String> deptList = deptCostMaintainDao.getDeptList();
//        List<String> disDeptMaintainList= deptList.stream().distinct().collect(Collectors.toList());
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        Page<PersonDeptMaintainViewDO> page = personDeptMaintainViewDao.findAll(new Specification<PersonDeptMaintainViewDO>() {
            @Override
            public Predicate toPredicate(Root<PersonDeptMaintainViewDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("logout"), 0));// ????????????????????????
                if (StringUtils.isNotEmpty(deptType)) {
                    predicates.add(criteriaBuilder.equal(root.get("deptType"), Integer.valueOf(deptType)));
                }

                    if (StringUtils.isNotEmpty(dept)) {// ??????????????????id?????????id??????
                        predicates.add(criteriaBuilder.equal(root.get("dept"), dept));
                    } else {// ????????????id???????????????????????????
                        predicates.add(criteriaBuilder.isNull(root.get("parentDept")));
                    }
                 if(queryCnd.getMaintain()==0){
                     predicates.add(criteriaBuilder.equal(root.get("flag"),0));
                 }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return page;
    }

    @Override
    public List<PersonDeptMaintainViewDO> listChildDeptInfo(List<PersonDeptMaintainViewDO> parentList) {
        List<String> deptList = new ArrayList<>();
        parentList.forEach(parent -> {
            deptList.add(parent.getDept());
        });
        List<PersonDeptMaintainViewDO> result = personDeptMaintainViewDao.findByParentDeptIn(deptList);
        Collection<PersonDeptMaintainViewDO> children = Collections2.filter(result, x -> x.getLogout() == 0);
        return new ArrayList<>(children);
    }

    @Override
    public void updateDeptInfoWithPage(String dept,Integer personTypeFlag) {
        clockInModeDeptInfoDao.updatePersonType(dept,personTypeFlag);
    }

    @Override
    public List<DeptCostMaintainDO> getFindAll() {
        return iGenerator.convert(clockInModeDeptInfoDao.findAll(),DeptCostMaintainDO.class);
    }


    public void insertPostRecord (String userId,List<DeptCostMaintainDO> deptCostMaintainDOList){
        List<PersonFinancialMaintainDO> personFinancialMaintainDOList = new ArrayList<>();
//        try{
//        Collection<DeptCostMaintainDTO> filter = Collections2.filter(deptCostMaintainDTOList, x -> x.getId() != null);
//        //??????????????????????????????????????????????????????????????????????????????
//        if(filter.size()!=0){
//
//        }
        deptCostMaintainDOList.forEach(deptCostMaintainDTO -> {
            Integer id = deptCostMaintainDTO.getId();
//            Integer attendFlag = personalInfoDO.getAttendFlagPersonal();
            //??????????????????.
            PersonFinancialMaintainDO personFinancialMaintainDO = new PersonFinancialMaintainDO();
            personFinancialMaintainDO.setType(2);
            personFinancialMaintainDO.setDept(deptCostMaintainDTO.getDept());
            personFinancialMaintainDO.setPostType(deptCostMaintainDTO.getPostType());
            personFinancialMaintainDO.setAdjustDate(deptCostMaintainDTO.getAdjustDate());
            personFinancialMaintainDO.setFinancialTypeAfter(deptCostMaintainDTO.getFinancialType());
            personFinancialMaintainDOList.add(personFinancialMaintainDO);
            if(id!=null) {
                //ID??????????????????????????????????????????????????????????????????????????????????????????????????????
                Optional<DeptCostMaintainDO> result = deptCostMaintainDao.findById(id);
                DeptCostMaintainDO saveDO = result.get();
//                resultList.add(saveDO);
                personFinancialMaintainDO.setFinancialTypeNow(saveDO.getFinancialType());
            }
            //??????????????????????????????
            clockInModeDeptInfoDao.updatePersonType(deptCostMaintainDTO.getDept(),2);

        });
        //??????????????????
        personFinancialMaintainManager.insertInfo(userId,personFinancialMaintainDOList);

    }

    public  void insertDeptRecord(String userId,DeptCostMaintainDO deptCostMaintainDO){
        String dept = deptCostMaintainDO.getDept();
        PersonFinancialMaintainDO personFinancialMaintainDeptDTO = new PersonFinancialMaintainDO();
//            Integer attendFlag = personalInfoDO.getAttendFlagPersonal();
        if(dept!=null){
            List<DeptCostMaintainDO> deptCostMaintainDOS = deptCostMaintainDao.selectWithDept(dept,1);

            //?????????????????????????????????????????????????????????
            if(deptCostMaintainDOS.size()!=0){
                DeptCostMaintainDO saveDO = deptCostMaintainDOS.get(0);
                deptCostMaintainDao.updateDeptCost(deptCostMaintainDO.getDept(),
                        1,
                        deptCostMaintainDO.getFinancialType(),
                        deptCostMaintainDO.getAdjustDate());
                //ID??????????????????????????????????????????????????????????????????????????????????????????????????????
                personFinancialMaintainDeptDTO.setFinancialTypeNow(saveDO.getFinancialType());
            }else{
                DeptCostMaintainDO convert = iGenerator.convert(deptCostMaintainDO, DeptCostMaintainDO.class);
                deptCostMaintainDao.save(convert);
            }
        }else{
//                deptCostMaintainDao.deleteFromDeptCostwithType(deptCostMaintainDTO.getDept(),2);
            deptCostMaintainDao.save(deptCostMaintainDO);
        }
        //??????????????????????????????
        clockInModeDeptInfoDao.updatePersonType(deptCostMaintainDO.getDept(),1);
        //??????????????????
        List<PersonFinancialMaintainDO> personFinancialMaintainDTO = new ArrayList<>();
        personFinancialMaintainDeptDTO.setType(1);
        personFinancialMaintainDeptDTO.setDept(deptCostMaintainDO.getDept());
        personFinancialMaintainDeptDTO.setAdjustDate(deptCostMaintainDO.getAdjustDate());
        personFinancialMaintainDeptDTO.setFinancialTypeAfter(deptCostMaintainDO.getFinancialType());
        personFinancialMaintainDTO.add(personFinancialMaintainDeptDTO);
        personFinancialMaintainManager.insertInfo(userId,personFinancialMaintainDTO);
    }
}
