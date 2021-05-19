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
                //一级部门更新维护
                this.insertDeptRecord(userId,deptCostMaintainDO);
                //更新一级部门后同时更新一级部门下子部门
                List<String> deptList = new ArrayList<>();
                DeptCostMaintainDO convert = iGenerator.convert(deptCostMaintainDO, DeptCostMaintainDO.class);
                deptList.add(deptCostMaintainDO.getDept());
                List<PersonDeptMaintainViewDO> result = personDeptMaintainViewDao.findByParentDeptIn(deptList);
                Collection<PersonDeptMaintainViewDO> children = Collections2.filter(result, x -> x.getLogout() == 0);
//            List<DeptCostMaintainDO> personDeptMaintainViewDOChildren  = new ArrayList<>();
                for(PersonDeptMaintainViewDO personDeptMaintainViewDO:children){
                    //子部门更新维护
                    deptCostMaintainDO.setDept(personDeptMaintainViewDO.getDept());
                    //查询子部门下是否有维护记录，有的话不作更新
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
            //新增一级部门调整记录
            this.insertPostRecord(userId,deptCostMaintainDOList);
            for(DeptCostMaintainDO deptCostMaintainDO:deptCostMaintainDOList){
                deptCostMaintainDO.setType(2);
            }
            //更新一级部门岗位维护表
            List<DeptCostMaintainDO> convert = iGenerator.convert(deptCostMaintainDOList, DeptCostMaintainDO.class);
            deptCostMaintainDao.saveAll(convert);
            //更新一级部门后同时更新一级部门下子部门
            List<String> deptList = new ArrayList<>();
            convert.forEach(parent -> {
                deptList.add(parent.getDept());
            });
            List<PersonDeptMaintainViewDO> result = personDeptMaintainViewDao.findByParentDeptIn(deptList);
            Collection<PersonDeptMaintainViewDO> children = Collections2.filter(result, x -> x.getLogout() == 0);
            //查找子部门下是否存在按岗位维护记录
            for (PersonDeptMaintainViewDO PersonDeptMaintainViewDO : children) {
                List<DeptCostMaintainDO> deptCostMaintainDOS = deptCostMaintainDao.selectWithDept(PersonDeptMaintainViewDO.getDept(),2);
                List<DeptCostMaintainDO> deptPostCostMaintainDOS = deptCostMaintainDao.selectWithDept(PersonDeptMaintainViewDO.getDept(),1);
                //子部门存在数据的话则不更新，不存在则直接插入
                if(deptCostMaintainDOS.size()==0&&deptPostCostMaintainDOS.size()==0){
                    //将子部门的部门代码赋值给传入的参数
                    deptCostMaintainDOList.forEach(deptCostMaintainDTO -> {
                        deptCostMaintainDTO.setDept(PersonDeptMaintainViewDO.getDept());
                    });
                    //新增调整记录
                    this.insertPostRecord(userId,deptCostMaintainDOList);
                    deptCostMaintainDao.saveAll(iGenerator.convert(deptCostMaintainDOList,DeptCostMaintainDO.class));
                    //更新部门财务调整标志
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
//            //新增子部门调整记录
//            List<DeptCostMaintainDTO> childrenConvert = iGenerator.convert(personDeptMaintainViewDOChildren, DeptCostMaintainDTO.class);
//            this.insertPostRecord(userId,childrenConvert);

    }

    @Override
    public List<DeptCostMaintainDTO> selectWithDept(String Dept) {
        List<DeptCostMaintainDO> deptCostMaintainDOS = deptCostMaintainDao.selectWithDept(Dept,2);
        List<DeptCostMaintainDO> deptCostMaintainNewListDO = new ArrayList<>();
        List<DeptCostMaintainDTO> convert = null;
        //若部门未进行维护，则默认显示岗位对应的财务类别，待维护。
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
          //如果部门已经维护，则需要看岗位费用规则里有没有新增的岗位大类，有的话需要新增进来进行维护。
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
            //找到value=2的entry，其为新增的岗位费用规则。
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
            //按岗位大类排序
            Collections.sort(newDeptCosts, Comparator.comparing(DeptCostMaintainDO::getPostType));
             convert = iGenerator.convert(newDeptCosts, DeptCostMaintainDTO.class);
        }
        /** 将financialName插入DTO返回*/
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

        /** 将postName插入DTO返回*/
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
                predicates.add(criteriaBuilder.equal(root.get("logout"), 0));// 只查询未注销部门
                if (StringUtils.isNotEmpty(deptType)) {
                    predicates.add(criteriaBuilder.equal(root.get("deptType"), Integer.valueOf(deptType)));
                }

                    if (StringUtils.isNotEmpty(dept)) {// 如果传了部门id则根据id查找
                        predicates.add(criteriaBuilder.equal(root.get("dept"), dept));
                    } else {// 未传部门id则查询所有一级部门
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
//        //已存在按照岗位维护的记录就进行更新，未存在则直接插入
//        if(filter.size()!=0){
//
//        }
        deptCostMaintainDOList.forEach(deptCostMaintainDTO -> {
            Integer id = deptCostMaintainDTO.getId();
//            Integer attendFlag = personalInfoDO.getAttendFlagPersonal();
            //新增调整记录.
            PersonFinancialMaintainDO personFinancialMaintainDO = new PersonFinancialMaintainDO();
            personFinancialMaintainDO.setType(2);
            personFinancialMaintainDO.setDept(deptCostMaintainDTO.getDept());
            personFinancialMaintainDO.setPostType(deptCostMaintainDTO.getPostType());
            personFinancialMaintainDO.setAdjustDate(deptCostMaintainDTO.getAdjustDate());
            personFinancialMaintainDO.setFinancialTypeAfter(deptCostMaintainDTO.getFinancialType());
            personFinancialMaintainDOList.add(personFinancialMaintainDO);
            if(id!=null) {
                //ID不为空即为原来的财务类别不为空，则将前调整后财务类别赋值给现财务类别
                Optional<DeptCostMaintainDO> result = deptCostMaintainDao.findById(id);
                DeptCostMaintainDO saveDO = result.get();
//                resultList.add(saveDO);
                personFinancialMaintainDO.setFinancialTypeNow(saveDO.getFinancialType());
            }
            //更新部门财务维护标志
            clockInModeDeptInfoDao.updatePersonType(deptCostMaintainDTO.getDept(),2);

        });
        //新增调整记录
        personFinancialMaintainManager.insertInfo(userId,personFinancialMaintainDOList);

    }

    public  void insertDeptRecord(String userId,DeptCostMaintainDO deptCostMaintainDO){
        String dept = deptCostMaintainDO.getDept();
        PersonFinancialMaintainDO personFinancialMaintainDeptDTO = new PersonFinancialMaintainDO();
//            Integer attendFlag = personalInfoDO.getAttendFlagPersonal();
        if(dept!=null){
            List<DeptCostMaintainDO> deptCostMaintainDOS = deptCostMaintainDao.selectWithDept(dept,1);

            //已存在就更新，未存在则新增按部门更新，
            if(deptCostMaintainDOS.size()!=0){
                DeptCostMaintainDO saveDO = deptCostMaintainDOS.get(0);
                deptCostMaintainDao.updateDeptCost(deptCostMaintainDO.getDept(),
                        1,
                        deptCostMaintainDO.getFinancialType(),
                        deptCostMaintainDO.getAdjustDate());
                //ID不为空即为原来的财务类别不为空，则将前调整后财务类别赋值给现财务类别
                personFinancialMaintainDeptDTO.setFinancialTypeNow(saveDO.getFinancialType());
            }else{
                DeptCostMaintainDO convert = iGenerator.convert(deptCostMaintainDO, DeptCostMaintainDO.class);
                deptCostMaintainDao.save(convert);
            }
        }else{
//                deptCostMaintainDao.deleteFromDeptCostwithType(deptCostMaintainDTO.getDept(),2);
            deptCostMaintainDao.save(deptCostMaintainDO);
        }
        //更新部门财务调整标志
        clockInModeDeptInfoDao.updatePersonType(deptCostMaintainDO.getDept(),1);
        //新增调整记录
        List<PersonFinancialMaintainDO> personFinancialMaintainDTO = new ArrayList<>();
        personFinancialMaintainDeptDTO.setType(1);
        personFinancialMaintainDeptDTO.setDept(deptCostMaintainDO.getDept());
        personFinancialMaintainDeptDTO.setAdjustDate(deptCostMaintainDO.getAdjustDate());
        personFinancialMaintainDeptDTO.setFinancialTypeAfter(deptCostMaintainDO.getFinancialType());
        personFinancialMaintainDTO.add(personFinancialMaintainDeptDTO);
        personFinancialMaintainManager.insertInfo(userId,personFinancialMaintainDTO);
    }
}
