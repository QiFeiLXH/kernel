package com.bsoft.person.manager.impl;

import com.bsoft.common.manager.FilerServerManager;
import com.bsoft.person.dao.primary.KnowledgeDao;
import com.bsoft.person.dao.primary.KnowledgeNumViewDao;
import com.bsoft.person.entity.primary.KnowledgeDO;
import com.bsoft.person.entity.primary.KnowledgeNumViewDO;
import com.bsoft.person.manager.KnowledgeManager;
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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class KnowledgeManagerImpl implements KnowledgeManager {
    @Autowired
    private KnowledgeDao knowledgeDao;
    @Autowired
    private KnowledgeNumViewDao knowledgeNumViewDao;
    @Autowired
    private FilerServerManager filerServerManager;
    @Override
    public KnowledgeDO saveKnowledge(KnowledgeDO knowledge) {
        return knowledgeDao.save(knowledge);
    }

    @Override
    public List<KnowledgeDO> saveKnowledges(List<KnowledgeDO> konwledges) {
        if(konwledges == null){return null;}
        return knowledgeDao.saveAll(konwledges);
    }

    @Override
    public List<KnowledgeDO> getKnowledges(String personId) {
        return knowledgeDao.findByPersonId(personId);
    }

    @Override
    public Page<KnowledgeNumViewDO> getKnowledgeNumList(String deptId, String inputContent, Integer pageNo, Integer pageSize) {
        Sort sort = Sort.by("personId").descending();
        Pageable pageable = PageRequest.of(pageNo-1,pageSize,sort);
        Page<KnowledgeNumViewDO> pages = knowledgeNumViewDao.findAll(new Specification<KnowledgeNumViewDO>() {
            @Override
            public Predicate toPredicate(Root<KnowledgeNumViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(deptId)) {
                    predicates.add(criteriaBuilder.equal(root.get("deptId"), deptId));
                }
                if (StringUtils.isNotBlank(inputContent)) {
                    Predicate c1 = criteriaBuilder.like(root.get("simpleCode"),"%"+inputContent+"%");
                    Predicate c2 = criteriaBuilder.like(root.get("simpleCode"),"%"+inputContent.toLowerCase()+"%");
                    Predicate c3 = criteriaBuilder.like(root.get("personName"),"%"+inputContent+"%");
                    predicates.add(criteriaBuilder.or(c1,c2,c3));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return pages;
    }

    @Override
    public Page<KnowledgeDO> getPersonalKnowledgeList(String personId, Integer pageNo, Integer pageSize) {
        Sort sort = Sort.by("getDate").descending().by("id").descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        Page<KnowledgeDO> pages = knowledgeDao.findAllByPersonId(personId, pageable);
        List<KnowledgeDO> knowledgeList = pages.get().collect(Collectors.toList());

//         根据附件id查询设置附件名
        setEnclosureName(knowledgeList);
        return pages;
    }

    private void setEnclosureName(List<KnowledgeDO> knowledgeList) {
        knowledgeList.forEach(knowledgeDO -> {
            if (knowledgeDO.getEnclosure() != null) {
                knowledgeDO.setEnclosureName(filerServerManager.get(knowledgeDO.getEnclosure()).getFileName());
            }
        });
    }
}
