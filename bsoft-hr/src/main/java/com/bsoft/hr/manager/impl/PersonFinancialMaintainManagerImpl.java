package com.bsoft.hr.manager.impl;

import com.bsoft.common.dao.primary.PublicDicDao;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.entity.primary.PublicDicDO;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.DateUtils;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.hr.condition.HrFeeRulesRecordQueryCnd;
import com.bsoft.hr.dao.primary.PersonFinancialMaintainDao;
import com.bsoft.hr.dao.primary.PersonNameDao;
import com.bsoft.hr.dto.HrFeeRulesRecordCndDTO;
import com.bsoft.hr.dto.HrFeeRulesRecordDTO;
import com.bsoft.hr.dto.PersonFinancialMaintainDTO;
import com.bsoft.hr.dto.PersonFinancialViewDTO;
import com.bsoft.hr.entity.primary.PersonFinancialMaintainDO;
import com.bsoft.hr.entity.primary.PersonFinancialViewDO;
import com.bsoft.hr.entity.primary.PersonNameDO;
import com.bsoft.hr.manager.PersonFinancialMaintainManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonFinancialMaintainManagerImpl implements PersonFinancialMaintainManager {
    @Autowired
    private PersonFinancialMaintainDao personFinancialMaintainDao;
    @Autowired
    private PublicDicDao publicDicDao;
    @Autowired
    private PersonNameDao personNameDao;
    @Autowired
    private IGenerator iGenerator;
    @Autowired
    private ServerDateManager serverDateManager;
    @Override
    public void insertInfo(String userId,List<PersonFinancialMaintainDO> personFinancialMaintainDOS) {
        //当前登录日期
        Date serverDate = serverDateManager.getServerDate();
        personFinancialMaintainDOS.forEach(personFinancialMaintainDO->{
            personFinancialMaintainDO.setRegistrant(userId);
            personFinancialMaintainDO.setRegistrantionDate(serverDate);
        });

        personFinancialMaintainDao.saveAll(personFinancialMaintainDOS);
    }



    @Override
    public Result<HrFeeRulesRecordDTO> getHrFeeRulesRecordList(String userId, HrFeeRulesRecordQueryCnd cndDTO) {
        String personId = cndDTO.getPersonId();
        String xusName = cndDTO.getXusName();
        String dept = cndDTO.getDept();
        Integer type = 3;
        Integer pageNo = cndDTO.getPageNo();
        Integer pageSize = cndDTO.getPageSize();
        Sort sort = Sort.by("registrantionDate").descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        Page<PersonFinancialMaintainDO> page = personFinancialMaintainDao.findAll(new Specification<PersonFinancialMaintainDO>() {
            @Override
            public Predicate toPredicate(Root<PersonFinancialMaintainDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
//                if (StringUtils.isNotEmpty(personId)) {// 如果传了type则根据type类型查找
//                    predicates.add(criteriaBuilder.equal(root.get("type"),type));// 只查询特殊维护人员
//                }
                if (StringUtils.isNotEmpty(personId)) {// 如果传了员工id则根据员工id查找
                    predicates.add(criteriaBuilder.equal(root.get("personId"), personId));
                }
                if (StringUtils.isNotEmpty(dept)) {// 如果传了部门id则根据id查找
                    predicates.add(criteriaBuilder.equal(root.get("dept"), dept));
                }

                if (StringUtils.isNotEmpty(xusName)) {// 如果传了姓名则根据姓名查找
                    predicates.add(criteriaBuilder.equal(root.get("xusName"), xusName));
                }
                //查找特殊人员调整
                predicates.add(criteriaBuilder.equal(root.get("type"), type));

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        Result<HrFeeRulesRecordDTO> result = ResultUtils.parseResult(page, HrFeeRulesRecordDTO.class);

        List<HrFeeRulesRecordDTO> items = result.getItems();
        /** 将financialName插入DTO返回*/
        List<PublicDicDO> allByTypeAndFlag = publicDicDao.findByType(3012);
        List<PublicDicDO> newallByTypeAndFlag = new ArrayList<>();
        for(PublicDicDO publicDicDO:allByTypeAndFlag){
            if(publicDicDO.getId()!=0){
                newallByTypeAndFlag.add(publicDicDO);
            }
        }
        for (HrFeeRulesRecordDTO hrFeeRulesRecordDTO:items) {
            for (PublicDicDO publicDicDO:newallByTypeAndFlag) {
                if(publicDicDO.getId().equals(hrFeeRulesRecordDTO.getFinancialTypeNow())){
                    hrFeeRulesRecordDTO.setFinancialNameNow(publicDicDO.getName());
                }
            }
        }
        for (HrFeeRulesRecordDTO hrFeeRulesRecordDTO:items) {
            for (PublicDicDO publicDicDO:newallByTypeAndFlag) {
                if(publicDicDO.getId().equals(hrFeeRulesRecordDTO.getFinancialTypeAfter())){
                    hrFeeRulesRecordDTO.setFinancialNameAfter(publicDicDO.getName());
                }
            }
        }
        //给登记人名字赋值
        items.forEach(hrFeeRulesRecordDTO -> {
//            String id = hrFeeRulesRecordDTO.getPersonId();
            Optional<PersonNameDO> personNameDaoById = personNameDao.findById(hrFeeRulesRecordDTO.getRegistrant());
            PersonNameDO personNameDO=personNameDaoById.get();
            hrFeeRulesRecordDTO.setRegistrantName(personNameDO.getXUSNAME());
//            //将时间转成YYYY-MM格式
//            Date adjustDate = hrFeeRulesRecordDTO.getAdjustDate();
//            try {
//                hrFeeRulesRecordDTO.setAdjustDate(DateUtils.stringToDate(DateUtils.dateToString(adjustDate,"YYYY-MM"),"YYYY-MM"));
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }

        });
        result.setItems(items);
        return result;
    }
}
