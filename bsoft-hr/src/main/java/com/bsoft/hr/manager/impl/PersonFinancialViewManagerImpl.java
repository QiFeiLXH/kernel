package com.bsoft.hr.manager.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.hr.condition.PersonFinancialViewQueryCnd;
import com.bsoft.hr.dao.primary.PersonAttributeDao;
import com.bsoft.hr.dao.primary.PersonFinancialMaintainDao;
import com.bsoft.hr.dao.primary.PersonFinancialViewDao;
import com.bsoft.hr.dto.PersonFinancialMaintainDTO;
import com.bsoft.hr.dto.PersonFinancialViewDTO;
import com.bsoft.hr.entity.primary.ClockInModeDeptInfoDO;
import com.bsoft.hr.entity.primary.PersonFinancialMaintainDO;
import com.bsoft.hr.entity.primary.PersonFinancialViewDO;
import com.bsoft.hr.manager.PersonFinancialMaintainManager;
import com.bsoft.hr.manager.PersonFinancialViewManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonFinancialViewManagerImpl implements PersonFinancialViewManager {
    @Autowired
    private PersonFinancialViewDao personFinancialViewDao;

    @Autowired
    private IGenerator iGenerator;

    @Autowired
    private PersonAttributeDao personAttributeDao;


    @Override
    public Page<PersonFinancialViewDO> getPersonFinancialList(PersonFinancialViewQueryCnd personFinancialViewDTO) {
        String personId = personFinancialViewDTO.getPersonId();
        String xusName = personFinancialViewDTO.getXusName();
        String dept = personFinancialViewDTO.getDept();
        Integer flag = 0;
//        Integer type = personFinancialViewDTO.getType();
        Integer financialTypeNow = personFinancialViewDTO.getFinancialTypeFind();
        Integer pageNo = personFinancialViewDTO.getPageNo();
        Integer pageSize = personFinancialViewDTO.getPageSize();
        Sort sort = Sort.by("personId").ascending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        Page<PersonFinancialViewDO> page = personFinancialViewDao.findAll(new Specification<PersonFinancialViewDO>() {
            @Override
            public Predicate toPredicate(Root<PersonFinancialViewDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
//                if (StringUtils.isNotEmpty(personId)) {// ????????????type?????????type????????????
//                    predicates.add(criteriaBuilder.equal(root.get("type"),type));// ???????????????????????????
//                }
                if (StringUtils.isNotEmpty(personId)) {// ??????????????????id???????????????id??????
                    predicates.add(criteriaBuilder.equal(root.get("personId"), personId));
                }
                if (StringUtils.isNotEmpty(dept)) {// ??????????????????id?????????id??????
                    predicates.add(criteriaBuilder.equal(root.get("dept"), dept));
                }

                if (StringUtils.isNotEmpty(xusName)) {// ???????????????????????????????????????
                    predicates.add(criteriaBuilder.equal(root.get("xusName"), xusName));
                }
                if (financialTypeNow!=null) {// ???????????????????????????????????????????????????
                    predicates.add(criteriaBuilder.equal(root.get("financialTypeNow"), financialTypeNow));
                }
                  //?????????????????????
                    predicates.add(criteriaBuilder.equal(root.get("flag"), flag));

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return page;
    }

    @Override
    public void updatePersonFinancial(List<PersonFinancialViewQueryCnd> personFinancialViewDTO) {
//        List<PersonFinancialViewDO> personFinancialViewDOList = iGenerator.convert(personFinancialViewDTO, PersonFinancialViewDO.class);
//        List<PersonFinancialViewDO> personFinancialViewDOOldList = new ArrayList<>();
        //?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
        for(PersonFinancialViewQueryCnd personFinancialViewDO :personFinancialViewDTO){
//            Optional<PersonFinancialViewDO> optional = personFinancialViewDao.findById(personFinancialViewDO.getPersonId());
//            PersonFinancialViewDO personFinancialViewOld = optional.get();
//            if(personFinancialViewOld.getPersonId()==personFinancialViewDO.getPersonId()){
//                personFinancialViewDO.setFinancialTypeNow(personFinancialViewOld.getFinancialTypeAfter());
                personAttributeDao.updateInfo(personFinancialViewDO.getPersonId(),personFinancialViewDO.getFinancialTypeAfter());
//                personFinancialViewDOOldList.add(personFinancialViewDO);
//            }
        }
//        personFinancialViewDao.saveAll(personFinancialViewDOOldList);

    }
}
