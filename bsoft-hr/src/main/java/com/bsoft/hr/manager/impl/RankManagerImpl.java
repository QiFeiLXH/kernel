package com.bsoft.hr.manager.impl;

import com.bsoft.common.entity.primary.PublicDicDO;
import com.bsoft.common.manager.FilerServerManager;
import com.bsoft.common.manager.PublicDicManager;
import com.bsoft.hr.dao.primary.RankDao;
import com.bsoft.hr.dao.primary.RankViewDao;
import com.bsoft.hr.entity.primary.RankDO;
import com.bsoft.hr.entity.primary.RankViewDO;
import com.bsoft.hr.manager.RankManager;
import com.bsoft.person.entity.primary.*;
import com.bsoft.person.manager.*;
import com.google.common.collect.Lists;
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
import java.util.*;
import java.util.stream.Collectors;

@Component
public class RankManagerImpl implements RankManager {
    @Autowired
    private RankDao rankDao;
    @Autowired
    private RankViewDao rankViewDao;
    @Autowired
    private WorkCertificateManager workCertificateManager;
    @Autowired
    private AwardManager awardManager;
    @Autowired
    private ContinueLearnManager continueLearnManager;
    @Autowired
    private KnowledgeManager knowledgeManager;
    @Autowired
    private PersonInfoManager personInfoManager;
    @Autowired
    private PublicDicManager publicDicManager;
    @Autowired
    private FilerServerManager filerServerManager;
    @Override
    public RankDO saveRank(RankDO rank) {
        return rankDao.save(rank);
    }

    @Override
    @Transactional
    public Integer saveRankAndOther(RankDO rank) {
        String personId = rank.getPersonId();
        rank.setExecDate(rank.getExecDate());
        List<AwardDO> awards = rank.getAward();
        if(awards != null){
            awards.stream().forEach(a->a.setPersonId(personId));
        }
        List<WorkCertificateDO> certificates = rank.getCertificate();
        if(certificates != null){
            certificates.stream().forEach(c->c.setPersonId(personId));
        }
        List<ContinueLearnDO> continueLearns = rank.getContinuelearn();
        if(continueLearns != null){
            continueLearns.stream().forEach(c->c.setPersonId(personId));
        }
        List<KnowledgeDO> knowledges = rank.getKnowledge();
        if(knowledges != null){
            knowledges.stream().forEach(k->k.setPersonId(personId));
        }
        workCertificateManager.saveWorkCertificates(certificates);
        awardManager.saveAwards(awards);
        knowledgeManager.saveKnowledges(knowledges);
        continueLearnManager.saveContinueLearns(continueLearns);
        PublicDicDO publicDicDO = publicDicManager.getValueWithName(3005,rank.getPostSequence());
        Integer rankSequence = null;
        if(publicDicDO != null){
            rankSequence = publicDicDO.getId();
            rank.setRankSequence(rankSequence);
        }
        RankDO rankDO = rankDao.save(rank);
        PersonInfoDO personInfoDO = personInfoManager.getPersonInfo(personId);
        personInfoDO.setRank(rank.getGrade());
        personInfoDO.setRankSequence(rankSequence);
        personInfoManager.savePersonInfo(personInfoDO);
        return rankDO.getId();
    }

    @Override
    public Page<RankViewDO> getRankList(Integer year, String deptId, String inputContent, Integer pageNo, Integer pageSize) {
        Sort sort = Sort.by("evalDate").descending()
                .and(Sort.by("id").descending());
        Pageable pageable = PageRequest.of(pageNo-1,pageSize,sort);
        Page<RankViewDO> pages = rankViewDao.findAll(new Specification<RankViewDO>() {
            @Override
            public Predicate toPredicate(Root<RankViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("year"), year)); // 绩效年份
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
        List<RankViewDO> rankList = pages.get().collect(Collectors.toList());
        // 根据ppt文件id设置ppt名称
        setRankpptName(rankList);

        return pages;
    }

    @Override
    public Date getNewestRankDate(String personId) {
        return rankDao.getNewestRankDate(personId);
    }

    /** 设置职级的申报ppt名称 */
    private void setRankpptName(List<RankViewDO> rankList) {
        rankList.forEach(rankViewDO -> {
            if (rankViewDO.getPptId() != null) {
                rankViewDO.setPptName(filerServerManager.get(rankViewDO.getPptId()).getFileName());
            }
        });
    }
}
