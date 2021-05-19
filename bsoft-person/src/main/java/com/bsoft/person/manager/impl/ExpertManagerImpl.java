package com.bsoft.person.manager.impl;

import com.bsoft.common.validate.ValidateUtil;
import com.bsoft.person.dao.primary.ExpertDao;
import com.bsoft.person.dao.primary.ExpertViewDao;
import com.bsoft.person.entity.primary.ExpertDO;
import com.bsoft.person.entity.primary.ExpertViewDO;
import com.bsoft.person.manager.ExpertManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class ExpertManagerImpl implements ExpertManager {
    @Autowired
    private ExpertDao expertDao;
    @Autowired
    private ExpertViewDao expertViewDao;
    @Override
    public Boolean isExpert(String personId) {
        List<ExpertDO> expert = expertDao.findByExpertId(personId);
        if(!expert.isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public List<ExpertViewDO> getAllExpert() {
        return expertViewDao.findAll();
    }

    @Override
    public List<ExpertDO> getExpertWithType(Integer type) {
        List<ExpertDO> result = expertDao.findAll(new Specification<ExpertDO>() {
            @Override
            public Predicate toPredicate(Root<ExpertDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = null;
                if(type.equals(0) || type == null){

                }else{
                    predicate = criteriaBuilder.equal(root.get("type"),type);
                }
                return predicate;
            }
        });
        return result;
    }

    @Override
    @Transactional
    public ExpertDO saveExpert(ExpertDO expertDO) {
        ValidateUtil.check(expertDO);
        return expertDao.save(expertDO);
    }

    @Override
    public List<ExpertViewDO> getExperts(String context) {
        Sort sort = Sort.by("id");
        List<ExpertViewDO> result = expertViewDao.findAll(new Specification<ExpertViewDO>() {
            @Override
            public Predicate toPredicate(Root<ExpertViewDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if(StringUtils.isBlank(context)) return null;
                Predicate predicate1 = criteriaBuilder.like(root.get("expertName"),"%"+context+"%");
                Predicate predicate2 = criteriaBuilder.like(root.get("dept"),"%"+context+"%");
                Predicate predicate3 = criteriaBuilder.like(root.get("pinyin"),"%"+context+"%");
                return criteriaBuilder.or(predicate1,predicate2,predicate3);
            }
        },sort);
        return result;
    }

    @Override
    public void removeExpert(Integer id) {
        expertDao.deleteById(id);
    }


}
