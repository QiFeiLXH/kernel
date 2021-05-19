package com.bsoft.cost.manager.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.validate.ValidateUtil;
import com.bsoft.cost.condition.SubsidyStandardQueryCnd;
import com.bsoft.cost.dao.primary.SubsidyStandardDao;
import com.bsoft.cost.dao.primary.SubsidyStandardViewDao;
import com.bsoft.cost.entity.primary.SubsidyStandardDO;
import com.bsoft.cost.entity.primary.SubsidyStandardViewDO;
import com.bsoft.cost.manager.SubsidyStandardManager;
import com.bsoft.exception.ServiceException;
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
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/11/19 17:37
 * @Description:
 */
@Component
public class SubsidyStandardManagerImpl implements SubsidyStandardManager {

    @Autowired
    private SubsidyStandardViewDao standardViewDao;
    @Autowired
    private SubsidyStandardDao standardDao;
    @Autowired
    private GeneratorUtil generatorUtil;
    @Autowired
    private ServerDateManager serverDateManager;

    @Override
    public void saveSubsidyStandard(SubsidyStandardDO standardDO) {
        this.checkIsHaveStandard(standardDO);
        ValidateUtil.check(standardDO);
        standardDao.save(standardDO);
    }

    //判断该年度是否已有 在用 的津贴标准
    private void checkIsHaveStandard(SubsidyStandardDO standardDO){
        Integer id = 0;
        if (standardDO.getId() != null){
            id = standardDO.getId();
        }
        if (standardDO.getState().equals(0)){
            if (standardDO.getFlag().equals(1)){//个人
                String personId = standardDO.getPersonId();
                List<SubsidyStandardViewDO> list = standardViewDao.findAllByPersonIdAndStateAndFlagAndIdNot(personId,0,1,id);
                if (list.size() > 0){
                    throw new ServiceException("该员工已有津贴标准");
                }
            }
            if (standardDO.getFlag().equals(2)){//项目
                String projectId = standardDO.getProjectId();
                List<SubsidyStandardViewDO> list = standardViewDao.findAllByProjectIdAndStateAndFlagAndIdNot(projectId,0,2,id);
                if (list.size() > 0){
                    throw new ServiceException("该项目已有津贴标准");
                }
            }
            if (standardDO.getFlag().equals(3)){//地区
                String county = standardDO.getCounty();
                List<SubsidyStandardViewDO> list = standardViewDao.findAllByCountyAndStateAndFlagAndIdNot(county,0,3,id);
                if (list.size() > 0){
                    throw new ServiceException("该地区已有津贴标准");
                }
            }
        }
    }

    @Override
    public Page<SubsidyStandardViewDO> findSubsidyStandardList(SubsidyStandardQueryCnd cnd) {
        Sort sort = Sort.by("applydate").descending().and(Sort.by("id").descending());
        Pageable pageable = PageRequest.of(cnd.getPageNo()-1,cnd.getPageSize(),sort);
        Page<SubsidyStandardViewDO> page = standardViewDao.findAll(new Specification<SubsidyStandardViewDO>(){

            @Override
            public Predicate toPredicate(Root<SubsidyStandardViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                Integer flag = cnd.getFlag();
                predicates.add(criteriaBuilder.equal(root.get("flag"),flag));
                Integer state = cnd.getState();
                predicates.add(criteriaBuilder.equal(root.get("state"),state));
                String input = cnd.getInputContent();
                if (flag.equals(1) && input != null && !input.equals("")){//个人
                    Predicate c1 = criteriaBuilder.like(root.get("personId"), "%" + input + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("pycode"), "%" + input.toLowerCase() + "%");
                    predicates.add(criteriaBuilder.or(c1, c2));
                }
                if (flag.equals(2) && input != null && !input.equals("")){//项目
                    Predicate c1 = criteriaBuilder.like(root.get("projectName"), "%" + input + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("contractNo"), "%" + input + "%");
                    Predicate c3 = criteriaBuilder.like(root.get("projectPYCode"), "%" + input.toLowerCase() + "%");
                    predicates.add(criteriaBuilder.or(c1, c2, c3));
                }
                if (flag.equals(3) && input != null && !input.equals("")){//区域
                    Predicate c1 = criteriaBuilder.like(root.get("provinceText"), "%" + input + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("cityText"), "%" + input + "%");
                    Predicate c3 = criteriaBuilder.like(root.get("countyText"), "%" + input + "%");
                    predicates.add(criteriaBuilder.or(c1, c2, c3));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return page;
    }
}
